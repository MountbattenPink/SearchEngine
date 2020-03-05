package test

import scala.collection.mutable
import scala.util.control.Breaks

object SimpleSearch extends App {

  val fileHandler = new FileHandler(args(0))
  val trieHandler = new TrieHandler

  fileHandler.wordToFileMapping(trieHandler.addWord)

  var inputString: String = ""

  val loop = new Breaks
  loop.breakable {
    while (true) {
      println("enter your words to search: ")
      inputString = scala.io.StdIn.readLine

      if (inputString==":exit") loop.break
      else {

        val wordArray = inputString.split(" ")
        val arrayLength = wordArray.length

        //fileName -> number of word occurences
        val occurencesInFiles: mutable.Map[String, Int] = mutable.Map.empty[String, Int]

        wordArray.groupBy(identity).mapValues(_.size).toList
          .foreach(entry => {
            val word = entry._1
            val count = entry._2

            occurencesInFiles ++= trieHandler.findWord(word).map { case (k, v) => k -> Math.min(v + occurencesInFiles.getOrElse(k, 0), count) }
          })

        occurencesInFiles.size match {
          case 0 => println("no matches found")
          case _ => occurencesInFiles.foreach(entry => println(s"${entry._1} : ${entry._2 * 100 / arrayLength}% "))
        }
        println()
      }
    }
  }
}