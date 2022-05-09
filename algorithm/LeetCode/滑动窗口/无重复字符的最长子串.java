package LeetCode.滑动窗口;

import java.util.HashSet;
import java.util.Set;

public class 无重复字符的最长子串 {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<Character>();
        int ans =0,rk = 0;//rk右指针，i为左指针，ans为答案
        for(int i=0;i<s.length();i++){
            if(i!=0) set.remove(s.charAt(i-1));//滑动窗口，每次移动，左边都要移出set
            while(rk <s.length() && !set.contains(s.charAt(rk))) {
                set.add(s.charAt(rk));
                rk++;
            }
            ans = Math.max(ans,rk-i);
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "abcdabcabaa";
        System.out.println(new 无重复字符的最长子串().lengthOfLongestSubstring(s));//这里没搞内部类
    }
}
