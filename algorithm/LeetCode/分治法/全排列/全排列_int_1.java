package LeetCode.分治法.全排列;

import java.util.ArrayList;
import java.util.List;

public class 全排列_int_1 {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(ans,nums,0);
        return ans;
    }
    public static void dfs(List<List<Integer>> ans,int[] nums,int start) {
        if(start == nums.length) {
            ArrayList<Integer> tmp = new ArrayList<>();
            for(int i: nums) {
                tmp.add(i);
            }
            ans.add(tmp);
            return;
        }
        for(int i=start;i<nums.length;i++) {
            swap(nums,start,i);
            dfs(ans,nums,start+1);
            swap(nums,start,i);
        }
    }
    public static void swap(int[] nums,int a,int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
    public static void main(String[] args) {
        int[] nums = {1,2};
        List<List<Integer>> ans = permute(nums);
        for(List<Integer> i : ans) {
            System.out.print(i);
        }
    }
}
