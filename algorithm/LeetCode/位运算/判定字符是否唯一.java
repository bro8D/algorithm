package LeetCode.位运算;

public class 判定字符是否唯一 {
    class Solution {
        public boolean isUnique(String astr) {
            int a = 0;//ans
            int b = 1;//用
            for(char ch : astr.toCharArray()) {
                int offset = ch - 'a';
                int c = b<<offset;
                if((a&c) != 0) {
                    return false;
                }
                a |= c;
            }
            return true;
        }
    }
    public static void main(String[] args) {
        String s = "leetcode";
        String s2=  "vz";//1<<25=33554432 没有越界 最多能左移30次，第31次越界，如果是负数的话，可以右移31次
        //1<<31 = 2,147,483,648 int已越界 换成long可以多算几个
        System.out.println(new 判定字符是否唯一().new Solution().isUnique(s2));
    }
}
