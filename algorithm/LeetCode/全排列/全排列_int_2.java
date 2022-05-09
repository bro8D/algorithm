package LeetCode.全排列;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class 全排列_int_2 {
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> tmp = new ArrayList<>();
        for (int num : nums) {
            tmp.add(num);
        }
        Collections.sort(tmp);//去重只需一次排序即可
        dfs(ans,tmp,0,tmp.size());
        return ans;
    }

    public static void dfs(List<List<Integer>> ans, ArrayList<Integer> nums, int start,int n) {
        if (start == n) {
            ans.add(new ArrayList<Integer>(nums));
        }
        //这个set只与一个结果集有关
        //不管这个dfs递归多少次，这个set只管本轮的 start~nums.size()-1
        //这道题还是没吃透
        HashSet<Integer> set = new HashSet<>();
        for(int i=start;i<nums.size();i++) {
            if(set.contains(nums.get(i))) continue;
            set.add(nums.get(i));
            swap(nums,start,i);
            dfs(ans,nums,start+1,n);
            swap(nums,start,i);
        }
    }

    public static void swap(ArrayList<Integer> nums, int a, int b) {
        nums.set(a,nums.set(b,nums.get(a)));
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2};
        List<List<Integer>> ans = permuteUnique(nums);
        for(List<Integer> i : ans) {
            System.out.println(i);
        }
    }
}
