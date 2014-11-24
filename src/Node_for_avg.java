/**
 * Created by ritchie on 11/18/14.
 */
import java.util.Comparator;

public class Node_for_avg implements Comparator<Node_for_avg>,Comparable<Node_for_avg>{
    private String word;
    private int count;
    private double total;

    Node_for_avg(){

    }

    Node_for_avg(String n, int c, double t){
        word = n;
        count = c;
        total = t;
    }

    public String getWord(){
        return word;
    }

    public int getCount(){
        return count;
    }

    public void setCount(int n){
        count = n;
    }

    public double getTotal(){return total;}

    public void setTotal(double n){ total = n; }

    @Override
    public int compareTo(Node_for_avg n) {
        // TODO Auto-generated method stub
        return (this.word).compareTo(n.word);
    }

    @Override
    public int compare(Node_for_avg n1, Node_for_avg n2) {
        // TODO Auto-generated method stub
//        return (int)(n1.total/n1.count - n2.total/(double)n2.count);
        return 0;
    }

}