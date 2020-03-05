package test
import scala.collection.mutable

class TrieHandler {

  val root : Trie = Trie(' ', mutable.Map.empty, finish=false, mutable.Map.empty[String, Int])

  def addWord(word: String, index: Int, fileName: String): Unit = {
      addWord(word, index, fileName, root)
  }

    def addWord(word: String, index: Int, fileName: String, trie: Trie = root): Unit = {
    val c : Char = word.charAt(index)
    val finished = index==word.length-1
    trie.children.get(c) match {

      case Some(child) => {
        if (!finished) {
          addWord(word, index + 1, fileName, child)
        }
        else {
          trie.children
            .addOne(c -> child.copy(finish = true,
                                    filesOccurenceses = child.filesOccurenceses ++ mutable.Map(fileName -> 1).map
                                                        {case (k,v) => k -> (v + child.filesOccurenceses.getOrElse(k,0))}))
             }
      }

      case None => {
          val files = if (finished) mutable.Map(fileName -> 1) else mutable.Map.empty[String, Int]
          val child: Trie = Trie(c, mutable.Map.empty, finished, files)
          trie.children += (c -> child)
          if (!finished) addWord(word, index+1, fileName, child)
      }
    }

  }

  def findWord(word: String): mutable.Map[String, Int] = {
    findWord(word, 0)
  }

  def findWord(word: String, index: Int, trie: Trie = root): mutable.Map[String,Int] ={
    if (index==word.length) {
      if (trie.finish) trie.filesOccurenceses
        //word not found at all
      else mutable.Map.empty[String, Int]
    }
    else {
      trie.children.get(word.charAt(index)) match
        {
        case Some(child) => findWord(word, index+1, child)
        case None => mutable.Map.empty[String, Int]
      }
    }
    }
}
