package LeetCode.分治法.全排列;

import java.util.ArrayList;
import java.util.List;

public class 字母大小写全排列 {
    //字符串顺序不能被打乱
    public static List<String> letterCasePermutation(String s) {
        List<StringBuilder> ans = new ArrayList<>();
        ans.add(new StringBuilder());
        for(char c : s.toCharArray()) {
            int n = ans.size();
            if(Character.isLetter(c)){
                for(int i=0;i<n;i++) {
                    ans.add(new StringBuilder(ans.get(i)));
                    ans.get(i).append(Character.toUpperCase(c));
                    ans.get(n+i).append(Character.toLowerCase(c));
                }
            } else {
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
