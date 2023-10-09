package Java8Features;


class MyRunnable implements  Runnable{
    @Override
    public void run() {
        for (int i=0;i<100;i++){
            System.out.println("Child Thread");
        }
    }
}
public class ThreadingLambda {
    public static void main(String[] args) {
        MyRunnable r = new MyRunnable();
        Runnable runnable = ()->{
            for (int i=0;i<10;i++){
                System.out.println("Child Thread");
            }
        };
        Thread t =new Thread(runnable);
        t.start();
        for (int i=0;i<10;i++){
            System.out.println("Main Thread");
        }
    }
}
