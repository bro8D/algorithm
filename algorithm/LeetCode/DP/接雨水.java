package LeetCode.DP;

public class 接雨水 {
    public int trap(int[] height) {
        int ans = 0,len = height.length;
        if(len == 1) return ans;
        int[] left = new int[len];
        left[0] = height[0];
        int[] right = new int[len];
        right[len-1] = height[len-1];
        for(int i=1;i<len;i++) {
            left[i] = Math.max(left[i-1], height[i]);
        }
        for(int i = len-2;i>=0;i--) {
            right[i] = Math.max(right[i+1], height[i]);
        }
        for(int i=0;i<len;i++) {
            ans += Math.min(left[i], right[i]) - height[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,0,2,1,0,1,3,2,1,2,1}; //java的数组是真繁琐
        System.out.println(new 接雨水().trap(nums));
    }
}
