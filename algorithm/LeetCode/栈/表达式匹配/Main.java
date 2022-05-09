package LeetCode.栈.表达式匹配;

import java.util.ArrayDeque;
import java.util.Deque;

public class Main {//这个思路是真的好，真的好呀
    public static int solve(String s) {
        s = s.trim();
        Deque<Integer> stk = new ArrayDeque<>();
        int number = 0;
        char sign = '+';
        for(int i=0;i<s.length();i++) {
            char ch = s.charAt(i);
            if(ch ==' ') continue;
            if(Character.isDigit(ch)){
                number = number*10 + ch - '0';
            }
            else if(ch == '(') {
                int j = i+1;
                int pair = 1;
                while(pair>0){
                    if(s.charAt(j)=='(') pair++;
                    else if(s.charAt(j)==')') pair--;
                    j++;
                }
                number = solve(s.substring(i+1,j-1));
                i = j-1;//本轮执行结束i+1 = j，不会重复读取括号
            }
            if(!Character.isDigit(ch) || i == s.length()-1) {
                if(sign == '+') {
                    stk.push(number);
                } else if(sign == '-') {
                    stk.push(number * -1);
                } else if(sign == '*') {
                    stk.push(stk.pop() * number);
                } else if(sign == '/') {
                    stk.push(stk.pop() / number);
                }
                number = 0;
                sign = ch;
            }
        }
        int ans = 0;
        while(!stk.isEmpty()){
            ans += stk.pop();
        }
        return ans;
    }
    public static void main(String[] args) {
        String s = "(2*(3-4))*5";//对的
        String ss = "(2*(3-4))*(5+4)*((5+4)*(2-3)+1)";//144
        System.out.println(solve(ss));
    }
}
