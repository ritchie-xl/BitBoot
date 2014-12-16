import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class strings {

    // Compute the standard deviation of a list
    public static double findStd(Hashtable<String, Integer> table, double average){ //TODO
        double sum = 0;
        int num = 0;
        double retVal;
        for(Integer i : table.values()){
            sum = sum + (i-average)*(i-average);
            num ++;
        }
        retVal = Math.sqrt(sum/num);
        return retVal;
    }

    public static int findMed(Hashtable<String, Integer> table){
        int retVal;

        List<Integer> list = new ArrayList<Integer>(table.values());
        int size = list.size();
        int mid = size/2;
        if(mid == 0){
            retVal = (list.get(mid-1) + list.get(mid));
        }else{
            retVal = list.get(mid);
        }
        return retVal;
    }

    static Hashtable<String, Integer> table = new Hashtable<String, Integer>();
    // To find out the most 10 common word in the data
    public static void mostCommon(String filePath) throws IOException{

        String term;
//        int count = 0;
        PriorityQueue<String> PQ =
                new PriorityQueue<String>(100, new Comparator<String>()
                {
                    public int compare(String key1, String key2){
                        return table.get(key2) - table.get(key1);
                    }
                });

        try{
            FileReader fr = new FileReader(filePath);
            BufferedReader br = new BufferedReader(fr);

            while((term = br.readLine())!=null) {
                    String termLowercase = term.toLowerCase();

                    if (!table.containsKey(termLowercase)) {
                        table.put(termLowercase, 1);
                    } else {
                        table.put(termLowercase, table.get(termLowercase) + 1);
                    }
//                    count++;
            }
            Set<String> set = table.keySet();
            Iterator<String> itr = set.iterator();

            while(itr.hasNext()){
                PQ.add(itr.next());
            }

            for(int i=0;i<10;i++){
                String s = PQ.poll();
                //PQ.remove(s);
                System.out.println(s+" "+table.get(s));
            }
        }catch(FileNotFoundException ffe){
            System.out.println("File Not Found!");
        }
    }
    //To-Do: comment
    static Hashtable<String, Integer> list = new Hashtable<String, Integer>();
    public static void summarize(String filePath) throws IOException{
        int sum=0;
        int count = 1 ;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        String termLowercase;
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
