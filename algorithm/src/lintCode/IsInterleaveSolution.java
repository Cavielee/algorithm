package lintCode;

public class IsInterleaveSolution {
	public boolean isInterleave(String s1, String s2, String s3) {
        // У��
        if (s1 == null || s2 == null || s3 == null) {
            return false;
        }
		int length1 = s1.length();
		int length2 = s2.length();
		
		if ((length1 + length2) != s3.length()) {
			return false;
		}
		
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        
		// ��ʼ��dp
		for (int i = 0; i <= length1; i++) {
			if (s1.substring(0, i).equals(s3.substring(0, i))) {
				dp[i][0] = true;
			}
		}
		for (int j = 0; j <= length2; j++) {
			if (s2.substring(0, j).equals(s3.substring(0, j))) {
				dp[0][j] = true;
			}
		}
		
		for (int n = 1; n <= s1.length(); n++) {
			for (int m = 1; m <= s2.length(); m++) {
				// �ж�dp[n][m]�Ƿ�ƥ��s3[n + m - 1]
				// ���������ж�dp[n][m - 1]�Ƿ�ƥ�䣬��������ڸû����ϼ����µ�s2[m - 1]�ַ���ƥ��s3[n+m-1]
				// ���������ж�dp[n - 1][m]�Ƿ�ƥ�䣬��������ڸû����ϼ����µ�s1[n - 1]�ַ���ƥ��s3[n+m-1]
				if (dp[n][m - 1] && s2.charAt(m - 1) == s3.charAt(n + m - 1) || 
						dp[n - 1][m] && s1.charAt(n - 1) == s3.charAt(n + m - 1)) {
					dp[n][m] = true;
				}
			}
		}
		return dp[length1][length2];
    }
}
