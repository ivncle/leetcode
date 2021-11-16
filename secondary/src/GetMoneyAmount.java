public class GetMoneyAmount {
    public static void main(String[] args) {
        System.out.println(new GetMoneyAmount().new Solution().getMoneyAmount(3));
    }
    class Solution {
        public int getMoneyAmount(int n) {
            int [][]dp = new int[n + 1][n + 1];
            for (int i = n - 1; i > 0; i--) {
                for (int j = i + 1; j <=n; j++) {
                    int m = Integer.MAX_VALUE;
                    for (int k = i; k < j; k++) {
                        int t = k + Math.max(dp[i][k - 1], dp[k + 1][j]);
                        m = Math.min(m, t);
                    }
                    dp[i][j] =m;
                }
            }
            return dp[1][n];
        }
    }
}
