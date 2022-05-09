package CCF;

import java.util.*;
//2020-12-2 这道题没吃透，接下来的几天多做几次

//博佬的思路是真的清晰，就是两次前缀和
//一次正着加，一次倒着加，然后把两个数组加一下求最大值即可，最大值对应的下标即可回原数组找到seita
public class Q2020_12_2 {//这里提交的时候改一下就好了
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        //max：预测最多的个数；ans：结果；cnt：以 xx 安全指数预测成功的个数
        int n = in.nextInt(),max = -1,ans = -1,count = 0;
        PriorityQueue<int[]> p = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];// 存储所有数据，按安全指数升序 o1-o2<0,先输出o1 这个记住就好了
            }
        });
        TreeSet<Integer> set = new TreeSet<>();// 存储所有的安全指数,因为指数只需要存储一次，重复的直接不要，故用map
        //但java用了treemap，可能是treemap效率更高？
        // 输入
        while(n-- != 0) {
            int[] temp = {in.nextInt(), in.nextInt()};
            p.add(temp);//保存全部数据，升序保存
            set.add(temp[0]);//只拿指数
            if(temp[1] == 1) count++;// 累计没挂科的人数，后面遍历遇到直接--即可。等同于 所有没挂科人数 - 当前遍历到的没挂科人数
            //这个count不加的话，虽然代码能过，但是总数是对不上的。
        }

        // set 升序遍历
        for(int element : set) {
            while( !p.isEmpty() && p.peek()[0] < element ) {//因为是升序排列，它只会遍历到比element小的数据
                //又因为小的element预测成功，则大的element必然预测成功，所以一下代码成立
                // 对于 type==1 来说，预测对的人数 - 1，对于 type==0 来说，预测对的人数 + 1
                if(p.peek()[1] == 1) count--;//p.peek() 当前数据比 element小，但是他没挂科，所以预测失败，count--
                else count++;//他挂科了，则预测成功 count++
                p.poll();//该轮统计结束之后，该数据没有意义，直接丢弃
            }
            if ( count >= max ) { // 在seita=element时，count值比之前更大，则说明该seita值更准确
                ans = element;//将seita值更新
                max = count;//将count值更新
            }
        }
        System.out.println(ans);
        System.out.println(max);
    }
}
