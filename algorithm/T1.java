import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
//华为面试，全排列
public class T1 {
    //全大写英文字符串 输出它的全排列
    //AAB 3 AAB BAA ABA BAA  ABA  AAB
    static int ans = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char[] ch = s.toCharArray();
        int n = s.length();
        HashSet<String> set = new HashSet<>();
        dfs(ch, n, 0, set);
        System.out.println(ans);
    }

    public static void swap(char[] ch, int i, int j) {
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
    }

    public static void dfs(char[] ch, int n, int left, HashSet<String> set) {
        if (left == n) return;
        for (int i = left; i < n; i++) {
            swap(ch, left, i);
            System.out.println(new String(ch));
            set.add(new String(ch));
            dfs(ch, n, left + 1, set);
            ans++;
            swap(ch, left, i);
        }
    }
}
