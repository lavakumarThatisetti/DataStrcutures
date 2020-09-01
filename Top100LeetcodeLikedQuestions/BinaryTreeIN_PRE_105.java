package Top100LeetcodeLikedQuestions;

public class BinaryTreeIN_PRE_105 {
    private int in = 0;
    private int pre = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder, Integer.MIN_VALUE);
    }
    private TreeNode build(int[] preorder, int[] inorder, int stop) {
        if (pre >= preorder.length) return null;

        if (inorder[in] == stop) {
            in++;
            return null;
        }
        TreeNode node = new TreeNode(preorder[pre++]);
        node.left = build(preorder, inorder, node.val);
        node.right = build(preorder, inorder, stop);
        return node;
    }

    public static void main(String[] args) {
        BinaryTreeIN_PRE_105 binaryTreeIN_pre_105=new BinaryTreeIN_PRE_105();
        int[] pre={3,9,20,15,7};
        int[] in={9,3,15,20,7};
        binaryTreeIN_pre_105.buildTree(pre,in);
    }
}
