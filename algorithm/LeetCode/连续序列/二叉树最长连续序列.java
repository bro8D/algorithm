package LeetCode.连续序列;

//Ctrl+Alt+L 自动对齐
public class 二叉树最长连续序列 {
    //Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) {this.val = val;}
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    class Solution {
        int maxLongest=0;
        public int longestConsecutive(TreeNode root) {
            if(root == null) return 0;
            dfs(root,0,root.val);
            return maxLongest;
        }

        void dfs(TreeNode root, int curLength, int curNum) {
            if (root == null) return;
            if(root.val == curNum + 1) curLength++;
            else {
                curLength = 1;
            }
            dfs(root.left,curLength,root.val);
            dfs(root.right,curLength,root.val);
            maxLongest = Math.max(maxLongest,curLength);
        }
    }

    public static void main(String[] args) {
        //这还得建树...好麻烦...
    }
}
