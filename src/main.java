import java.io.*;
import java.nio.Buffer;
import java.util.Scanner;

/**
 * Created by ritchie on 11/26/14.
 */

/* TODO
    1, check singleton in java
    2, Log4j
    3, jUnit
    4, hash table, heap, priority queue
    5, 3rd party library to summarize the data -- apache.mat/colt
    6, for median,check length is odd or even
    7, save the average before compute for std
    8, check the argument of main -- Done
    9, change the input of all the sub functions from the file to column
    10, change the name of all the sub functions to make it more readable
    11, add comment in the code
    12, when computing avg, check the list if it's empty
    13, change the logic of the program
    14, parse the data from right to left to avoid
    15, check the fill rate
 */
public class main {

    public static void main(String[] args) throws IOException{

        // The file path of the data
        // Todo : arguments -- Done
        String file = null;
        if(args.length == 0){
            System.out.println("Please input the file path of the dataset!");
            System.out.println("Eg: java main [filePath]");
            System.exit(1);
        }else{
            file = args[0];
        }
        // System.out.println(file);
        //String file = "/Users/ritchie/Desktop/bitbootcamp/sql/practise/week1/googlebooks.txt";

        // TODO : Parse the data column by column and save all the data into files

        // Read users' input and create the files for each column, named col1.txt, col2.txt, col3.txt.....
        System.out.println("Please enter how many column you want to split for the file: ");
        Scanner num = new Scanner(System.in);
        int numColumn = num.nextInt();
        String[] columnFiles = new String[numColumn];
        for(int i=0;i<numColumn;i++){
            String columnName = "col" + String.valueOf(i) + ".txt";
            columnFiles[i] = columnName;
        }

        /*
        for(String i: columnFiles){
            System.out.println(i);
        }
        */

        // Parse all the data and save the data into the columnFils
        String line;
        try{
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            while((line=br.readLine())!=null){
                String[] terms = line.split("\t");
                for(int i=0;i<terms.length;i++){
                    File columnFile = new File(columnFiles[i]);
                    // Create new file if not exists
                    if(!columnFile.isFile()){
                        columnFile.createNewFile();
                    }
                    // Append the column data in the columnFile
                    FileWriter fw = new FileWriter(columnFile.getName(),true);
                    BufferedWriter bw = new BufferedWriter(fw);
                    bw.write(terms[i]);
                    bw.write("\n");
                    bw.close();
                }
            }
        }catch(FileNotFoundException e){
            System.out.println("File Not Found!");
            System.exit(1);
        }


        // Prompt for options
        System.out.println("Please choose you option:");
        System.out.println("Find out the information of words' length: 1");
        System.out.println("Find out the information of years' count: 2");
        System.out.println("Find out the information of frequency: 3");
        System.out.println("Find out the most 10 common words by years: 4");
        System.out.println("Find out the most 10 common words by frequency: 5");
        System.out.println("Quit: 0");

        // Read users' option
        Scanner sn = new Scanner(System.in);
        int opt = sn.nextInt();
        System.out.println("The option you chose is " + opt);
        //Find the detail of the words
        switch (opt){
            case 0:
                // Quit the program
                System.out.println("System quit!");
                System.exit(1);
            case 1:
                // Compute all the information of words' length
                strings.summarize(file); // Execution Time: 30 sec -- ToDO
                break;
            case 2:
                // Computer the information of years
                numeric.year(file); //Execution Time: 60 sec //TODO change name of function
                break;                                         // TODO change the parameter of the input
            case 3:
                // Computer the information of the words' frequency
                most_common_by_frequency.frequency(file); // Execution Time: 35sec
                break;
            case 4:
                // Find out the most common words according to the years if apprears
                most_common.common(file); // Execution Time: 32 sec
                break;
            case 5:
                // Find out the most common words according to the frequency
                most_common_by_frequency.ten_most_frequency(file); // Execution Time 33 sec
                break;
            default:
                break;

        }

    }

}
