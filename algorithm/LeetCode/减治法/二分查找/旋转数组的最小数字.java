package LeetCode.减治法.二分查找;

public class 旋转数组的最小数字 {
    public static int minArray(int[] numbers) {
        //二分查找找最小值
        int left = 0, right = numbers.length-1;
        while(left < right) {
            int mid = left + (right - left >> 1) ;
            if(numbers[mid] > numbers[right]) {
                left = mid+1;
            } else if(numbers[mid] < numbers[left]){
                right = mid;
            } else right--;
        }
        return numbers[left];
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        System.out.println(minArray(nums));
    }
}
