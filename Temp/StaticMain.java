package Temp;

public class StaticMain {
    static void Java(){
        try{
            System.out.println("Insid eJava");
            throw new RuntimeException("Demo");
        }finally {
            System.out.println("Jqava finally");
        }
    }
    static void Python(){
        try{
            System.out.println("Insid Pyt");
            return;
        }finally {
            System.out.println("py finally");
        }
    }

    public static void main(String[] args) {
        try{
            Java();
        }catch (Exception e){
            System.out.println("Ex");
        }
        Python();
    }
}
