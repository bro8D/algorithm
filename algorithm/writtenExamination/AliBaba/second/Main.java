package writtenExamination.AliBaba.second;

import java.util.*;

//ACM模式
public class Main {
    private void swap(long[] a, int i, int j) {
        long temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long[] a = new long[6];
        a[0] = -1;
        while (n-- > 0) {
            for (int i = 1; i <= 5; i++) {
                a[i] = in.nextLong();
            }
            Arrays.sort(a, 1, 6);
            long res = a[1] + a[2];
            long sum = res;
            for (int i = 3; i <= 5; i++) {
                sum += a[i];
                long temp = sum / (i - 1);
                if (temp < res) res = temp;
            }
            System.out.println(res);
        }
    }
}
