package test
import scala.collection.mutable

case class Trie(c: Char, children: mutable.Map[Char,Trie], finish: Boolean, filesOccurenceses: mutable.Map[String,Int])
