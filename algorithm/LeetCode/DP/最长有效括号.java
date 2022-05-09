package LeetCode.DP;

public class 最长有效括号 {//虽然是一维DP，但确实不好想
    class Solution {
        public int longestValidParentheses(String s) {
            int ans = 0;//最长有效括号数目，必为偶数，括号成对出现
            int[] dp = new int[s.length()];//dp数组 O(n)空间复杂度
            for (int i = 1; i < s.length(); i++) {//O(n)时间复杂度 一次遍历出结果
                if (s.charAt(i) == ')') { //从右括号开始判断，左括号都为0，因为左括号必不为有效括号结尾位置
                    if (s.charAt(i - 1) == '(') {//如果是() 则
                        dp[i] = (i > 2 ? dp[i - 2] : 0) + 2;//在不越界的情况下(i-2要大于0 数组下标不为负)，直接+2即可
                        //i - dp[i - 1] > 0 为了保证后边的s.charAt()不越界
                        //s.charAt(i - dp[i - 1] - 1) == '(' 减去中间的”阻碍“dp[i-1]后 实际和上边的逻辑一样 剩下的是i-1
                    } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {//如果为...((中间的有效括号可以有很多个))
                        //要考虑()(())、或者((())、 )(())、 ()()(()) 之类的情况
                        //dp[i-1]考虑了(())括号嵌套，且i-1不可能越界，故直接dp[i-1]
                        //i-dp[i-1]-2>=0 可能越界比如())为2-2-2=-2，统一越界dp[负数]=0 ,则有下式
                        //dp[i-dp[i-1]-2]:i-dp[i-1]可以跳过当前有效括号，比如(())(()) i=7时，
                        // dp[i-dp[i-1]-2]=dp[3],可以拿到之前的(())，这个式子可能要背一下...
                        //最后则是老套的+2毕竟每次发现新')'都得加2
                        dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                    }
                    ans = Math.max(ans, dp[i]);//最后更新最值，return即可。
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        String s = "(())(())";
        System.out.println(new 最长有效括号().new Solution().longestValidParentheses(s));
    }
}
