package Amazon;


import java.util.*;

public class VerticalOrderTraversalofBinaryTree {
    static class Node{
        int key;
        Node left;
        Node right;
        Node(int data)
        {
            key = data;
            left = null;
            right = null;
        }
    }
//    static TreeMap<Integer,PriorityQueue<Integer>> map = new TreeMap<>();
//    private static List<List<Integer>> verticalTraversal(Node root) {
//        List<List<Integer>> ans = new LinkedList<>();
//        verticalTraverseHelper(root,0,0);
//        System.out.println(map);
//        for (PriorityQueue<Integer> nodes : map.values()) {
//            ans.add(new ArrayList<>());
//            while (!nodes.isEmpty()) {
//                ans.get(ans.size() - 1).add(nodes.poll());
//            }
//        }
//
//        return ans;
//    }
//    private static void verticalTraverseHelper(Node root, int negVert, int posVert){
//        if(root==null) return;
//
//        if(map.get(negVert+posVert)==null){
//            map.put(negVert+posVert,new PriorityQueue<>());
//        }
//        if(map.containsKey(negVert+posVert)){
//            PriorityQueue<Integer> list = map.get(negVert+posVert);
//            list.add(root.key);
//            map.put(negVert+posVert,list);
//        }
//        verticalTraverseHelper(root.left,negVert-1,posVert);
//        verticalTraverseHelper(root.right,negVert,posVert+1);
//    }

    public static List<List<Integer>> verticalTraversal(Node root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        dfs(root, 0, 0, map);
        List<List<Integer>> list = new ArrayList<>();
        for (TreeMap<Integer, PriorityQueue<Integer>> ys : map.values()) {
            list.add(new ArrayList<>());
            for (PriorityQueue<Integer> nodes : ys.values()) {
                while (!nodes.isEmpty()) {
                    list.get(list.size() - 1).add(nodes.poll());
                }
            }
        }
        return list;
    }
    private static void dfs(Node root, int x, int y, TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map) {
        if (root == null) {
            return;
        }
        if (!map.containsKey(x)) {
            map.put(x, new TreeMap<>());
        }
        if (!map.get(x).containsKey(y)) {
            map.get(x).put(y, new PriorityQueue<>());
        }
        map.get(x).get(y).offer(root.key);
        dfs(root.left, x - 1, y + 1, map);
        dfs(root.right, x + 1, y + 1, map);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.left.right = new Node(8);
        root.right.right.right = new Node(9);
        System.out.println("Vertical Order traversal is");
        verticalTraversal(root);

    }
}
