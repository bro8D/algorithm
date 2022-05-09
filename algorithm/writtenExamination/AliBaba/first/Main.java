package writtenExamination.AliBaba.first;

import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        int n;
        String str;
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        in.nextLine();
        for(int i=0;i<n;i++){
            str = in.nextLine();
            System.out.println(judge(str,set));
        }
    }

    static String judge(String str, HashSet<String> set){
        if(str.length()<6 || str.length()>12) return "illegal length";
        for(char ch:str.toCharArray()){
            if( !( ch>='a'&&ch<='z' || ch>='A'&&ch<='Z' ) ) return "illegal charactor";//判断是否为纯字符
        }
        if(set.contains(str)){ //acount complete
            return "acount existed";
        }
        set.add(str);
        return "registration complete";
    }
}
