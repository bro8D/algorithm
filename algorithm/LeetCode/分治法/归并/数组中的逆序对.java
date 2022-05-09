package LeetCode.分治法.归并;

public class 数组中的逆序对 {
    public static class Solution {
        int cnt=0;
        public int InversePairs(int [] array) {
//            int[] temp = new int[array.length];
            //java传参还是舒服，直接new一个放进去就行
            divid_merge(array,0,array.length-1,new int[array.length]);
            return cnt;
        }
        public void divid_merge(int[] array,int left ,int right ,int[] temp) {
            if(left >= right) return ;
            int mid = left + (right-left>>1);
            divid_merge(array,left,mid,temp);
            divid_merge(array,mid+1,right,temp);
            merge(array,left,mid,right,temp);
        }
        public void merge(int[] array,int left ,int mid,int right ,int[] temp){
            int left_index = left;
            int right_index = mid+1;
            int temp_index = left;
            while(left_index<=mid && right_index<=right) {
                if(array[left_index] <= array[right_index]) {//没有逆序，这里一定要有 = ，不然相等的值也会被记作逆序对
                    temp[temp_index++] = array[left_index++];
                }
                else {//出现了逆序
                    temp[temp_index++] = array[right_index++];
                    //因为归并到了这里，参与比较的两部分一定都是各自严格升序
                    //当[3,4] 和 [1,2] 中的 3比1大时，那后边的4必然也比1大所以逆序对数应当为左边数组尾-当前左索引+1
                    //即为下方的mid-left_index+1，mid为左边数组的尾索引，left_index为左边数组的
                    cnt = (cnt+(mid-left_index+1))%1000000007;//关键在这句话
                }
            }
            while(left_index<=mid) temp[temp_index++] = array[left_index++];
            while(right_index<=right) temp[temp_index++] = array[right_index++];
            while(left<=right) array[left] = temp[left++];
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr_1 = {1,2,3,4,5,6,7,0};
        int[] arr_2 = {1,2,3};
        int[] arr_3 = {3,2,1};
        System.out.println( solution.InversePairs(new int[]{4,3,2,1}) );
    }
}
