# SearchEngine
This is special tool for optimised search in folder.

### Usage:
1.Clone repository </br>
2.Run "sbt" command inside </br>
3.Run command <b>runMain test.SimpleSearch directoryContainingTextFiles</b> </br>
where directoryContainingTextFiles - absolute path to the directory you want to search </br>
4.You'll be promted to enter the list of words separated by spaces.</br>
For example:</br>
<b>>david cat</b></br>
5.You'll get list of all files which contain at least 1 of the words with occurence percentage.</br>
<b>Note:</b> formula for percentage:</br>
<b>([number of words from list that file contains] / [whole number of words in list entered]) * 100</b> </br>
6.If you want to exit, enter <b>:exit</b> instead of the word</br>

repository contains also folder "testFolder" for unit tests, demos and dev tests
### Example:
<img src="images/usage.png"/>

Representation in memory:</br>
All the words are stored in modified Trie structure (https://en.wikipedia.org/wiki/Trie). </br>
</br> <b>Example structure of the trie:</b></br>
<img src="images/trie.png"/>


Each node contains char of current letter, map of child nodes, parameter "is-finished" (means ending of the word), and if "is-finished"==true, there's also map that contains names of files and number of occurences of this word in each file </br>
