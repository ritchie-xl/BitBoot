/**
 * Created by ritchie on 11/18/14.
 */
import java.util.Comparator;

public class Node implements Comparator<Node>,Comparable<Node>{
    private String word;
    private double count;

    Node(){

    }

    Node(String n, int c){
        word = n;
        count = c;
    }

    public String getWord(){
        return word;
    }

    public double getCount(){
        return count;
    }

    public void setCount(double n){
        count = n;
    }

    @Override
    public int compareTo(Node n) {
        // TODO Auto-generated method stub
        return (this.word).compareTo(n.word);
    }

    @Override
    public int compare(Node n1, Node n2) {
        // TODO Auto-generated method stub
        return Double.compare(n1.count,n2.count);
    }

}