package jeopardy

import org.apache.lucene.store.FSDirectory
import java.io.File
import java.nio.file.Paths
import kotlin.system.exitProcess


/**
 * Main
 * This is the main entry point for the code. It handles the parsing of
 * arguments and runs the appropriate command based on what the user wants.
 * Do learn how to use the flags because we assume the user is intelligent.
 * @param args The command line arguments
 */
fun main(args: Array<String>){
    if(args.isEmpty()){
        printUsage()
    } else if(args[0] == "-h" || args[0] == "--help"){
        printUsage()
        printHelp()
    } else {
        if(args.contains("-r") || args.contains("--reindex") ||
            !File(indexFile).exists()) {
            buildFullIndex()
            //buildSampleIndex()
        }
    }
    // Index should be ready for use now.
    val index = FSDirectory.open(Paths.get(indexFile))
    // See if we want to run tests
    if(args.contains("-t") || args.contains("--test")){
        // Run queries
        var correctCount = 0
        var totalCount = 0
        val reader = File(questionsPath).bufferedReader()
        var topic = reader.readLine()
        while(topic != null) {
            totalCount++
            val question = reader.readLine()
            val answer = reader.readLine()
            val answers = answer.split("|")
            val isBM25 = scoreFormulaIsBM25(args)

            if(jeopardyQuery(index,topic,question,answers,isBM25))
                correctCount++

            topic = reader.readLine()
            while(topic == "") {
                topic = reader.readLine()
            }
        }

        print("Total: $totalCount\nCorrect: $correctCount\nAccuracy:")
        println(correctCount/totalCount.toDouble()*100)

        reader.close()
    } else if(args.contains("-q") || args.contains("--query")){
        // Run User Queries till exit
        val isBM25 = scoreFormulaIsBM25(args)
        println("Welcome to Jeopardy Solver!")

        var question = "none"
        var topic = "none"
        while(question!="" && topic !=""){
            println("Enter topic")
            topic = readLine()!!
            println("Enter Question:")
            question = readLine()!!
            jeopardyQuery(index,topic,question, listOf<String>(),isBM25)
            println()
        }
    }
}

/**
 * Build sample index
 * This function builds the Index of just the small sample of wikipedia articles
 * contained in [resources/wiki-example.txt]
 */
fun buildSampleIndex() {
    buildIndex(listOf(sampleDataPath))
}

/**
 * Score formula is BM25
 * This function is for specifically handling the -s flag from the command
 * line.
 * It exits the program if the user inputs an unacceptable argument for
 * the formula.
 * @param args The command line arguments to the program
 * @return true If the user wants the scoring formula to be BM25, false
 *          if they want it to be tfidf.
 */
fun scoreFormulaIsBM25(args: Array<String>): Boolean {
    if(args.contains("-s") || args.contains("--score")){
        var s = args.indexOfFirst { it=="-s" }
        if(s==-1) s = args.indexOfFirst { it=="--score" }
        return when (args[s+1]) {
            "BM25" -> true
            "tfidf" -> false
            else -> {
                System.err.println("Malformed Score Formula")
                printUsage()
                printHelp()
                exitProcess(1)

            }
        }
    }
    return true
}

/**
 * Build full index
 * This function builds the Index of the full set of  wikipedia articles
 * contained in [resources/wiki-subset/]
 */
fun buildFullIndex() {
    val fileList = mutableListOf<String>()

    File(fullDatasetPath).walk().forEach {
        fileList.add("$it")
    }
    fileList.removeAt(0) // First element is just the directory name
    buildIndex(fileList)
}

/**
 * Print help
 * Prints help for the flags of this program. Explains command line arguments
 * and flag and what they mean, how to use them, and flag exclusivity.
 */
fun printHelp() {
    println("-q | --query\t\t\t\tQuery Mode. Cannot be used with -t")
    println("-r | --reindex\t\t\t\tReindex Files.")
    println("-t | --test\t\t\t\t\tRun Tests and Performance. Cannot be used with -q")
    println("-s scoreFormula |\n--score scoreFormula\t\tSet Score formula to " +
            "one of the following:\n\t\t\t\t\t\t\t\t" +
            "BM25: Uses BM25 scoring\n\t\t\t\t\t\t\t\t" +
            "tfidf: Use the vector space model of tf*idf scoring")
    println("-h | --help\t\t\t\t\tPrint this message. Cannot be used with any other " +
            "option")
}

/**
 * Print usage
 * Prints usage information
 */
fun printUsage() {
    println("Usage:\n\t JeopardySolver [-q] [-r]" +
            " [-t] [-s scoreFormula] [-h]")
}
