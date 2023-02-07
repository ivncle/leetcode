public class NumEnclaves {
    public static void main(String[] args) {
        System.out.println(new NumEnclaves().new Solution().numEnclaves(new int[][]{{1, 0}, {0, 1}}));
    }

    class Solution {
        int m, n;
        int []dx = {0, 1, 0, -1};
        int []dy = {1, 0, -1, 0};
        boolean [][]flag;
        int[][] grid;
        int ans = 0;
        public int numEnclaves(int[][] grid) {
            m = grid.length;
            n = grid[0].length;
            flag = new boolean[m][n];
            this.grid = grid;
            for (int i = 0; i < m; i++) {
                dfs(i, 0);
                dfs(i, n - 1);
            }
            for (int j = 1; j < n - 1; j++) {
                dfs(0, j);
                dfs(m - 1, j);
            }
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (this.grid[i][j] == 1 && !flag[i][j]) {
                        ans++;
                    }
                }
            }
            return ans;
        }

        private void dfs(int x, int y) {
            if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] == 0 || flag[x][y]) {
                return;
            }
            flag[x][y] = true;
            for (int i = 0; i < 4; i++) {
                int tx = x + dx[i];
                int ty = y + dy[i];
                dfs(tx, ty);
            }
        }
    }
}
