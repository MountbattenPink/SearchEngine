import org.scalatest.WordSpec
import test.{Trie, TrieHandler}

import scala.collection.mutable

class TrieHandlerSpec extends WordSpec {

  "TrieHandler" when {
    val trieHandler = new TrieHandler()

    "empty and adding new word" should {
      trieHandler.addWord("test", 0, "testFileName.txt", trieHandler.root)

      "add word correctly" in {
        val expected: Trie =
          Trie(' ', mutable.Map('t' ->
            Trie('t', mutable.Map('e' ->
              Trie('e', mutable.Map('s' ->
                Trie('s', mutable.Map('t' ->
                  Trie('t', mutable.Map.empty[Char, Trie], true, mutable.Map("testFileName.txt" -> 1))),
                  false, mutable.Map.empty[String, Int])),
                false, mutable.Map.empty[String, Int])),
              false, mutable.Map.empty[String, Int])),
            false, mutable.Map.empty[String, Int])

        assert(trieHandler.root.equals(expected))
      }

      "return output as expected if word found" in {
        val expected = mutable.Map("testFileName.txt" -> 1)
        assert(trieHandler.findWord("test").equals(expected))
      }

      "return output as expected if word not found" in {
        val expected = mutable.Map.empty[String, Int]
        assert(trieHandler.findWord("tes").equals(expected))
      }
    }
  }
}
