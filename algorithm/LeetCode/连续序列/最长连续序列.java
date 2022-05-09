package LeetCode.连续序列;

import java.util.HashSet;
import java.util.Set;

public class 最长连续序列 {
    class Solution {
        public int longestConsecutive(int[] nums) {
            Set<Integer> num_set = new HashSet<Integer>();
            for (int num : nums) {
                num_set.add(num);//利用set去重
            }

            int longestStreak = 0;//结果初始为0

            for (int num : num_set) {//遍历set
                if (!num_set.contains(num - 1)) {//如果num-1 不存在，则
                    int currentNum = num;//当前起始值为num
                    int currentStreak = 1;//当前最长子序列为1

                    while (num_set.contains(currentNum + 1)) {//顺序递增
                        currentNum += 1;//只要满足，则当前值为num+1
                        currentStreak += 1;//最长子序列长度也加1
                    }
                    //比较当前最长子串和之前的最长子串哪个长
                    longestStreak = Math.max(longestStreak, currentStreak);
                }
            }

            return longestStreak;//返回题目所求
        }
    }


    public static void main(String[] args) {
        int[] nums = {100,4,200,1,3,2};
        最长连续序列.Solution question= new 最长连续序列().new Solution();//调用内部类方法
        int ans = question.longestConsecutive(nums);
        System.out.println(ans);
    }
}
