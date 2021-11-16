public class KInversePairs {
    public static void main(String[] args) {
        System.out.println(new KInversePairs().new Solution().kInversePairs(2, 2));
    }

    class Solution {
        int MOD = (int) 1e9 + 7;

        public int kInversePairs(int n, int k) {
            long[][] dp = new long[n + 1][k + 1];
            dp[0][0] = 1;
            for (int i = 1; i <= n; i++) {
                dp[i][0] = 1;
                for (int j = 1; j <= k; j++) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                    if (j >= i) {
                        dp[i][j] -= dp[i - 1][j - i];
                    }
                    if (dp[i][j] < 0) {
                        dp[i][j] += MOD;
                    }
                    dp[i][j] %= MOD;
                }
            }
            return (int) dp[n][k];
        }

    }
}
