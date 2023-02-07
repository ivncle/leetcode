import java.util.ArrayList;
import java.util.List;

public class PacificAtlantic {
    public static void main(String[] args) {

    }
    class Solution {
        List<List<Integer>> ans = new ArrayList<>();
        int m, n;
        int[][] tagx;
        int[][] tagy;
        int[][] heights;
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        void dfs(int x, int y, int[][] tag) {
            if (tag[x][y] == 1) {
                return;
            }
            tag[x][y] = 1;
            for (int i = 0; i < 4; i++){
                int tx = x + dx[i];
                int ty = y + dy[i];
                if (tx >= 0 && tx < m && ty >= 0 && ty < n && heights[x][y] <= heights[tx][ty]) {
                    dfs(tx, ty, tag);
                }
            }
        }
        public List<List<Integer>> pacificAtlantic(int[][] heights) {
            this.heights = heights;
            m = heights.length;
            n = heights[0].length;
            tagx = new int[m][n];
            tagy = new int[m][n];
            for (int i = 0; i < m; i++) {
                dfs(i, 0, tagx);
            }
            for (int i = 1; i < n; i++) {
                dfs(0, i, tagx);
            }
            for (int i = 0; i < m; i++) {
                dfs(i, n - 1, tagy);
            }
            for (int i = 0; i < n - 1; i++) {
                dfs(m - 1, i, tagy);
            }
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (tagx[i][j] == 1 && tagy[i][j] == 1) {
                        List<Integer> list = new ArrayList<>();
                        list.add(i);
                        list.add(j);
                        ans.add(list);
                    }
                }
            }
            return ans;
        }
    }
}
