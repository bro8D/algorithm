package LeetCode.树.树的遍历;

import LeetCode.树.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class 层序遍历2 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
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
            //add(index,val);可以选择插在哪里，index=0实际上是头插。等价于其他STL的offerFirst()
            ans.add(0,tmp);
        }
        //如果没掌握上述STL的用法，就只能再开一个List，逆序存一遍了...
        // List<List<Integer>> ret = new ArrayList<>();
        // for(int i=ans.size()-1;i>=0;i--) {
        //     ret.add(ans.get(i));
        // }
        // return ret;
        return ans;
    }
}
