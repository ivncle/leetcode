import java.util.PriorityQueue;

public class TrapRainWater {
    public static void main(String[] args) {
        System.out.println(new TrapRainWater().new Solution().trapRainWater(new int[][]{{3, 3, 3, 3, 3},
                {3, 2, 2, 2, 3}, {3, 2, 1, 2, 3}, {3, 2, 2, 2, 3}, {3, 3, 3, 3, 3}}));
    }

    class Solution {

        public int trapRainWater(int[][] heightMap) {
            int ans = 0;
            int m = heightMap.length, n = heightMap[0].length;
            if (m <= 2 || n <= 2) {
                return 0;
            }
            int[][] vis = new int[m][n];
            PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((x, y) -> x[1] - y[1]);


            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
                        priorityQueue.offer(new int[]{i * n + j, heightMap[i][j]});
                        vis[i][j] = 1;
                    }
                }
            }
            int[] dx = {-1, 0, 1, 0};
            int[] dy = {0, 1, 0, -1};
            while (!priorityQueue.isEmpty()) {
                int[] t = priorityQueue.poll();
                for (int i = 0; i < 4; i++) {
                    int tx = t[0] / n + dx[i];
                    int ty = t[0] % n + dy[i];
                    if (tx >= 0 && tx < m && ty >= 0 && ty < n && vis[tx][ty] == 0) {

                        if (t[1] > heightMap[tx][ty]) {
                            ans += t[1] - heightMap[tx][ty];
                            //System.out.println("1");
                        }
                        priorityQueue.offer(new int[]{tx * n + ty, Math.max(t[1], heightMap[tx][ty])});
                        vis[tx][ty] = 1;
                    }
                }
            }
            return ans;
        }
    }
}
