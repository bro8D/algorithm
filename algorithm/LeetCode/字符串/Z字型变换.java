package LeetCode.字符串;

public class Z字型变换 {
    class Solution {
        public String convert(String s, int numRows) {
            int n = s.length();
            if (numRows == 1 || numRows >= n) return s;//当n=1,numRows=1时，cycle=0,下面的for循环会进入死循环j+=0一直加...
            String ans = "";
            int cycle = numRows * 2 - 2;
            for (int i = 0; i < numRows; i++) {//i<n 把矩阵第i行的所有值都纳入，遍历一次，即可拿到变换后的字符串
                for (int j = 0; j + i < n; j += cycle) {//j+i<n 控制不越界，像我之前的j=i;j<n会越界
                    ans += s.charAt(i + j);//当前周期的第一个字符
                    if (0 < i && i < numRows - 1 && j + cycle - i < n) {//每个周期，首(0<i)尾(i<numRows-1)只能拿一个，其他位置可以拿两个。同时保证不能越界(j+cycle-i < n)
                        ans += s.charAt(j + cycle - i);//当前周期的第二个字符 要把这个规律推明白，才能写出来这个式子，小学数学，但是就是不好推...数学太差
                    }
                }
            }
            return ans;
        }
    }
/*
递推式： 因为是横向写入字符串，所以首尾每次写一个，中间部分每次写两个。
0             0+t                    0+2t                     0+3t
1      t-1    1+t            0+2t-1  1+2t            0+3t-1   1+3t
2  t-2        2+t  0+2t-2            2+2t  0+3t-2             2+3t
3             3+t                    3+2t                     3+3t
 */
    public static void main(String[] args) {
        String s = "PAYPALISHIRING";  //out: PAHNAPLSIIGYIR
        int n = 3;
        Solution solution = new Z字型变换().new Solution();
        String ans = solution.convert(s, n);
        System.out.println(ans);
    }
}