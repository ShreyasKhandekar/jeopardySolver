package jeopardy

import nlp.CoreNLP.tokenizeAndLemmatize
import org.apache.lucene.analysis.en.EnglishAnalyzer
import org.apache.lucene.index.DirectoryReader
import org.apache.lucene.index.IndexReader
import org.apache.lucene.queryparser.classic.QueryParser
import org.apache.lucene.search.IndexSearcher
import org.apache.lucene.search.Query
import org.apache.lucene.search.similarities.ClassicSimilarity
import org.apache.lucene.store.Directory

/**
 * Search files
 * This function takes in a Lucene index, a query, and the scoring function, and
 * returns the name of the top document based on the scoring strategy described
 * in the program file.
 * @param index The Lucene index
 * @param querystr The query string to search for
 * @param isBM25 If the scoring strategy is BM25, if false, we use tfidf
 * @return The top document based on the scoring strategy described
 */
fun searchFiles(index: Directory, querystr: String,
                isBM25: Boolean = true): String? {

    val analyzer = EnglishAnalyzer()
    // To search content
    val qContent: Query = QueryParser(content, analyzer).parse(
        QueryParser.escape(tokenizeAndLemmatize(querystr)))
    // To search sections
    val qSections: Query = QueryParser(sections, analyzer).parse(
        QueryParser.escape(tokenizeAndLemmatize(querystr)))

    //println(querystr)
    val hitsPerPage = 20 // Even though we care only about the top result we'll
    //  calculate 20 results for combining the scores of content and sections
    val reader: IndexReader = DirectoryReader.open(index)
    val searcher = IndexSearcher(reader)
    // Set scoring function to tfidf if we don't want to use BM25
    if (!isBM25)
        searcher.similarity = ClassicSimilarity()
    val docsContent = searcher.search(qContent, hitsPerPage)
    val docsSections = searcher.search(qSections, hitsPerPage)
    // docWhatever.scoreDocs are the hits we got from the search

//    println("Found " + docs.scoreDocs.size.toString() + " hits.")
//    docs.scoreDocs.forEachIndexed { i, it->
//        println("${i + 1}. ${searcher.doc(it.doc)[title]}\t${searcher.doc(it.doc)[content]}")
//    }

    // If content Score ALone is above a certain threshold
    // return now
    if(docsContent.scoreDocs[0].score >=10)
        return searcher.doc(docsContent.scoreDocs[0].doc)[title]
    // Note, for a threshold of 10, the EnglishAnalyzer index basically always
    // returns now because it always finds a document with a score above 10 in
    // the sample questions' dataset.

    // Else also incorporate sections score
    val docsContentMap = docsContent.scoreDocs.associate { it.doc to it.score }
    val docsSectionsMap =
        docsSections.scoreDocs.associate { it.doc to it.score }
    val unionMap = (docsContentMap.asSequence() + docsSectionsMap.asSequence())
        .distinct()
        .groupBy({ it.key }, { it.value })
        .mapValues { (_, values) -> values.sum() }
    val maxDoc = unionMap.maxByOrNull { it.value }

    return searcher.doc(maxDoc!!.key)[title]
}


/**
 * Jeopardy query
 * This function is called when we are asked a jeopardy query.
 * It uses the searchFiles function to carry out the search.
 * Using the arguments, it constructs the qeury string and returns if we got the
 * answer right.
 * @param index The Lucene index
 * @param topic The topic of the Jeopardy Question
 * @param question The text of the question
 * @param answer The answer to the question
 * @param isBM25 The scoring strategy to use
 * @return If the answering system answered correctly
 */
fun jeopardyQuery(
    index: Directory, topic: String, question: String,
    answer: List<String>,
    isBM25: Boolean = true
): Boolean {
    var clue = ""
    val concatQuery: String
    if(topic.contains("(Alex:")){
        val topicAndClue = topic.split("(Alex:")

        if(topicAndClue[1].endsWith(')')){
            clue = topicAndClue[1].substringBeforeLast(')')
        }
        concatQuery = "${topicAndClue[0]} $clue $question"
    } else
    concatQuery = "$topic $question"

    val ourAnswer = searchFiles(index, concatQuery, isBM25)

    println("\n\nQuestion: $question\nQuery: $concatQuery\nAnswer: $ourAnswer")
    if(answer.isEmpty())
        println("Solution: Unknown")
    else println("Solution: $answer")

    return answer.contains(ourAnswer)
}