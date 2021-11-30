package nlp

import edu.stanford.nlp.pipeline.CoreDocument
import edu.stanford.nlp.pipeline.StanfordCoreNLP
import java.util.*

fun tokenizeAndLemmatize(text: String): String {

    // set up pipeline properties
    val props = Properties()
    // set the list of annotators to run
    props.setProperty("annotators", "tokenize,ssplit,pos,lemma")
    // build pipeline
    val pipeline = StanfordCoreNLP(props)
    // create a document object
    val document: CoreDocument = pipeline.processToCoreDocument(text)
    // annotate
    pipeline.annotate(document)
    return document.tokens().joinToString(" ") { tok -> tok.lemma() }

}