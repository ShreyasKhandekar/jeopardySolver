package nlp

import edu.stanford.nlp.pipeline.CoreDocument
import edu.stanford.nlp.pipeline.StanfordCoreNLP
import edu.stanford.nlp.simple.*
import java.util.*


object CoreNLP {
    // set up pipeline properties
    private val props = Properties()
    private val pipeline: StanfordCoreNLP

    init {
        // set the list of annotators to run
        props.setProperty("annotators", "tokenize,ssplit,pos,lemma")
        // Turn off Logging
        //RedwoodConfiguration.current().clear().apply();
        // Turn error logging back on
        //RedwoodConfiguration.errorLevel().apply();
        // build pipeline
        pipeline = StanfordCoreNLP(props)
    }

    fun tokenizeAndLemmatize(text: String): String {
        // create a document object
        val document: CoreDocument = pipeline.processToCoreDocument(text)
        // annotate
        pipeline.annotate(document)
        return document.tokens().joinToString(" ") { tok -> tok.lemma() }
//        return text
    }
}

object NLP {

    fun tokenizeAndLemmatize(text: String): String {
        // create a document object
        val doc = Document(text)
        val lemmaSentences = mutableListOf<String>()
        var sentCount = 0
        for (sent in doc.sentences()) {  // Will iterate over all sentences
            lemmaSentences.add(sent.lemmas().joinToString(" "))
            if(sentCount>15)
                break
            sentCount++
        }

        return lemmaSentences.joinToString(" ")
    }
}