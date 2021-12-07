package jeopardy

import nlp.CoreNLP.tokenizeAndLemmatize
import org.apache.lucene.analysis.core.WhitespaceAnalyzer
import org.apache.lucene.analysis.en.EnglishAnalyzer
import org.apache.lucene.analysis.standard.StandardAnalyzer
import org.apache.lucene.index.DirectoryReader
import org.apache.lucene.index.IndexReader
import org.apache.lucene.queryparser.classic.QueryParser
import org.apache.lucene.search.IndexSearcher
import org.apache.lucene.search.Query
import org.apache.lucene.search.similarities.ClassicSimilarity
import org.apache.lucene.store.Directory

fun searchFiles(index: Directory, querystr: String,
                isBM25: Boolean = true): String? {

    val analyzer = WhitespaceAnalyzer()
    val qContent: Query = QueryParser(content, analyzer).parse(
        QueryParser.escape(tokenizeAndLemmatize(querystr)))
    val qSections: Query = QueryParser(sections, analyzer).parse(
        QueryParser.escape(tokenizeAndLemmatize(querystr)))

    //println(querystr)
    val hitsPerPage = 20 // Even though we care only about the top result we'll
    //  calculate 20 results for performance analyses
    val reader: IndexReader = DirectoryReader.open(index)
    val searcher = IndexSearcher(reader)
    if (!isBM25)
        searcher.similarity = ClassicSimilarity()
    val docsContent = searcher.search(qContent, hitsPerPage)
    val docsSections = searcher.search(qSections, hitsPerPage)
    // docs.scoreScore are the hits we got from the search

//    println("Found " + docs.scoreDocs.size.toString() + " hits.")
//    docs.scoreDocs.forEachIndexed { i, it->
//        println("${i + 1}. ${searcher.doc(it.doc)[title]}\t${searcher.doc(it.doc)[content]}")
//    }

    // If content Score ALone is above a certain threshold
    // return now
    if(docsContent.scoreDocs[0].score >=17)
        return searcher.doc(docsContent.scoreDocs[0].doc)[title]


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


fun jeopardyQuery(
    index: Directory, topic: String, question: String,
    answer: List<String>,
    isBM25: Boolean = true
): Boolean {
    val concatQuery = "$topic $question"
    val ourAnswer = searchFiles(index, concatQuery, isBM25)

//    println("\n\nQuestion: $question\nAnswer: $ourAnswer\n Solution: " +
//            answer.toString()
//    )
    return answer.contains(ourAnswer)
}