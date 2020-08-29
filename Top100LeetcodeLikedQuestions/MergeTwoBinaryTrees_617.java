package Top100LeetcodeLikedQuestions;


import java.util.Stack;

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
     }
      public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
          if (t1 == null)
              return t2;
          Stack< TreeNode[] > stack = new Stack < > ();
          stack.push(new TreeNode[] {t1, t2});
          while (!stack.isEmpty()) {
              TreeNode[] t = stack.pop();
              if (t[0] == null || t[1] == null) {
                  continue;
              }
              t[0].val += t[1].val;
              if (t[0].left == null) {
                  t[0].left = t[1].left;
              } else {
                  stack.push(new TreeNode[] {t[0].left, t[1].left});
              }
              if (t[0].right == null) {
                  t[0].right = t[1].right;
              } else {
                  stack.push(new TreeNode[] {t[0].right, t[1].right});
              }
          }
          return t1;
      }
  }
public class MergeTwoBinaryTrees_617 {
    public static void main(String[] args) {
        int[] arr1={1,3,2,5};
        int[] arr2={2,1,3,0,4,0,7};
        TreeNode t1=new TreeNode();
    }
}
