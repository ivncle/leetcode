import java.util.*;

public class SecondMinimum {
    public static void main(String[] args) {

    }
    class Solution {
        public int secondMinimum(int n, int[][] edges, int time, int change) {
            int ans = 0;
            List<Integer>[] graph = new ArrayList[n + 1];
            for (int i = 0; i <= n; i++) {
                graph[i] = new ArrayList<>();
            }
            for (int[] edge : edges) {
                graph[edge[0]].add(edge[1]);
                graph[edge[1]].add(edge[0]);
            }
            int[][] path = new int[n + 1][2];
            for (int i = 0; i <= n; i++) {
                Arrays.fill(path[i], Integer.MAX_VALUE);
            }
            path[1][0] = 0;
            Queue<int[]> queue = new ArrayDeque<>();
            queue.offer(new int[]{1, 0});
            while (path[n][1] == Integer.MAX_VALUE) {
                int[] t = queue.poll();
                int cur = t[0], step = t[1];
                for (int i : graph[cur]) {
                    if (step + 1 < path[i][0]) {
                        path[i][0] = step + 1;
                        queue.offer(new int[]{i, step + 1});
                    } else if (step + 1 < path[i][1] && step + 1 > path[i][0]) {
                        path[i][1] = step + 1;
                        queue.offer(new int[]{i, step + 1});
                    }
                }
            }
            for (int i = 0; i < path[n][1]; i++) {
                if (ans % (2 * change) >= change) {
                    ans += (2 * change - (ans % (2 * change)));
                }
                ans += time;
            }
            return ans;
        }
    }
}
