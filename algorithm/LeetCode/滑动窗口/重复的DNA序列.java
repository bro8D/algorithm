package LeetCode.滑动窗口;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class 重复的DNA序列 {//这道题滑动窗口的做法我暂时不会...
    static final int L = 10;
    class Solution {
                        public List<String> findRepeatedDnaSequences(String s) {
                            List<String> ans = new ArrayList<>();
                            HashMap<String, Integer> map = new HashMap<>();
                            int n = s.length();
                            for (int i = 0; i <= n - L; i++) {
                                String temp = s.substring(i,i+L);
                                map.put(temp,map.getOrDefault(temp,0)+1);
                            }
                            for(String str : map.keySet()) {
                                if(map.get(str)>1) {
                                    ans.add(str);
                }
            }
            return ans;
        }
    }
    public static void main(String[] args) {
        List<String> ans = new 重复的DNA序列().new Solution().findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAA12dssaxAAAAACCCCCAAAAACCCCCCAAAAAfdfds");
        System.out.println(ans);
    }
}
