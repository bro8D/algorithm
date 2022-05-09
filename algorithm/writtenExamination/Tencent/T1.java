package writtenExamination.Tencent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class T1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.nextLine();
        ArrayList<String> str = new ArrayList<>();
        for(int i=0;i<n;i++) {
            s = sc.nextLine();
            str.add(s);
        }
        int len = str.get(0).length();
        ArrayList<Integer> shu = new ArrayList<>();
        for(int i=0;i<len;i++){
            String ch = "";
            for(int j=0;j<n;j++){
                ch+= str.get(j).charAt(i);
            }
            shu.add(Integer.parseInt(ch));
        }
        Collections.sort(shu);
        for(int i=0;i<len;i++){
            System.out.println(shu.get(i));
        }
    }
}
