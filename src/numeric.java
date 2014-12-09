import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class numeric {

    public static int findMedian(List<Integer> numList){
        int size = numList.size();
        int retVal;
        if(size%2 == 0){
            retVal = (numList.get(size/2) + numList.get(size/2-1))/2;
        }else{
            retVal = numList.get(size/2);
        }
        return retVal;
    }

    public static void summarize(String colFile) throws IOException{
        /*
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
            */
        int sum=0;
        int count=0;
        String term;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        List<Integer> numList = new ArrayList<Integer>();
        try{
            FileReader fr = new FileReader(colFile);
            BufferedReader br = new BufferedReader(fr);

            while((term = br.readLine())!=null){
                int number = Integer.parseInt(term);
                sum = sum + number;
                count ++;
                numList.add(number);
                if(number < min){
                    min = number;
                }

                if(number > max){
                    max = number;
                }
            }
            if(count == 0){
                System.out.println("The file is empty, please try another file!");
                System.exit(1);
            }
            double avg = sum / count;
            double std;
            double sumStd=0;

            for (Integer i : numList){
                sumStd = (i-avg)*(i-avg);
            }
            std = (double)Math.sqrt(sumStd/count);

            int med = findMedian(numList);

            System.out.printf("%d\t%d\t%d\t%.2f\t%.2f\n",min,max,med,avg,std);
        }catch(FileNotFoundException e){
            System.out.println("File Not Found!");
        }
    }
}
