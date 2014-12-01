BitBoot
=======
1. Version 1.0 12/01/2014 ~
2. Author: Lei Xia
3. Email: lxia1@stevens.edu

I. File List
============
1. main.java
2. hive.sql
3. mysql.sql
4. most_common.java
5. most_common_by_frequency.java
6. Node.java
7. Node_for_avg.java
8. word_length.java
9. year.java

Program can be built using default make argument in Eclipse/Intelliji IDEA

II.How to run
=============
1, For Java program, first locate the data file path, then compile the program,
simply run the program in the command line by typing following in the shell:
$java main [input_data_file_path]
or run the program in Eclipse or Intelliji IDEA by simply clicking the run button, then
follow the prompt of the program
2, For Hive query, first locate the data file in HDFS, then run the Hive script by
typing following:
$hive -e f hive.sql
3, For mysql script, the same as above

III, Project Detail
===================
1, Project Name: Google Ngram
2, Description: Analyze the ngram data from Google to find out all the detail of the data,including:
  (1), the information of all the words(min, max, med, avg, std, etc)
  (2), the information of all the words' frequency(min,max,med,avg,std,etc)
  (3), the information of all the words' year' count(min, max, med, avg, std,etc)
  (4), the most common words according to its years' count
  (5), the most common words according to its total frequency

3, Parameters:
Input: the file path of the data. Eg, >>java main ./file_path
Output: display of the result according to the user's choose

