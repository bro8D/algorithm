package LeetCode.分治法.全排列;

import java.util.ArrayList;
import java.util.List;

public class 字母大小写全排列 {
    //字符串顺序不能被打乱
    public static List<String> letterCasePermutation(String s) {
        List<StringBuilder> ans = new ArrayList<>();
        //当 S = "abc" 时 ，考虑字母 "a", "b", "c"
        //初始令 ans = [""]
        //依次更新
        // ans = ["a", "A"]，
        // ans = ["ab", "Ab", "aB", "AB"]，
        // ans = ["abc", "Abc", "aBc", "ABc", "abC", "AbC", "aBC", "ABC"]。
        ans.add(new StringBuilder());
        for(char c : s.toCharArray()) {
            //第一次进入，c=a n=1
            //2 c=b,n=2
            //3 c=c,n=4
            int n = ans.size();
            //如果下一个字符 c 是字母，将当前已遍历过的字符串全排列复制两份，
            // 在第一份的每个字符串末尾添加 lowercase(c)，
            // 在第二份的每个字符串末尾添加 uppercase(c)。
            if(Character.isLetter(c)){
                for(int i=0;i<n;i++) {
                    //第一次：n=1，i=0
                    //1 ans=[], []
                    //2 i=0,n=2,ans=[A],[a]
                    //2 ans=[A],[a],[A]
                    //2 i=1,n=2,ans=[AB],[a],[Ab],[a]
                    //3 i=0,n=4,ans=[AB],[aB],[Ab],[ab],[AB]
                    //3 i=1,n=4,ans=[ABc],[aB],[Ab],[ab],[ABC]
                    //...剩下的懒得推了，确实可以得到全部结果，但这么做的话，题解没法拓展，这个思路就只能解决这一道题...
                    ans.add(new StringBuilder(ans.get(i)));
                    //1 ans=[A],[]
                    //2 ans=[AB],[a],[A]
                    //2 ans=[AB],[aB],[Ab],[a]
                    //3 ans=[ABc],[aB],[Ab],[ab],[AB]
                    ans.get(i).append(Character.toUpperCase(c));
                    //1 ans=[A],[a]
                    //2 ans=[AB],[a],[Ab]
                    //2 ans=[AB],[aB],[Ab],[ab]
                    //3 ans=[ABc],[aB],[Ab],[ab],[ABC]
                    ans.get(n+i).append(Character.toLowerCase(c));
                }
            } else {
                //如果下一个字符 c 是数字，将 c 直接添加到每个字符串的末尾。
                //因为不是字母，所以不用开辟新的分支。
                for(int i=0;i<n;i++) {
                    ans.get(i).append(c);
                }
            }
        }
        List<String> finalans = new ArrayList<>();
        for(StringBuilder sb : ans) {
            finalans.add(sb.toString());
        }
        return finalans;
    }



    public static void main(String[] args) {
        String s = "ab1z";
        List<String> ans = letterCasePermutation(s);
        for(String ss : ans) {
            System.out.print(ss+" ");
        }
    }
}
