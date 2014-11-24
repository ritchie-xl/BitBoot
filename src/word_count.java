/**
 * Created by ritchie on 11/18/14.
 */
import com.sun.tools.corba.se.idl.InterfaceGen;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class word_count {
    public static void main(String args[]) throws IOException{
        String file = "/Users/ritchie/Desktop/bitbootcamp/sql/practise/week1/googlebooks.txt";
        String line = null;
        List<Node> list = new ArrayList<Node>();
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
                    list.get(index).setCount(list.get(index).getCount() + number) ;
                }else{
                    list.add(new Node(current, number));
                    index = index + 1;
                }
                previous = current;
            }
            Collections.sort(list, new Node());
            for(Node n:list){
                System.out.println(n.getWord()+' '+n.getCount());
            }
            br.close();
        }catch(FileNotFoundException ex){
            System.out.println("Can not find the file\n");
        }

    }

}
