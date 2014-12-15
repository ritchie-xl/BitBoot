import java.io.*;
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

        // Read users' input and create the files for each column, named col1.txt, col2.txt, col3.txt.....
        System.out.println("Please enter how many column you want to split for the file: ");
        Scanner num = new Scanner(System.in);
        int numColumn = num.nextInt();
        String[] columnFiles = new String[numColumn];
        for(int i=0;i<numColumn;i++){
            String columnName = "col" + String.valueOf(i) + ".txt";
            columnFiles[i] = columnName;
        }

        // Parse all the data and save the data into multiple files
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

        System.out.println("Analysing the data, please wait.......");
        System.out.println("Col\tData\tMin\tMax\tMed\tAvg\tStd");
        int colNum = 0;
        for(String colFile: columnFiles){
            FileReader fr = new FileReader(colFile);
            BufferedReader br = new BufferedReader(fr);
            String term;
            if ((term = br.readLine())!=null){
                if(checkDatatype.isNumeric(term)){
                    System.out.print(colNum+"\t"+"Numeric"+"\t");
                    numeric.summarize(colFile);
                }else{
                    System.out.print(colNum+"\t"+"String"+"\t");
                    strings.summarize(colFile);
                }
            }
            colNum++;
        }
    }

}
