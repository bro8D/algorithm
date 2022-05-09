package LeetCode.树;
//二叉树
public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;//这里要设置成public，不然没法直接调用

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
