package lintCode;

/**
 * 题目：给出一个字符串，算出最少切割多少次使得分割出来的字串都是回文串
 * 思路：动态规划（把一个问题化成两个小的问题，并且两个小的问题合起来等价于被分的问题）
 * 以下方法使用自底向上的推算：
 * dp[i] - 表示子串（i,len）的最小回文切割
 * 则最优解在dp[0]中。
 * i控制以哪个字符开头，j控制以哪个字符结尾，利用双重for来控制所有字串的可能性。
 * ① dp[i]初始化：默认子串（i,len）的最优解就是把每个字符都切割
 * ② 用i和j切割出范围在(i,len)的所有字串，然后判断是否为回文串
 * ③ 如果是回文串，则用当前最优解dp[i]与dp[j+1]+1比较大小，取更小值赋值给dp[i]
 * 		可以理解为dp[i]默认情况是上一个最优解dp[i]+1，即只要把多的那个字符单独切掉，也就是上一个最优解+1次
 * 		但是如果出现了以新的字符（i）开头组成的子串是回文串，则要回到dp[j+1]+1并与dp[i]比较，取更小值赋值给dp[i]
 * 		因为当前情况下在dp[j+1]一定是最优解，加一即把新的回文串切掉，剩下的就是最优解dp[j+1]，此时会出现两个分支，取切割数更小的赋值给dp[i]
 * ④ 一直循环上述②③，直到i的for循环结束，dp[0]即为最小切割数。
 * 
 * p[i][j] —— 表示(i,j)这个字串是否为回文串，如果为true则是回文串
 * p[i][j] 可以分解为s[i]=s[j]和p[i+1][j-1](因为p[i+1][j-1]是p[i][j]的子串，如果p[i][j]为回文串则p[i+1][j-1]则一定为回文串)为true
 * 因为一个字符和两个字符的子串没有无法判定p[i+1][j-1]所以加了j - i <= 1的判断（一个字符或两个字符的只要符合s[i]=s[j]即为回文串）
 * 
 * @author Cavielee
 *
 */
public class MinCut {

	static int minCut(String s) {
		int len = s.length();
        boolean[][] P = new boolean[len][len];
        int[] dp = new int[len + 1];
        for (int i = 0; i <= len; ++i) {
            dp[i] = len - i - 1;
        }
        
        for (int i = len - 1; i >= 0; --i) {
            for (int j = i; j < len; ++j) {
                if (s.charAt(i) == s.charAt(j) && (j - i <= 1 || P[i + 1][j - 1])) {
                    P[i][j] = true;
                    dp[i] = (dp[i]>dp[j + 1] + 1)?dp[j + 1] + 1:dp[i];
                }
            }
        }
        return dp[0];
	}


	public static void main(String[] args) {
		System.out.println(minCut("aa"));
		// String a = "aab";
		// System.out.println(a.indexOf("c", 1));
	}

}
