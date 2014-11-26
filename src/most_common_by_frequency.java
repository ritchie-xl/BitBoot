import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by ritchie on 11/23/14.
 */
public class most_common_by_frequency{

    public static List<Node> load_data(String file_path) throws IOException {
        String file = file_path;
        String line = null;
        List<Node> list = new ArrayList<Node>();
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String previous = null;
            String current = null;
            int index = -1;
            while ((line = br.readLine()) != null) {
                String[] terms = line.split("\t");
                current = terms[0];
                int number = Integer.parseInt(terms[2]);
//				System.out.println(current+" "+number);
                if (current.equals(previous)) {
                    list.get(index).setCount(list.get(index).getCount() + number);
                } else {
                    list.add(new Node(current, number));
                    index = index + 1;
                }
                previous = current;
            }
            br.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Can not find the file\n");
        }
        return list;
    }

    public static void ten_most_frequency(String file) throws IOException{
        List<Node> list = load_data(file);
        Collections.sort(list, new Node());
        Collections.reverse(list);
        int count = 0;
        System.out.println("The most 10 most common words by frequency are:");
        System.out.println("Word\tTotal Frequency:");
        for (Node n : list) {
            if (count < 10) {
                System.out.println(n.getWord() + "\t" + n.getCount());
                count++;
            }
        }

    }

    public static void frequency(String file) throws IOException{
        List<Node> list = load_data(file);
        double med = list.get(list.size()/2).getCount();

        double min = list.get(0).getCount();
        double max = list.get(0).getCount();
        double avg;
        double std;
        double sum=0;
        double total=0;

        for(Node n:list){
            double tmp = n.getCount();
            if(Double.compare(tmp,min) < 0) { min = tmp;}
            if(Double.compare(tmp,max) > 0) { max = tmp;}
            sum = sum + tmp;
            total ++;
        }

        avg = sum/total;
        double sum_std =0;

        for(Node n:list){
            sum_std = sum_std + (n.getCount()-avg)*(n.getCount()-avg);
        }

        std = Math.sqrt(sum_std/total);

        System.out.println("Min\tMax\tMed\tAvg\tStd");
        System.out.printf("%.0f\t%.0f\t%.0f\t%.2f\t%.2f\n",min,max,med,avg,std);
    }
}
