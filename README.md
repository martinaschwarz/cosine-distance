# cosine-distance
Cosine Distance Calculator for Text Documents, Java

* This program is executed by calling the Runner class.

* Runner calls the Menu method which displays a command-line menu to the user. It asks for the path to two text files which will be read from the console via a Scanner. If at least one of the files isn't found, an error will be shown to the user, displaying the name of the missing file, and the program exits.

* If both files are located they will be processed and parsed by the Parser class: using a new Thread for each file, a rapidly searchable HashMap is created containing the hashCode for each word in the file and its frequency of occurrence. From there, the cosine distance is calculated.

* The output to the user shows both the cosine distance (as a decimal number) as well as the similarity (as a percentage). 
