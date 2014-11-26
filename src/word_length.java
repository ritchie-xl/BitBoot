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

    public static double find_avg(List<Integer> l){
        double sum = 0;
        double num = 0;

        for(Integer i:l){
            sum = sum + i;
            num ++;
        }
        return sum/num;
    }

    public static double find_std(List<Integer> l){
        double avg = find_avg(l);
        double sum = 0;
        double num = 0;
        for(Integer i:l){
            sum = sum + (i-avg)*(i-avg);
            num ++;
        }
        return Math.sqrt(sum/num);
    }

    public static void  word(String file_path) throws IOException{
        String file = file_path;
        String line = null;
        List<Integer> list = new ArrayList<Integer>();

        String current = null;
        String previous = null;
        int index = 0;

        try{
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            while((line = br.readLine())!=null){
                String[] terms = line.split("\t");
                current = terms[0];
                if(!(current.equals(previous))){
                    list.add(index,current.length());
                    index = index + 1;
                }
                previous = current;
            }
            Collections.sort(list);
            System.out.println("Min\tMax\tMed\tAvg\tStd");
            System.out.print(list.get(0));
            System.out.print("\t"+ list.get(list.size()-1));
            System.out.print("\t"+list.get(list.size()/2));
            System.out.printf("\t%.2f", find_avg(list));
            System.out.printf("\t%.2f\n", find_std(list));
        }catch(FileNotFoundException e){
            System.out.println("FIle Not Found!");
        }

    }
}
