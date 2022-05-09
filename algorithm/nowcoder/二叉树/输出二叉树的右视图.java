package nowcoder.二叉树;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class 输出二叉树的右视图 {
    public static class Solution {
        public class TreeNode {
            int val;
            TreeNode left,right;
            TreeNode(int value){val = value;}
        }
        public TreeNode dfs(int[] xianxu,int[] zhongxu,int pre_start,int pre_end,int in_start,int in_end){
            if(pre_start>pre_end || in_start>in_end) return null;
            TreeNode root = new TreeNode(xianxu[pre_start]);
            for(int i=in_start;i<=in_end;i++) {
                if(zhongxu[i] == xianxu[pre_start]) {
                    root.left = dfs(xianxu,zhongxu,pre_start+1,pre_start+i-in_start,in_start,i-1);
                    root.right = dfs(xianxu,zhongxu,pre_start+i-in_start+1,pre_end,i+1,in_end);
                    break;
                }
            }
            return root;
        }
        public int[] solve (int[] xianxu, int[] zhongxu) {
            TreeNode root = dfs(xianxu,zhongxu,0,xianxu.length-1,0,zhongxu.length-1);
            Deque<TreeNode> que = new ArrayDeque<>();
            List<Integer> ans = new ArrayList<>();
            que.offerLast(root);
            while(!que.isEmpty()) {
                int count = que.size();
                for(int i=0;i<count;i++) {
                    TreeNode node = que.pollFirst();
                    if(node.left != null) que.offerLast(node.left);
                    if(node.right != null) que.offerLast(node.right);
                    if(i==count-1) ans.add(node.val);
                }
            }
            int[] ret = new int[ans.size()];
            for(int i=0;i<ans.size();i++) {
                ret[i] = ans.get(i);
            }
            return ret;
        }
    }

    public static void main(String[] args) {
        int[] xianxu = {1,2,4,5,3};
        int[] zhongxu = {4,2,5,1,3};
        Solution solution = new Solution();
        int[] ans = solution.solve(xianxu,zhongxu);
        for (int i : ans){
            System.out.print(i + ",");//这里有点小小问题，会多输出一个逗号，不知该如何解决。
        }
    }
}
