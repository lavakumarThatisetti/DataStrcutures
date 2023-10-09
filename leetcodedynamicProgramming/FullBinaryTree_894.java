package leetcodedynamicProgramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class FullBinaryTree_894 {

    public static List<TreeNode> allPossibleFBT(int n) {
        Map<Integer, List<TreeNode>> cache = new HashMap<>();
        List<TreeNode> ans = new ArrayList<>();
        if(n == 1){
            ans.add(new TreeNode(0));
        }else if(n%2 ==1){
            for(int x =0;x<n;x++){
                int y = n-1-x;
                for(TreeNode left:allPossibleFBT(x)){
                    for(TreeNode right:allPossibleFBT(y)){
                        TreeNode node = new TreeNode(0);
                        node.left = left;
                        node.right = right;
                        ans.add(node);
                    }
                }
            }
        }
        cache.put(n, ans);
        return cache.get(n);
    }
    
    public static void main(String[] args) {
        System.out.println(allPossibleFBT(7));
    }
}
