package Java8Features;



import java.io.*;

class Student implements Serializable{
    int id;
    String name;
    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

public class Serialization {
    public static void main(String[] args) {
        try {
            Student s = new Student(1, "Lava");
            FileOutputStream fout = new FileOutputStream("file.txt");
            ObjectOutputStream out=new ObjectOutputStream(fout);
            out.writeObject(s);
            out.flush();
            out.close();
            FileInputStream fin = new FileInputStream("file.txt");
            ObjectInputStream oin = new ObjectInputStream(fin);
            Student s2 = (Student)oin.readObject();
            System.out.println(s2.id+" "+s2.name);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
