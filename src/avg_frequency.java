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
public class avg_frequency {
    public static void main(String args[]) throws IOException {
        String file = "/Users/ritchie/Desktop/bitbootcamp/sql/practise/week1/googlebooks.txt";
        String line = null;
        List<Node_for_avg> list = new ArrayList<Node_for_avg>();
        try{
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String previous = null;
            String current = null;
            int index = -1;
            int count = 0;
            while((line = br.readLine())!=null){
                String[] terms = line.split("\t");
                current = terms[0];
                int number = Integer.parseInt(terms[2]);
//				System.out.println(current+" "+number);
                if(current.equals(previous)){
                    list.get(index).setCount(list.get(index).getCount() + 1);
                    list.get(index).setTotal(list.get(index).getTotal() + number);
                }else{
                    list.add(new Node_for_avg(current, 1,number));
                    index = index + 1;
                }
                previous = current;
            }
//            Collections.sort(list, new Node_for_avg());
            for(Node_for_avg n:list){
                System.out.println(n.getWord()+" : "+(int)(n.getTotal()/n.getCount()));
            }
            br.close();
        }catch(FileNotFoundException ex){
            System.out.println("Can not find the file\n");
        }

    }
}
