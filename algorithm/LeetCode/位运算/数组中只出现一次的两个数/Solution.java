package LeetCode.位运算.数组中只出现一次的两个数;

public class Solution {
    public int[] FindNumsAppearOnce(int[] array) {
        int a_b = 0;
        for (int i = 0; i < array.length; i++) {
            a_b ^= array[i];//拿到a^b
        }
        int low_1 = a_b & (-a_b);//拿到a^b的最低位的1，利用这个1把array分成两组
        int a = 0, b = 0;
        for (int i = 0; i < array.length; i++) {
            if ((array[i] & low_1) != 0) a ^= array[i];
            else b ^= array[i];
        }
        return new int[]{a, b};//[]里不能加大小 [2]就错了
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 4, 3, 2};
        int[] ans = new Solution().FindNumsAppearOnce(array);
        for (int i = 0; i < 2; i++)
            System.out.print(ans[i]);
    }
}
