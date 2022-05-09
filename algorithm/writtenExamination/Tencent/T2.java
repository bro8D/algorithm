package writtenExamination.Tencent;

import java.util.ArrayList;

public class T2 {
    public int getNumber (int[] a) {
        //先找出1-n的所有质数
        int n = a.length;
        ArrayList<Integer> nums = countPrimes(n);//拿到所有的质数
        ArrayList<Integer> ans = new ArrayList<>();//结果集
        ans.add(a[0]);//先加一个炮灰
        for(int i=0;i<nums.size();i++){//按照素数把数存进来
            ans.add(a[nums.get(i) - 1 ]);
        }
        while(ans.size()>1) {
            ans.remove(ans.get(0));
            for (int i = 0; i < ans.size(); i++) {
                ans.remove(nums.get(i));
            }
        }
        return ans.get(0);
    }
    public ArrayList<Integer> countPrimes(int n) {
        ArrayList<Integer> zhishu = new ArrayList<>();
        int[] iszhishu = new int[n];
        for(int i=0;i<n;i++){
            iszhishu[i] = 1;
        }
        for(int i= 2 ;i<n;i++) {
            if(iszhishu[i] == 1){
                zhishu.add(i);
            }
            for(int j=0;j<zhishu.size()&&i*zhishu.get(j)<n;j++){
                iszhishu[i*zhishu.get(j)] = 0;
                if(i%zhishu.get(j) == 0) break;
            }
        }
        return zhishu;
    }

    public static void main(String[] args) {
        T2 t2 = new T2();
        int[] n = {1,2,3,4};
        System.out.println(t2.getNumber(n));
    }
}
/*
题目：
1.给一个数组，数组里面的数不重要，只看下标（下标从开始计数），下标如果不是质数。那么删除
2.递归删除，上一轮从下标从1删到n后，剩下的数组继续删除，直到数组只剩一个数为止。

 */