import java.lang.reflect.Array;
import java.util.Arrays;

public class CherryPickup {
    public static void main(String[] args) {

    }
    class Solution {
        public int cherryPickup(int[][] grid) {
            int[][][] dp = new int[60][60][60];
            int n = grid.length;
            for (int k = 0; k <= 2 * n; k++) {
                for (int i = 0; i <= n; i++) {
                    Arrays.fill(dp[k][i], Integer.MIN_VALUE);
                }
            }
            dp[2][1][1] = grid[0][0];
            for (int k = 3; k <= 2 * n; k++) {
                for (int i1 = 1; i1 <= n; i1++) {
                    for (int i2 = 1; i2 <= n; i2++) {
                        int j1 = k - i1, j2 = k - i2;
                        if (j1 <= 0 || j1 > n || j2 <= 0 || j2 > n) {
                            continue;
                        }
                        int A = grid[i1 - 1][j1 - 1], B = grid[i2 - 1][j2 -1];
                        if (A == -1 || B == -1) {
                            continue;
                        }
                        int a = dp[k - 1][i1 - 1][i2], b = dp[k - 1][i1 - 1][i2 - 1], c = dp[k - 1][i1][i2 - 1], d = dp[k - 1][i1][i2];
                        int t = Math.max(Math.max(a, b), Math.max(c, d)) + A;

                        if (i1 != i2) {
                            t += B;
                        }
                        dp[k][i1][i2] = t;
                    }
                }
            }
            return dp[2 * n][n][n] <= 0 ? 0 : dp[2 * n][n][n];
        }
    }
}
