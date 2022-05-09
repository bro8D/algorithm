package LeetCode.树.树的遍历;

import LeetCode.树.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class 前序遍历 {
    // 非递归形式，递归形式不会考的
    public static List<Integer> preorderTraversal(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        TreeNode node = root;
        while(!stack.isEmpty() || node != null) {
            while(node!=null) {
                ans.add(node.val);
                stack.offerFirst(node);
                node = node.left;
            }
            node = stack.pollFirst();
            node = node.right;
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
