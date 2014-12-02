import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by ritchie on 11/24/14.
 */
public class word_length {

    // Compute the average value of a list
    public static double find_avg(List<Integer> list){ //TODO
        double sum = 0;//TODO
        double num = 0;
        //TODO double retVal;

        for(Integer i:list){
            sum = sum + i;
            num ++;//TODO list.size()
        }
        return sum/num;
    }

    // Compute the standard deviation of a list
    public static double find_std(List<Integer> l){ //TODO
        double avg = find_avg(l);
        double sum = 0;//TODO
        double num = 0;
        // TODO double retVal;
        for(Integer i:l){
            sum = sum + (i-avg)*(i-avg);
            num ++;
        }
        return Math.sqrt(sum/num);
    }

    //To-Do: comment
    public static void summarize(String filePath) throws IOException{
        String file = filePath;
        String line = null; // ToDO
        List<Integer> list = new ArrayList<Integer>();

        String current = null;
        String previous = null;
        int index = 0;
        //int min = 0;
        //int max = 0;

        try{
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            while((line = br.readLine())!=null){
                String[] terms = line.split("\t");
                current = terms[0]; //TODO uppercase
                if(!(current.equals(previous))){ // TODO unique of words
                    list.add(index,current.length());
                    index = index + 1;
                }
                previous = current;
            }
            Collections.sort(list);
            System.out.println("Min\tMax\tMed\tAvg\tStd");
            System.out.print(list.get(0));
            System.out.print("\t"+ list.get(list.size()-1));
            System.out.print("\t"+list.get(list.size()/2));//TODO check odd or even
            System.out.printf("\t%.2f", find_avg(list));//TODO
            System.out.printf("\t%.2f\n", find_std(list));//TODO
        }catch(FileNotFoundException e){
            System.out.println("FIle Not Found!");
        }

    }
}
