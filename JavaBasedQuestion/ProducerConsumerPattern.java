package JavaBasedQuestion;


import java.util.LinkedList;

public class ProducerConsumerPattern {
    public static class PC{
            LinkedList<Integer> list = new LinkedList<>();
            int initialCapacity=2;
            public void produce() throws InterruptedException{
                int value= 0;
                while (true){
                    synchronized (this){
                        while (list.size()==initialCapacity)
                            wait();
                        list.add(value++);
                        notify();
                        Thread.sleep(1000);
                    }
                }
            }
        public void consume() throws InterruptedException{
            while (true){
                synchronized (this){
                    while (list.size()==0)
                        wait();
                    int val = list.removeFirst();
                    System.out.print(val+" ");
                    notify();
                    Thread.sleep(1000);
                }
            }
        }

    }
    public static void main(String[] args){
            final PC pc= new PC();
            Thread thread1 = new  Thread(() -> {
                try {
                    pc.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        Thread thread2 = new  Thread(() -> {
            try {
                pc.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread1.start();
        thread2.start();

    }
}
