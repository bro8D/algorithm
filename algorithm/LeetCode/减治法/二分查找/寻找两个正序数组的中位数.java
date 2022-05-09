package LeetCode.减治法.二分查找;

public class 寻找两个正序数组的中位数 {
    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int n1 = nums1.length;
            int n2 = nums2.length;
            int totalLength = n1 + n2;
            int flag = ( (n1+n2) &1 )  == 1 ? 1:0;
            if(flag == 1) {
                int midIndex = totalLength/2;
                double ans = getKthElement(nums1,nums2,midIndex+1);
                return ans;
            } else {
                int midIndex1 = totalLength/2-1;
                int midIndex2 = totalLength/2;
                //这里要转double，必须除小数2.0 不能/2
                double ans=(getKthElement(nums1,nums2,midIndex1+1)+getKthElement(nums1,nums2,midIndex2+1))/2.0;
                return ans;
            }
        }

        public int getKthElement(int[] nums1,int[] nums2,int k) {//这里是找第K小的数，从前往后找的，删小数
            int n1 = nums1.length;
            int n2 = nums2.length;
            int index1 = 0;
            int index2 = 0;
            while(true) {
                if(index1 == n1) return nums2[index2+k-1];
                if(index2 == n2) return nums1[index1+k-1];
                if(k==1) return Math.min(nums1[index1],nums2[index2]);
                int half = k/2;
                int newIndex1 = Math.min(index1+half,n1) - 1;
                int newIndex2 = Math.min(index2+half,n2) - 1;
                if(nums1[newIndex1] <= nums2[newIndex2]){
                    k-= (newIndex1 - index1 + 1);
                    index1 = newIndex1 + 1 ;
                } else {
                    k-=(newIndex2 - index2 + 1);
                    index2 = newIndex2 + 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1,3,6};
        int[] nums2 = {2,4,5};
        System.out.println(new 寻找两个正序数组的中位数().new Solution().findMedianSortedArrays(nums1,nums2));
    }
}
