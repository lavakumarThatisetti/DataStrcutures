package problemsolving;

import java.util.HashMap;
import java.util.Stack;

public class OnlineStockSpan {
    Stack<HashMap<Integer,Integer>> st;
    int index;
    public OnlineStockSpan(){
        st=new Stack<>();
        index=-1;
    }
    public int next(int price) {

       index+=1;
       if(st.empty()){
            st.push((HashMap<Integer, Integer>) new HashMap<>().put(index,price));
            return index+1;
       }
       while(!st.empty() && st.peek().get(index)<=price){
           st.pop();
       }
       HashMap<Integer,Integer> hs=st.peek();

       st.push((HashMap<Integer, Integer>) new HashMap<>().put(index,price));
       return index-(Integer)hs.keySet().toArray()[0];
    }
    public static void main(String[] args) {

    }
}
