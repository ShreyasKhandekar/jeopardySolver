package jeopardy

import org.apache.lucene.analysis.standard.StandardAnalyzer
import org.apache.lucene.index.DirectoryReader
import org.apache.lucene.index.IndexReader
import org.apache.lucene.queryparser.classic.QueryParser
import org.apache.lucene.search.IndexSearcher
import org.apache.lucene.search.Query
import org.apache.lucene.search.ScoreDoc
import org.apache.lucene.search.similarities.ClassicSimilarity
import org.apache.lucene.store.Directory

fun searchFiles(index: Directory, querystr: String,
                isBM25: Boolean = true): Array<ScoreDoc> {

    val analyzer = StandardAnalyzer()
    val q: Query = QueryParser("content", analyzer).parse(querystr)

    println(querystr)
    val hitsPerPage = 10 // Even though we care only about the top result we'll
    //  calculate 10 results for performance analyses
    val reader: IndexReader = DirectoryReader.open(index)
    val searcher = IndexSearcher(reader)
    if (!isBM25)
        searcher.similarity = ClassicSimilarity()
    val docs = searcher.search(q, hitsPerPage)

    // docs.scoreScore are the hits we got from the search

    println("Found " + docs.scoreDocs.size.toString() + " hits.")
    docs.scoreDocs.forEachIndexed { i, it->
        println("${i + 1}. ${searcher.doc(it.doc)["title"]}\t${searcher.doc(it.doc)["content"]}")
    }

    return docs.scoreDocs
}

fun jeopardyQuestion(index: Directory, querystr: String,
                     isBM25: Boolean = true): ScoreDoc =
    searchFiles(index, querystr, isBM25)[0]
