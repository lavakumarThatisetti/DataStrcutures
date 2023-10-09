package Karat;

import java.util.Map;
import java.util.TreeMap;

public class SparseVector {

    // TreeMap is used to maintain sorted order
    private final TreeMap<Integer, Double> sparseMap;
    private final int size;

    public SparseVector(int size) {
        this.size = size;

        // assigning empty TreeMap
        sparseMap = new TreeMap<Integer, Double>();
    }

    public void put(int index,double val){
        if(index<0 || index>size)
            throw new RuntimeException("Index Out Of bounds");
        // if value is zero, don't add to that index & remove any previously held value
        if (val == 0.0)
            sparseMap.remove(index);
            // if value is non-zero add index-value pair to TreeMap
        else
            sparseMap.put(index,val);
    }

    public double get(int index){
       // checking if index(i) is out of bounds
        if (index < 0 || index >= size)
            throw new RuntimeException("Error : Out of Bounds");

        // if index not found, it means the value is zero as
        // only non-zero entries are added to the Map
        return sparseMap.getOrDefault(index, 0.0);
    }

    public String toString(){
        return sparseMap.toString();
    }

    public double dot(SparseVector b){
        SparseVector a = this;

        // Dot product of Sparse Vectors whose lengths are different is not possible
        if (a.size != b.size)
            throw new RuntimeException( "Error : Vector lengths are not same");

        double sum = 0.0;

        // Traversing each sorted vector and getting product of consequent entries of the vectors
        if (a.sparseMap.size() <= b.sparseMap.size()) {
            for (Map.Entry<Integer, Double> entry : a.sparseMap.entrySet())
                if (b.sparseMap.containsKey(entry.getKey()))
                    sum += a.get(entry.getKey()) * b.get(entry.getKey());
        }

        // Traversing each sorted vector and getting product of consequent entries of the vectors
        else {
            for (Map.Entry<Integer, Double> entry : b.sparseMap.entrySet())
                if (a.sparseMap.containsKey(entry.getKey()))
                    sum += a.get(entry.getKey()) * b.get(entry.getKey());
        }
        return sum;
    }

    public SparseVector add(SparseVector b){
        SparseVector a = this;

        // Addition of Sparse Vectors whose lengths aredifferent is not possible
        if (a.size != b.size)
            throw new RuntimeException("Error : Vector lengths are not same");

        SparseVector c = new SparseVector(size);

        // Traversing and adding the two vectors a & b and constructing resultant Sparse Vector c
        for (Map.Entry<Integer, Double> entry : a.sparseMap.entrySet())
            c.put(entry.getKey(), a.get(entry.getKey()));

        for (Map.Entry<Integer, Double> entry : b.sparseMap.entrySet())
            c.put(entry.getKey(), b.get(entry.getKey()) + c.get(entry.getKey()));

        return c;
    }

    public double cos(SparseVector b){
       // Cosine =  this.dot(b) / (this.norm() * b.norm());
        SparseVector a = this;

        // Cosine of Sparse Vectors whose lengths aredifferent is not possible
        if (a.size != b.size)
            throw new RuntimeException("Error : Vector lengths are not same");

        return a.dot(b) / (a.norm()*b.norm());
    }

    public double norm(){
        double sum = 0.0;
        //norm(a) = sqrt(a[0]^2 + a[1]^2 + a[2]^2 + ...).

        for(Map.Entry<Integer, Double> entry: this.sparseMap.entrySet()){
            sum += Math.pow(entry.getValue(),2);
        }
        return Math.sqrt(sum);
    }

    public static void main(String[] args) {

        SparseVector v1 = new SparseVector(5);
        v1.put(0,4.0);
        v1.put(1,5.0);

        SparseVector v2 = new SparseVector(5);
        v2.put(1,2.0);
        v2.put(3,3.0);

        SparseVector v3 = new SparseVector(5);
        v2.put(1,2.0);
        v2.put(3,3.0);

        v3 = new SparseVector(2);
        System.out.println(v1.add(v2));
      //  System.out.println(v1.add(v3)); // Error

        System.out.println(v1.dot(v2));
       // System.out.println(v1.dot(v3)); //Error

        System.out.println(v1.cos(v2));
        //System.out.println(v1.cos(v3)); //Error
    }
}
