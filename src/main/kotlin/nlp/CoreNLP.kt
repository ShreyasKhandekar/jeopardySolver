package nlp

import edu.stanford.nlp.pipeline.CoreDocument
import edu.stanford.nlp.pipeline.StanfordCoreNLP
import edu.stanford.nlp.simple.*
import java.util.*

/**
 * Core NLP
 * This object uses StanfordCoreNLP to lemmatize text. It uses the full API
 * in order to annotate the text using tokenize, ssplit, pos, and lemma.
 * It sets up all these pipelines only once since this is a slow process.
 * The same pipeline can be used multiple times throughout the program.
 * @constructor Create Core NLP Object and set up pipelines
 */
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

    /**
     * Tokenize and lemmatize
     * Takes in a text and lemmatizes the function using CoreNLP
     * @param text The text to lemmatize
     * @return The lemmatized text
     */
    fun tokenizeAndLemmatize(text: String): String {
//        // create a document object
//        val document: CoreDocument = pipeline.processToCoreDocument(text)
//        // annotate
//        pipeline.annotate(document)
//        return document.tokens().joinToString(" ") { tok -> tok.lemma() }
        return text
    }
}

/**
 * Simple NLP
 * It uses StanfordCoreNLP's Simple API to Lemmatize text
 * @constructor Create empty Simple n l p
 */
object SimpleNLP {

    /**
     * Tokenize and lemmatize
     * Takes in a text and lemmatizes the function using CoreNLP
     * It only lemmatizes the first 15 sentences of the text that it is passed
     * @param text The text to lemmatize
     * @return The lemmatized text
     */
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