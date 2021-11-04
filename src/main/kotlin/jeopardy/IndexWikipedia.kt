package jeopardy

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


private fun addDocument(writer: IndexWriter, docName: String, docContent: String) {
    val doc = Document()
    doc.add(StringField("title", docName, Field.Store.YES))
    doc.add(TextField("content", docContent, Field.Store.YES))
    writer.addDocument(doc)
}

@Throws(IllegalStateException::class)
private fun parseDocuments(fileName: String, w: IndexWriter) {

    val reader = File(fileName).bufferedReader()

    var lastTitle: String? = null
    var contentAccumulator = ""

    var line = reader.readLine()
    while(line != null) {
        //println(line)
        if(line.startsWith("[[") && line.endsWith("]]")){
            // This is the title for a new document, so we must add the last one
            // to our index at this point
            if (lastTitle != null) {
                // We have something to add
                println(lastTitle + "\n" + contentAccumulator)
                addDocument(w, lastTitle, contentAccumulator)
            } else if(contentAccumulator != "") {
                throw IllegalStateException("Malformed Input")
            }
            lastTitle = line
            contentAccumulator = ""
        } else contentAccumulator += line

        line = reader.readLine()
    }
}

fun buildIndex(filePath: List<String>): Directory{
    val analyzer = StandardAnalyzer()
    val indexFile = "src/main/resources/index"
    val index: Directory = FSDirectory.open(Paths.get(indexFile))
    val config = IndexWriterConfig(analyzer)
    val writer = IndexWriter(index, config)
    filePath.forEach {
        parseDocuments(it, writer)
    }
    writer.close()
    return index
}
