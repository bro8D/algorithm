package LeetCode;

import java.util.Scanner;
//语法测试
public class test {//逆序输出字符串
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int n = s.length();
        char[] str = s.toCharArray();
        for(int i=n-1;i>=0;i--){
            System.out.print(str[i]);
        }

        int i = 2147483647;//2^31-1
    }
}
