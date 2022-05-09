package LeetCode.树.树的遍历;

import LeetCode.树.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class 层序遍历 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Deque<TreeNode> que = new ArrayDeque<>();
        if(root == null) return ans;
        que.offerLast(root);
        while(!que.isEmpty()) {
            ArrayList<Integer> tmp = new ArrayList<>();
            int count = que.size();
            for(int i=0;i<count;i++) {
                TreeNode node = que.pollFirst();
                tmp.add(node.val);
                if(node.left!=null) que.offerLast(node.left);
                if(node.right!=null) que.offerLast(node.right);
            }
            ans.add(tmp);
        }
        return ans;
    }
    public static void main(String[] args) {

    }
}
