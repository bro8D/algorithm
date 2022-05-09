package LeetCode.排序;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


public class 合并最小区间 {
    class Solution {
        public int[][] merge(int[][] intervals) {
            if (intervals.length == 0) {
                return new int[0][2];//这个格式要记一下
            }
            Arrays.sort(intervals,(a,b)->a[0]-b[0]);//这么写更简洁
            /** 完整的sort语句
             Arrays.sort(intervals, new Comparator<int[]>() {
             public int compare(int[] interval1, int[] interval2) {
             return interval1[0] - interval2[0];
             }
             });
             */
            List<int[]> merged = new ArrayList<int[]>(); //ans 因为不知道长度，用ArrayList
            for (int i = 0; i < intervals.length; ++i) {//遍历一次
                int L = intervals[i][0], R = intervals[i][1];//拿到区间的左右边界
                //如果ans还是空的 或者 当前merged里存的最大区间的右边界小于 cur的L，说明连不起来，直接入队即可
                if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < L) {
                    merged.add(new int[]{L, R});
                } else {
                    merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], R);
                }
            }
            return merged.toArray(new int[merged.size()][]);
        }
    }


    public static void main(String[] args) {
        int[][] matrix = {{1,3},{2,6},{8,9}};
        int[][] ans = new 合并最小区间().new Solution().merge(matrix);
        Arrays.asList(ans).forEach(item-> System.out.println(item[0]+","+item[1]));//这里要加双引号才行
    }
}
