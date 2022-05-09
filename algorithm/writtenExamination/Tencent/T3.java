package writtenExamination.Tencent;
import java.util.Scanner;

public class T3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String line = sc.nextLine();
        line = sc.nextLine().trim();//这里的trim()可有可无
        int cnt = 0;
        int[] pre = new int[n+3];
        int[] last = new int[n+3];
        for(char ch : line.toCharArray()){
            cnt++;
            pre[cnt] = pre[cnt-1];
            if(ch=='0'){
                pre[cnt] += cnt;
            }
        }
        char[] newline = new char[line.length()];
        for(int i=0;i<line.length();i++){
            newline[i] = line.charAt(line.length()-1-i);
        }
        for(char ch : newline){
            last[cnt] = last[cnt+1];
            if(ch == '1'){
                last[cnt] += cnt;
            }
            cnt --;
        }
        int ans = 100000000;
        for(int i=0;i<n+1;i++){
            ans = Math.min(ans,Math.abs(pre[i]-last[i+1]));
        }
        System.out.println(ans);
    }
}
/*
7
1000101

4
0011
*/