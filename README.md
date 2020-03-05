# SearchEngine
This is special tool for optimised search in folder.

## Usage:
1. Clone repository 
2. run "sbt" command inside
3. run command </br>
<b>>runMain test.SimpleSearch directoryContainingTextFiles</b> 
</br>
where directoryContainingTextFiles - absolute path to the directory you want to search
4. you'll be promted to enter the list of words separated by spaces. 
</br>
For example:
</br>
<b>>david cat</b>
5. you'll get list of all files which contain at least 1 of the words with occurence percentage.
</br>Note: formula for percentage:
</br>
<b>([number of words from list that file contains] / [whole number of words in list entered]) * 100</b>
6. if you want to exit, enter <b>:exit</b> instead of the word

## Representation in memory:
All the words are stored in modified Trie structure (https://en.wikipedia.org/wiki/Trie). 
</br> <b>Example structure f the trie:</b>
![]images/trie.png


Each node contains char of current letter, map of child nodes, parameter "is-finished" (means ending of the word), and if "is-finished"==true, there's also map that contains names of files and number of occurences of this word in each file
