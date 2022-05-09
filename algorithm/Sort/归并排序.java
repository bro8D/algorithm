package Sort;

public class 归并排序 {

    //归并排序入口
    public static int[] mergeSort(int[] data) {
        sort(data, 0, data.length - 1);
        return data;
    }

    //对数据进行递归拆解与合并，对左右两边的数据进行递归
    public static void sort(int[] data, int left, int right) {
        if (left >= right) {
            return;
        }
        //找出中间索引
        int midpoint = left + (right - left >> 1);
        //对左边的数组进行递归
        sort(data, left, midpoint);
        //对右边的数组进行递归
        sort(data, midpoint + 1, right);
        //将两个数组合并
        merge(data, left, midpoint, right);
    }

    //进行数据排序和合并
    public static void merge(int[] data, int left, int midpoint, int right) {
        // 临时数组
        int[] tmpArr = new int[data.length];
        // 左边数组第一个元素的索引
        int lIndex = left;
        // 右边数组第一个元素的索引
        int rIndex = midpoint + 1;
        // third记录临时数组的索引
        int tmpIndex = left;

        while (lIndex <= midpoint && rIndex <= right) {
            // 从两个数组中取出最小的值放入临时数组中
            if (data[lIndex] <= data[rIndex]) {
                tmpArr[tmpIndex++] = data[lIndex++];
            } else {
                tmpArr[tmpIndex++] = data[rIndex++];
            }
        }
        //将剩余部分依次放入临时数组（实际上两个while只会执行其中一个）
        while (lIndex <= midpoint) {
            tmpArr[tmpIndex++] = data[lIndex++];
        }
        while (rIndex <= right) {
            tmpArr[tmpIndex++] = data[rIndex++];
        }
        //将临时数组中的内容复制到原数组中
        while (left <= right) {
            data[left] = tmpArr[left++];
        }
    }

    public static void main(String[] args) {
        int[] nums = {5, 2, 3, 1, 1, -3};
        mergeSort(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
