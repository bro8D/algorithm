package LeetCode.字符串;

public class 比较版本号 {
    public static int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.",-1);
        String[] v2 = version2.split("\\.",-1);
        int len = Math.max(v1.length,v2.length);
        for(int i=0;i<len;i++) {
            int n1 = i<v1.length ? Integer.parseInt(v1[i]) : 0;
            int n2 = i<v2.length ? Integer.parseInt(v2[i]) : 0;
            if(n1>n2) return 1;
            else if(n1<n2) return -1;
            else continue;
        }
        return 0;
    }

    public static void main(String[] args) {
        String version1 = "1.0.1",version2 = "1.0.0" ;
        System.out.println(compareVersion(version1,version2));
    }
}
