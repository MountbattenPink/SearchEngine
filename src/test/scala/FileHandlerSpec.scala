import java.io.File

import org.mockito.Mockito
import org.mockito.Mockito.verify
import org.scalatest.WordSpec
import test.{FileHandler, TrieHandler}
import org.mockito.Mockito.times
class FileHandlerSpec extends WordSpec {

  "FileHandler" should {
    val fileHandler = new FileHandler("testFolder")

      "find only .txt files" in {
        val expected = List(new File("testFolder/text.txt"))

        assert(fileHandler.listAllFiles.equals(expected))
      }

      "call adding word to Trie with correct parameters " in {
        val trieHandler: TrieHandler = Mockito.mock(classOf[TrieHandler])


        fileHandler.wordToFileMapping(trieHandler.addWord)

          verify(trieHandler).addWord("1", 0,"text.txt")
          verify(trieHandler).addWord("90", 0,"text.txt")
          verify(trieHandler).addWord("3", 0,"text.txt")
          verify(trieHandler).addWord("100", 0,"text.txt")
          verify(trieHandler, times(2)).addWord("test", 0,"text.txt")
      }
    }
}
