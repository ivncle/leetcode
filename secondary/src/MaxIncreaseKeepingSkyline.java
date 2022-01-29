public class MaxIncreaseKeepingSkyline {
    public static void main(String[] args) {
        System.out.println(new MaxIncreaseKeepingSkyline().
                new Solution().maxIncreaseKeepingSkyline(new int[][]{}));
    }
    class Solution {
        public int maxIncreaseKeepingSkyline(int[][] grid) {
            int n = grid.length;
            int ans = 0;
            int[][] dp = new int[2][n + 1];

            for (int i = 0; i < n; i++) {
                dp[0][i] = 0;
                dp[1][i] = 0;
                for  (int j = 0; j < n; j++) {
                    dp[0][i] = Math.max(dp[0][i], grid[i][j]);
                    dp[1][i] = Math.max(dp[1][i], grid[j][i]);
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int m = Math.min(dp[0][i], dp[1][i]);
                    ans += (m - grid[i][j]);
                }
            }
            return ans;
        }
    }
}
