package jeopardy

import nlp.tokenizeAndLemmatize
import org.apache.lucene.analysis.standard.StandardAnalyzer
import org.apache.lucene.document.Document
import org.apache.lucene.document.Field
import org.apache.lucene.document.StringField
import org.apache.lucene.document.TextField
import org.apache.lucene.index.IndexWriter
import org.apache.lucene.index.IndexWriterConfig
import org.apache.lucene.store.Directory
import org.apache.lucene.store.FSDirectory
import java.io.File
import java.nio.file.Paths


private fun addDocument(writer: IndexWriter, docName: String,
                        docSections: String, docContent: String) {
    val doc = Document()
    doc.add(StringField(title, docName, Field.Store.YES))
    doc.add(TextField(sections,
        tokenizeAndLemmatize(docSections), Field.Store.YES))
    doc.add(TextField(content,
        tokenizeAndLemmatize(docContent), Field.Store.YES))
    writer.addDocument(doc)
}

@Throws(IllegalStateException::class)
private fun parseDocuments(fileName: String, w: IndexWriter) {

    val reader = File(fileName).bufferedReader()

    var lastTitle: String? = null
    var contentAccumulator = ""
    var sectionTitleAccumulator = ""

    var line = reader.readLine()
    while(line != null) {
        //println(line)
        if(line.startsWith("[[") && line.endsWith("]]")){
            // This is the title for a new document, so we must add the last one
            // to our index at this point
            if (lastTitle != null) {
                // We might have something to add

                // Filter REDIRECT link only pages
                if(contentAccumulator.trim().startsWith("#REDIRECT"))
                    continue

                println("$lastTitle\n" +
                        "$sectionTitleAccumulator\n" +
                        contentAccumulator
                )

                addDocument(w, lastTitle,
                    sectionTitleAccumulator, contentAccumulator)
            } else if(contentAccumulator != "" ||
                    sectionTitleAccumulator != "") {
                // This means we found content that does not belong to a title
                // because lastTitle is still null but content is not empty
                throw IllegalStateException("Malformed Input. " +
                        "Content without title")
            }

            lastTitle = line.substring(2..line.length-3) // Remove [[ ]]
            contentAccumulator = ""

        } else if (line.startsWith("==") && line.endsWith("==")) {
            // This is a section Title
            sectionTitleAccumulator += " ${line.removeSurrounding("==")}"
        } else {
            // This is a line of content

            // Filter for [tpl] [/tpl]
            line =
                line.replace(
                    "[tpl]"," "
                ).replace(
                    "[\\tpl]"," ")

            contentAccumulator += " $line"
        }

        line = reader.readLine()
    }
}

fun buildIndex(filePath: List<String>): Directory{
    val analyzer = StandardAnalyzer()

    val index: Directory = FSDirectory.open(Paths.get(indexFile))
    val config = IndexWriterConfig(analyzer)
    val writer = IndexWriter(index, config)
    filePath.forEach {
        parseDocuments(it, writer)
    }
    writer.close()
    return index
}
