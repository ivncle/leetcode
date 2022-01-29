import java.util.*;

public class ColorBorder {
    public static void main(String[] args) {

    }

    class Solution {
        public int[][] colorBorder(int[][] grid, int row, int col, int color) {
            Deque<int[]> q = new LinkedList<>();
            boolean[][] vis = new boolean[grid.length][grid[0].length];
            List<int[]> list = new ArrayList<>();
            q.add(new int[]{grid[row][col], row, col});
            list.add(q.peek());
            vis[row][col] = true;
            int[] dx = {0, -1, 0, 1};
            int[] dy = {1, 0, -1, 0};
            while (!q.isEmpty()) {
                int[] cur = q.poll();
                int flag = 0;
                for (int i = 0; i < 4; i++) {
                    int tx = cur[1] + dx[i], ty = cur[2] + dy[i];
                    if (tx >= 0 && tx < grid.length && ty >= 0 && ty < grid[0].length) {
                        if (grid[tx][ty] == cur[0]) {
                            flag++;
                            if (flag == 4) {
                                list.remove(cur);
                            }

                        }
                        if (!vis[tx][ty]) {
                            vis[tx][ty] = true;
                            if (grid[tx][ty] == cur[0]) {
                                int[] t = new int[]{grid[tx][ty], tx, ty};
                                list.add(t);
                                q.offer(t);
                            }
                        }

                    }
                }

            }
            for (int[] t : list) {
                grid[t[1]][t[2]] = color;
            }
            return grid;
        }
    }
}
