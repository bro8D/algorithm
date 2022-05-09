package LeetCode.树.树的遍历;

import LeetCode.树.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class 从上到下打印二叉树3_之字形 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        Deque<TreeNode> que = new ArrayDeque<>();
        que.offerFirst(root);
        boolean odd = true;
        while(!que.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            int count = que.size();
            for(int i=0;i<count;i++) {
                if(odd) {
                    TreeNode node = que.pollFirst();
                    tmp.add(node.val);
                    if(node.left!=null) que.offerLast(node.left);
                    if(node.right!=null) que.offerLast(node.right);
                } else {
                    TreeNode node = que.pollLast();
                    tmp.add(node.val);
                    if(node.right!=null) que.offerFirst(node.right);
                    if(node.left!=null) que.offerFirst(node.left);
                }
            }
            ans.add(tmp);
            //Boolean取反语法一直不会
            odd = !odd;
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
