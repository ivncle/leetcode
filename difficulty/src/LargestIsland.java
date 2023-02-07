import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LargestIsland {

    public static void main(String[] args) {

    }
    class Solution {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        public int largestIsland(int[][] grid) {

            int n = grid.length;
            int ans = 0;
            Map<Integer, Integer> m = new HashMap<>();
            int[][] arr = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1 && arr[i][j] == 0) {
                        int t = i * n + j + 1;
                        m.put(t, dfs(grid, i, j, arr, t));
                        ans = Math.max(ans, m.get(t));
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 0) {
                        int z = 1;
                        Set<Integer> s = new HashSet<>();
                        for (int k = 0; k < 4; k++) {
                            int tx = i + dx[k];
                            int ty = j + dy[k];
                            if (tx < 0 || tx >= n || ty < 0 || ty >= n || arr[tx][ty] == 0 || s.contains(arr[tx][ty])) {
                                continue;
                            }
                            z += m.get(arr[tx][ty]);
                            s.add(arr[tx][ty]);
                        }
                        ans = Math.max(ans, z);
                    }
                }
            }
            return ans;
        }
        int dfs(int[][] grid, int x, int y, int[][] arr, int t) {
            int n = grid.length;
            int ans = 1;
            arr[x][y] = t;
            for (int i = 0; i < 4; i++) {
                int tx = x + dx[i];
                int ty = y + dy[i];
                if (tx >= 0 && tx < n && ty >= 0 && ty < n && grid[tx][ty] == 1 && arr[tx][ty] == 0) {
                    ans += dfs(grid, tx, ty, arr, t);
                }
            }
            return ans;
        }

    }
}
