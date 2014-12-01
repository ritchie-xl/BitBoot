import java.io.IOException;
import java.util.Scanner;

/**
 * Created by ritchie on 11/26/14.
 */
public class main {

    public static void main(String[] args) throws IOException{

        // The file path of the data
        // Test Path
        //String file = "/Users/ritchie/Desktop/bitbootcamp/sql/practise/week1/googlebooks.txt";
        String file = args[0];

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
                word_length.word(file); // Execution Time: 30 sec
                break;
            case 2:
                // Computer the information of years
                year_avg.year(file); //Execution Time: 60 sec
                break;
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
