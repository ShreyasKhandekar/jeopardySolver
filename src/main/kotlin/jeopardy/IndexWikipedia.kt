package jeopardy

import nlp.CoreNLP.tokenizeAndLemmatize
import org.apache.lucene.analysis.core.WhitespaceAnalyzer
import org.apache.lucene.analysis.en.EnglishAnalyzer
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
    if(docName.contains('['))
        println("Adding Document $docName")
    val doc = Document()
    doc.add(StringField(title, docName, Field.Store.YES))
    doc.add(TextField(sections,
        tokenizeAndLemmatize(docSections), Field.Store.YES))
    doc.add(TextField(content,
        tokenizeAndLemmatize(docContent), Field.Store.YES))
    writer.addDocument(doc)
//    println(" Title: ${doc.get(title)}")
//    println("Sections:\n\t ${doc.get(sections)}")
//    println("Content:\n\t ${doc.get(content)}")
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
        if(line.startsWith("[[") && line.endsWith("]]")
            && !line.startsWith("[[File:") && !line.startsWith("[[Image:")) {
            // This is the title for a new document, so we must add the last one
            // to our index at this point
            if (lastTitle != null) {
                // We might have something to add
//                println(
//                    "$lastTitle\n" + "$sectionTitleAccumulator\n" +
//                            contentAccumulator
//                )
                // Filter REDIRECT link only pages
                if(!contentAccumulator.trim().startsWith("#REDIRECT")) {
                    addDocument(
                        w, lastTitle,
                        sectionTitleAccumulator, contentAccumulator
                    )
                } else {
                    //System.err.println("Skipping Redirect file as above")
                }
            } else if(contentAccumulator != "" ||
                    sectionTitleAccumulator != "") {
                // This means we found content that does not belong to a title
                // because lastTitle is still null but content is not empty
//                throw IllegalStateException("Malformed Input. " +
//                        "Content without title")
            }

            lastTitle = line.substring(2..line.length-3) // Remove [[ ]]
            contentAccumulator = ""
            sectionTitleAccumulator = ""

        } else if (line.startsWith("==") && line.endsWith("==")) {
            // This is a section Title
            sectionTitleAccumulator += " ${line.filterNot{ c-> c=='=' }}"
        } else {
            // This is a line of content

            // Filter for [tpl] [/tpl]
            line =
                line.replace(
                    "[tpl]"," "
                ).replace(
                    "[/tpl]"," ")

            contentAccumulator += " $line"
        }

        line = reader.readLine()
    }

    reader.close()
}


fun buildIndex(filePath: List<String>): Directory{
    val analyzer = WhitespaceAnalyzer()
    val index: Directory = FSDirectory.open(Paths.get(indexFile))
    val config = IndexWriterConfig(analyzer)
    val writer = IndexWriter(index, config)
    filePath.forEach {
        println("Parsing $it")
        parseDocuments(it, writer)
    }
    writer.close()
    return index
}
