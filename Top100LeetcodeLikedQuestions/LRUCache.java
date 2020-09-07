package Top100LeetcodeLikedQuestions;

import java.util.HashMap;

public class LRUCache {

    int capacity;
    HashMap<Integer,Node> map;
    Node head;
    Node tail;
    class Node{
        int key;
        int val;
        Node next;
        Node prev;
        Node(int key,int val){
            this.key=key;
            this.val=val;
            next=null;
            prev=null;
        }
    }
    public LRUCache(int capacity) {
        this.capacity=capacity;
        map=new HashMap<>();
        head=new Node(0,0);
        tail=new Node(0,0);
        head.next=tail;
        tail.prev=head;
    }

    public int get(int key) {
        if(map.containsKey(key)){
            Node node=map.get(key);
            remove(node);
            addFirst(head,node);
            return node.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node n = map.get(key);
            n.val = value;
            remove(n);
            addFirst(head, n);
            return;
        }
        Node node=new Node(key,value);
        if(capacity==0) return;
        addFirst(head,node);
        if(!(map.size()<capacity)){
            removeLast(tail,map);
        }
        map.put(key,node);
    }

    private void addFirst(Node head,Node node){
        node.next = head.next;
        head.next.prev = node;
        node.prev = head;
        head.next = node;
    }
    private void removeLast(Node tail,HashMap<Integer,Node> map){
        Node LNode=tail.prev;
        Node LSNode=LNode.prev;
        LNode.prev=null;
        LNode.next=null;
        LSNode.next=tail;
        tail.prev=LSNode;
        map.remove(LNode.key);

    }
    private void remove(Node node){
        Node prev = node.prev;
        Node next = node.next;
        node.prev = null;
        node.next = null;
        prev.next = next;
        next.prev = prev;
    }

    public static void main(String[] args) {
        LRUCache cache=new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // returns 1
        cache.put(3, 3);    // evicts key 2
        cache.get(2);       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        cache.get(1);       // returns -1 (not found)
        cache.get(3);       // returns 3
        cache.get(4);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
