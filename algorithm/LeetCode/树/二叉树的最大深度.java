package LeetCode.树;

public class 二叉树的最大深度 {
    public int maxDepth(TreeNode root) {
        //思路1：层序遍历 easy
        //思路2：深度优先遍历 5.9不会,误打误撞蒙对的
        return dfs(root,0);
    }
    public int dfs(TreeNode root,int depth) {
        if(root == null) return depth;
        return Math.max(dfs(root.left,depth+1),dfs(root.right,depth+1));
    }
    public static void main(String[] args) {

    }
}
