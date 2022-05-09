package LeetCode.哈希表.缺失的第一个正数;

import java.util.HashSet;

public class Solution{
    public int firstMissingPositive(int[] nums) {
        //0分做法 直接用哈希求得
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<nums.length;i++) {
            set.add(nums[i]);
        }
        for(int i=1;i<=nums.length;i++){//这里要[1,length]，右闭，所以为<=才对
            if(!set.contains(i)){
                return i;
            }
        }
        return nums.length+1;
    }

    void swap(int[] nums,int index1,int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    //我自己手动写一个求哈希值的算法。
    public int firstMissingPositive_2(int[] nums) {//把数组当做哈希表，实际上哈希表本身就是一个数组。
        //我自己手动写一个求哈希值的算法。就是i = nums[i-1]  i=[1,n+1]
        for(int i=0;i<nums.length;i++) {
            //if 里 nums[i] != nums[nums[i]-1] 这个东西我想不到
            //一次for循环确实不够，它不能保证前边的数是正确的顺序，用while循环一定可以把数放在正确的循环上
            while(nums[i]<= nums.length && nums[i]>0 && nums[i] != nums[nums[i]-1])
                swap(nums,i,nums[i]-1);
        }
        for(int i=1;i<=nums.length;i++) {
            if(nums[i-1] == i) continue ;
            else return i;
        }
        return nums.length + 1;
    }
    public static void main(String[] args) {
        int[] nums = {3,4,-1,1};
        System.out.println(new Solution().firstMissingPositive(nums));
        System.out.println(new Solution().firstMissingPositive_2(nums));
    }
}

