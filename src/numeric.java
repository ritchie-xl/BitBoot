import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.lang.Object;

/**
 * Created by ritchie on 11/24/14.
 */
public class numeric {
    public static void year(String file_path) throws IOException{
        String file = file_path;
        String line = null;
        List<Integer> year = new ArrayList<Integer>();

        try{
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String previous = null;
            String current = null;
            int count =0;
            int index = -1;

            while((line = br.readLine())!=null){
                String[] terms = line.split("\t");
                current = terms[0];
                if(current.equals(previous)){
                    count = count + 1;
                    year.set(index,year.get(index) + 1);
                }else{
                    year.add(1);
                    index = index + 1;
                }
                previous = current;
            }
            int med = year.get(year.size()/2);
            Collections.sort(year);
            int max = year.get(year.size()-1);
            int min = year.get(0);

            double sum = 0;
            int num = 0;
            for(Integer i:year){
                sum = sum + i;
                num = num + 1;
            }
            double avg = sum / num;
            double std;

            for (Integer i : year){
                sum = (i-avg)*(i-avg);
            }
            std = Math.sqrt(sum/num);

            System.out.println("Min\tMax\tMed\tAvg\tStd");
            System.out.print(min+"\t"+max+"\t"+med+"\t");
            System.out.printf("%.2f\t",avg);
            System.out.printf("%.2f\n",std);
        }catch(FileNotFoundException e){
            System.out.println("File Not Found!");
        }
    }
}
