package Temp;

import java.util.Hashtable;
import java.util.Vector;

public class HashMain {
    public static void main(String[] args) {
        int hack[] = new int[]{4,3,21,1};
        Vector<Integer> hacV=new Vector();
        Hashtable<Integer,String> hashtable = new Hashtable<>();
        hacV.addElement(1);
        hacV.addElement(2);

        hashtable.put(3,"Hi");
        hashtable.put(1,"Hello");
        System.out.println(hack[0]);
        System.out.println(hacV.elementAt(0));
        System.out.println(hashtable.get(1))
        ;
    }
}
