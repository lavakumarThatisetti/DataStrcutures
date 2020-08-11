package hackerearth;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MaxApartments {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int size_of_magor = Integer.parseInt(br.readLine().trim());
        String[] arr_elements_of_magor = br.readLine().split(" ");
        int[] elements_of_magor = new int[size_of_magor];
        for(int i_elements_of_magor = 0; i_elements_of_magor < arr_elements_of_magor.length; i_elements_of_magor++)
        {
            elements_of_magor[i_elements_of_magor] = Integer.parseInt(arr_elements_of_magor[i_elements_of_magor]);
        }

        int[] out_ = solve(size_of_magor, elements_of_magor);
        System.out.print(out_[0]);
        for(int i_out_ = 1; i_out_ < out_.length; i_out_++)
        {
            System.out.print(" " + out_[i_out_]);
        }

        wr.close();
        br.close();
    }
    static int[] solve(int size_of_magor, int[] elements_of_magor){
        List<Integer> arrayList=new ArrayList<>();
        for(int i=0;i<size_of_magor;i++){
            if(i+1< size_of_magor && elements_of_magor[i]==elements_of_magor[i+1]) {
                arrayList.add(elements_of_magor[i] * 2);
                i++;
            }
           else{
                arrayList.add(elements_of_magor[i]);
            }
        }
        for(int i=0;i<arrayList.size();i++)
            System.out.print(arrayList.get(i)+" ");
        System.out.println();
        int max_so_far=0;
        int n=arrayList.size();
        int maxdelete=0;
        for(int i=0;i<n;i++){
            if(arrayList.get(i)>0){
                max_so_far=max_so_far+arrayList.get(i);
            }else if(arrayList.get(i)<=0){
                if(i+1<n && arrayList.get(i-1)==arrayList.get(i+1)){

                    maxdelete++;
                    max_so_far=max_so_far+arrayList.get(i-1);
                }else{
                    maxdelete++;
                }
            }
        }
        return new int[]{arrayList.size(),max_so_far};
    }
}