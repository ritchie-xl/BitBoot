import java.io.IOException;
import java.util.Scanner;

/**
 * Created by ritchie on 11/26/14.
 */
public class main {

    public static void main(String[] args) throws IOException{

        // The file path of the data
        String file = "/Users/ritchie/Desktop/bitbootcamp/sql/practise/week1/googlebooks.txt";

        // Prompt for options
        System.out.println("Please choose you option:");
        System.out.println("Find out the information of words: 1");
        System.out.println("Find out the information of years: 2");
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
                System.out.println("System quit!");
                System.exit(1);
            case 1:
                word_length.word(file);
                break;
            case 2:
                year_avg.year(file);
                break;
            case 3:

                break;
            case 4:
                most_common.common(file);
                break;
            case 5:
                most_common_by_frequency.frequency(file);
                break;
            default:
                break;

        }

    }

}
