package JavaBasedQuestion;

import java.util.ArrayList;

public class ArrayListTest {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("String 1");
        arrayList.add("String 2");
        arrayList.add("String 3");

        // Convert the ArrayList to a String array
        String[] stringArray = arrayList.toArray(new String[arrayList.size()]);

        // Print the elements of the String array
        for (String str : stringArray) {
            System.out.println(str);
        }

        String[] stringArray1 = arrayList.toArray(new String[0]);

        // Print the elements of the String array
        for (String str : stringArray1) {
            System.out.println(str);
        }
    }
}
