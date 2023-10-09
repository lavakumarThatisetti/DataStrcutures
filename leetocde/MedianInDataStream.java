package leetocde;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianInDataStream {
    private PriorityQueue<Integer> small;
    private PriorityQueue<Integer> large;
    private boolean even = true;
    public MedianInDataStream() {
        small = new PriorityQueue<>(Collections.reverseOrder());
        large = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if(even) {
            large.offer(num);
            small.offer(large.poll());
        }else {
            small.offer(num);
            large.offer(small.poll());
        }
        even = !even;
    }

    public double findMedian() {
        if(even) {
            return (small.peek() + large.peek())/2.0;
        }else {
            return small.peek();
        }

    }

    public static void main(String[] args) {
        MedianInDataStream medianInDataStream = new MedianInDataStream();

        medianInDataStream.addNum(12);
        System.out.println(medianInDataStream.findMedian());
        medianInDataStream.addNum(10);
        System.out.println(medianInDataStream.findMedian());
        medianInDataStream.addNum(15);
        System.out.println(medianInDataStream.findMedian());
        medianInDataStream.addNum(16);
        System.out.println(medianInDataStream.findMedian());
    }
}
