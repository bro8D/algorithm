package LeetCode.哈希表.翻转罗马数字;


public class Solution {
    private int[] value = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private String[] str = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public String intToRoman(int num) {
        String ans ="";//String 不能写null，真的会输出null，可以写""
        for(int i=0;i<value.length;i++){
            int val = value[i];
            String s = str[i];
            while(num>=val){
                num-=val;
                ans+=s;
                if(num == 0) return ans;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().intToRoman(12));
    }
}
