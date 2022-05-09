package LeetCode.字符串;

public class 字符串相乘 {
    class Solution {
        public String multiply(String num1, String num2) {
            if(num1.equals("0") || num2.equals("0")){return "0";};
            int n1 = num1.length();
            int n2 = num2.length();
            int[] ans = new int[n1+n2];
            for(int i=n1-1;i>=0;i--){
                int x = num1.charAt(i) - '0';
                for(int j=n2-1;j>=0;j--){
                    int y = num2.charAt(j)-'0';
                    ans[i+j+1] += x*y;//每位都要乘n2次，所以要乘很多
                }
            }
            for(int i=n1+n2-1;i>0;i--){
                ans[i-1] +=ans[i]/10;
                ans[i]%=10;
            }
            int index = ans[0]==0 ? 1:0;
            StringBuffer ret = new StringBuffer();
            while(index<n1+n2){
                ret.append(ans[index]);
                index++;
            }
            return ret.toString();
        }
    }

    public static void main(String[] args) {
        String s1 = "123",s2 = "234";
        System.out.println(new 字符串相乘().new Solution().multiply(s1,s2));
    }
}
