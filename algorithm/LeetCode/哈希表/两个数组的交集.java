package LeetCode.哈希表;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class 两个数组的交集 {
    class Solution {
        public int[] intersection(int[] nums1, int[] nums2) {
            HashSet<Integer> integers = new HashSet<>();
            List<Integer> ans = new ArrayList<>();

            for(int i=0;i<nums1.length;i++) {
                integers.add(nums1[i]);
            }
            for(int k : nums2) {
                if(integers.contains(k)){
                    ans.add(k);
                    integers.remove(k);
                }
            }
            int tempL = ans.size(),i=0;
            int[] ret = new int[tempL];
            for(Integer k : ans) {
                ret[i++] = k;
            }
            return ret;
        }
    }

    public static void main(String[] args) {

    }
}
