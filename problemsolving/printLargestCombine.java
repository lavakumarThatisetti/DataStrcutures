package problemsolving;

import java.util.ArrayList;

public class printLargestCombine{

    private static void printLargest(ArrayList<String> arr){
        arr.sort((X, Y) -> (Y + X).compareTo(X + Y));
        for (String s : arr) System.out.print(s);
    }

    public static void main(String[] args) {
        ArrayList<String> arr = new ArrayList<>();
        arr.add("54");
        arr.add("570");
        arr.add("548");
        arr.add("60");
        printLargest(arr);
    }
}
