import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Created by ritchie on 11/24/14.
 */
public class strings {

    // Compute the standard deviation of a list
    public static double findStd(Hashtable<String, Integer> table, double average){ //TODO
        double sum = 0;//TODO -- Done
        int num = 0;
        // TODO double retVal;
        double retVal;
        for(Integer i : table.values()){
            sum = sum + (i-average)*(i-average);
            num ++;
        }
        retVal = (double)Math.sqrt(sum/num);
        return retVal;
    }

    public static int findMed(Hashtable<String, Integer> table){
        int retVal=0;

        List<Integer> list = new ArrayList<Integer>(table.values());
        int size = list.size();
        int mid = list.size()/2;
        if(mid == 0){
            retVal = (list.get(mid-1) + list.get(mid));
        }else{
            retVal = list.get(mid);
        }
        return retVal;
    }

    // To find out the most 10 common word in the data
    public void mostCommon(String filePath) throws IOException{

        Hashtable<String, Integer> table = new Hashtable<String, Integer>();
        String term;

        int count = 0;
        try{
            FileReader fr = new FileReader(filePath);
            BufferedReader br = new BufferedReader(fr);

            while((term = br.readLine())!=null) {
                if (count <= 100000) {
                    String termLowercase = term.toLowerCase();

                    if (!table.containsKey(termLowercase)) {
                        table.put(termLowercase, 1);
                    } else {
                        table.put(termLowercase, table.get(termLowercase) + 1);
                    }
                    count++;
                }else{ // Find the most common 100 in 100000 lines
                    PriorityQueue<Map<String, Integer>> PQ =
                            new PriorityQueue<Map<String, Integer>>(100, new Comparator<String>()
                            {
                                public int compare(String key1, String key2){
                                    return table.get(key1) - table.get(key2);
                                }
                            });

                }
            }
        }catch(FileNotFoundException ffe){
            System.out.println("File Not Found!");
        }

    }
    //To-Do: comment
    public static void summarize(String filePath) throws IOException{
        /*
        String line; // TODO -- Done
        // List<Integer> list = new ArrayList<Integer>();



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
        */

        int sum=0;
        int count = 1 ;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        String termLowercase;
        Hashtable<String, Integer> list = new Hashtable<String, Integer>();
        String term;

        try{
            FileReader fr = new FileReader(filePath);
            BufferedReader br = new BufferedReader(fr);


            while((term =br.readLine())!=null){

                termLowercase = term.toLowerCase();
                int tmp = termLowercase.length();

                if(!list.containsKey(termLowercase)) {
                    if (tmp < min) {
                        min = tmp;
                    }

                    if (tmp > max) {
                        max = tmp;
                    }

                    sum = sum + tmp;
                    count++;

                    list.put(termLowercase, tmp);
                }
            }
        }catch(FileNotFoundException ffe){
            System.out.println("File Not Found!");
        }

        double avg = sum/count;
        double std = findStd(list,avg);
        int med = findMed(list);
        System.out.printf("%d\t%d\t%d\t%.2f\t%.2f\n", min, max, med, avg, std);
    }


}
