public class SearchMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1,4,7,11,15}, {2,5,8,12,19}, {3,6,9,16,22}, {10,13,14,17,24}, {18,21,23,26,30}};
        int taget = 20;
        //System.out.println(new SearchMatrix().new Solution().searchMatrix(matrix, taget));
    }
    class Solution {
        int[] dx = {0, 1};
        int[] dy = {1, 0};
        int[][] matrix;
        int[][] vis;
        int target;
        int m, n;
        boolean flag = false;
        void dfs(int x, int y) {
            if (flag) {
                return;
            }
            if (matrix[x][y] >= target) {
                if (matrix[x][y] == target) {
                    flag = true;
                }
                return;
            }
            for (int i = 0; i < 2; i++) {
                int tx = x + dx[i];
                int ty = y + dy[i];

                if (tx < m && ty < n && vis[tx][ty] == 0 && matrix[tx][ty] <= target) {
                    vis[tx][ty] = 1;
                    dfs(tx, ty);
                    vis[tx][ty] = 1;
                }
            }
        }
        public boolean searchMatrix(int[][] matrix, int target) {
            this.matrix = matrix;
            this.target = target;
            this.m = matrix.length;
            this.n = matrix[0].length;
            this.vis = new int[m][n];
            dfs(0, 0);
            return flag;
        }
    }
}
