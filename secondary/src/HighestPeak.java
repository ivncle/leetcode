import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class HighestPeak {
    public static void main(String[] args) {
        System.out.println();
    }
    class Solution {
        public int[][] highestPeak(int[][] isWater) {
            int[][] ans = new int[isWater.length][isWater[0].length];
            int[] dx = {0, -1, 0, 1};
            int[] dy = {1, 0, -1, 0};
            Queue<int[]> q = new ArrayDeque<>();

            for (int i = 0; i < isWater.length; i++) {
                Arrays.fill(ans[i], -1);
            }
            for (int i = 0; i < isWater.length; i++) {
                for (int j =0; j < isWater[i].length; j++) {
                    if (isWater[i][j] == 1) {
                        q.offer(new int[]{i, j});
                        ans[i][j] = 0;
                    }
                }
            }

            while (!q.isEmpty()) {
                int[] p = q.poll();
                for (int i= 0; i < 4; i++) {
                    int tx = dx[i] + p[0];
                    int ty = dy[i] + p[1];
                    if (tx >=0 && tx < isWater.length && ty >= 0 && ty < isWater[0].length && ans[tx][ty] == -1) {
                        ans[tx][ty] = ans[p[0]][p[1]] + 1;
                        q.offer(new int[]{tx, ty});
                    }
                }
            }
            return ans;
        }
    }
}
