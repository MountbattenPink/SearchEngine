package test

import java.io.File
import scala.io.Source

class FileHandler(path: String) {

  private val rootFolder: File = new File(path)

  rootFolder.createNewFile()

  def wordToFileMapping(addWord: (String, Int, String) => Unit): Unit = {
    listAllFiles.foreach(file => {
      val bufferedSource = Source.fromFile(file)

      for {
        line <- bufferedSource.getLines().toList
        word <- line.split("[^a-zA-Z0-9]+").filter(w => w.length > 0)
      } yield {
        addWord(word, 0, file.getName)
      }
      bufferedSource.close()

    })
  }

  def listAllFiles: List[File] =
    rootFolder.listFiles.filter(file => file.isFile && file.getName.endsWith(".txt")).toList

}
