package Temp;

public class ThreadMain {
    public static void main(String[] args) {
        Runnable runnable = ()-> System.out.println(Thread.currentThread().getId());
        int a=2;
        int n = a+a*a-a;
        for(int i=0;i<n;i++){
            Thread obj=new Thread(runnable);
            obj.start();
        }
    }
}
