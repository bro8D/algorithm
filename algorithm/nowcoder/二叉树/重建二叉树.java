package nowcoder.二叉树;

import java.util.*;

class Solution {
    //结构体，与本体无关
    public class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int x) {
            val = x;
        }
    }

    //层序遍历与本题无关，单纯为了看看写的对不对
    public char[] cengxuReverse(TreeNode root) {
        Deque<TreeNode> que = new ArrayDeque<>();
        LinkedList<Character> list = new LinkedList<>();
        que.offerFirst(root);
        list.add((char) (root.val + '0'));
        while (!que.isEmpty()) {
            int count = que.size();
            for (int i = 0; i < count; i++) {
                TreeNode node = que.pollFirst();
                if (node.left != null) {
                    que.offerLast(node.left);
                    list.add((char) (node.left.val + '0'));
                } else list.add('#');
                if (node.right != null) {
                    que.offerLast(node.right);
                    list.add((char) (node.right.val + '0'));
                } else list.add('#');
            }
        }
        return list.toString().toCharArray();
    }

    //同上，dfs也与本题无关。
    public void dfs(TreeNode node) {
        if (node == null) {
            System.out.print("#" + " ");
            return;
        }
        System.out.print(node.val + " ");
        dfs(node.left);
        dfs(node.right);
    }

    //    public TreeNode reConstructBinaryTree(int[] pre, int[] vin) {
//        if(pre == null || pre.length == 0 || vin ==null || vin.length == 0 ) return null;
//        // key ： 中序遍历元素的值；
//        // value ： 中序遍历元素的值 对应的 下标
//        // 可以以O(1)的时间复杂度找到元素在中序遍历中对应的下标
//        HashMap<Integer, Integer> map = new HashMap<>();
//        for(int i=0;i<vin.length;i++) {
//            map.put(vin[i],i);
//        }
//        return process(pre,0,pre.length-1,0,vin.length-1,map);
//    }
//    public TreeNode process(int[] pre, int pl, int pr, int inl, int inr, HashMap<Integer,Integer> map) {
//        // 越界情况，没有二叉树存在，直接返回 null
//        if(pl>pr || inl>inr) return null;
//        // 只有一个元素，就是根节点，直接返回
//        if(pl==pr || inl==inr) return new TreeNode(pre[pl]);
//        // 前序遍历的第一个元素就是 根节点
//        TreeNode root = new TreeNode(pre[pl]);
//        // 找到 根节点在 中序遍历数组里的 下标
//        int inIndex = map.get(pre[pl]);
//        // 在有效的中序遍历范围里， 根节点左边的元素 都是属于 根节点的左子树
//        int leftTreeSize = inIndex - inl;
//        // 在左子树的有效范围里，生成左子树
//        root.left = process(pre, pl + 1, pl + leftTreeSize,
//                inl, inIndex - 1,
//                map);
//        // 在右子树的有效范围里，生成右子树
//        root.right = process(pre, pl + leftTreeSize + 1, pr,
//                inIndex + 1, inr,
//                map);
//        return root;
//    }
    //另一种更简洁的写法：背下边这个更简洁的写法
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        TreeNode root = reConstructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
        return root;
    }

    //前序遍历{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}
    private TreeNode reConstructBinaryTree(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn) {
        // 越界情况，没有二叉树存在，直接返回 null
        if (startPre > endPre || startIn > endIn)
            return null;
        // 前序遍历的第一个元素就是 根节点
        TreeNode root = new TreeNode(pre[startPre]);
        //
        for (int i = startIn; i <= endIn; i++)//这里是小于等于，因为endIn是length-1,是有效值。
            //用前序遍历找到的root，把中序遍历分成左右两颗数
            if (in[i] == pre[startPre]) {
                //左树 pre, start_pre+1 , start_pre + i - start_in   in, start_in, i-1
                //前序遍历{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}
                //左树：pre:2,4,7 下标为[1,3] ; in:4,7,2 下标为[0,2]
                // 前序遍历子树首尾靠中序来判断，它的左树长度=中序遍历的i-1-start_in,所以，起始为start_pre+1,结束为start_pre+1 +i-1-start_in=start_pre+i-start_in
                //1 = start_pre+1 ; 3 = start_pre+1(起点) +i-1-start_in(区间长度与中序遍历保持一致) = start_pre-start_in + i
                //0 = start_in ; 2 = i - 1 中序遍历就是root前为左，root后为右
                root.left = reConstructBinaryTree(pre, startPre + 1, startPre + i - startIn, in, startIn, i - 1);
                //右树
                //长度依然靠in来得到，为 [i+1,in.length-1]
                //in：start_in:i+1 end_in:in.length-1
                //pre: start_pre:start_pre-start_in+i(左子树结尾)+1 end_pre:pre.length-1
                root.right = reConstructBinaryTree(pre, startPre + i - startIn + 1, endPre, in, i + 1, endIn);
                //此处break减少无意义的for循环，找到root并分好左右子树后立马结束循环，不做多余判断，避免bug
                break;
            }

        return root;
    }

}

public class 重建二叉树 {
    public static void main(String[] args) {
        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] vin = {4, 7, 2, 1, 5, 3, 8, 6};
        Solution solution = new Solution();
        Solution.TreeNode head = solution.reConstructBinaryTree(pre, vin);
        char[] chars = solution.cengxuReverse(head);
        for (char c : chars) {
            System.out.print(c);
        }
    }
}
