package LeetCode.DP.单词拆分;


import java.util.*;

public class Solution {//调用类里的方法，记得将类实例化
     public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet(wordDict);//这个用法我就不会
        boolean dp[] = new boolean[s.length()+1];
        dp[0] = true;
        for(int i=1;i<=s.length();i++){
            for(int j=0;j<i;j++) {
                if(dp[j] && wordSet.contains(s.substring(j,i))){//substring是左闭右开，所以i=s.length()才行
                    dp[i] = true;
                    break;//?
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
//        String str = "leetcode";
////        String[] dict = { "leet","code"};//String数组直接定义，不用new
//        List<String > dict = new ArrayList<String>();
//        dict.add("leet");dict.add("code");
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        List<String > dict = new ArrayList<String>();
        while(in.hasNext()){//这里只能用Ctrl+Z结束...
            dict.add(in.next());
        }
        System.out.println(new Solution().wordBreak(str,dict) );
    }
}
