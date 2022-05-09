package LeetCode.树.路径和;

import LeetCode.树.TreeNode;

import java.util.*;

public class 二叉树中和为某一值的路径 {
    List<List<Integer>> ans = new LinkedList<>();
    //不能用List，List没法好好删除元素，remove()方法我不会用
//    List<Integer> temp = new LinkedList<>();
    Deque<Integer> path = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        dfs(root,target);
        return ans;
    }
    public void dfs(TreeNode root, int target) {
        if (root == null) {
            return;
        }
        path.offerLast(root.val);
        target -= root.val;
        if (root.left == null && root.right == null && target == 0) {
            //Deque可以直接转换成LinkedList，应该是因为Deque = new LinkedList的缘故
            ans.add(new LinkedList<Integer>(path));
        }
        dfs(root.left, target);
        dfs(root.right, target);
        path.pollLast();
    }

    public static void main(String[] args) {

    }

}
