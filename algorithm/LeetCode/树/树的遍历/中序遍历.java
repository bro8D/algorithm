package LeetCode.树.树的遍历;

import LeetCode.树.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class 中序遍历 {
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode node = root;
        while(!stack.isEmpty() || node !=null) {
            //while()中我5.9错误的写成了node.left != null 属于照猫画虎没画对，实际就是还不会
            while(node!=null) {
                stack.offerFirst(node);
                node = node.left;
            }
            node = stack.pollFirst();
            ans.add(node.val);
            node = node.right;
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
