import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class NetworkBecomesIdle {
    public static void main(String[] args) {

    }
    class Solution {
        public int networkBecomesIdle(int[][] edges, int[] patience) {
            int n = patience.length;
            List<Integer>[] list = new ArrayList[n];
            for (int i = 0; i < n; i++) {
                list[i] = new ArrayList<>();
            }
            boolean[] vis = new boolean[n];
            for (var edge : edges) {
                list[edge[0]].add(edge[1]);
                list[edge[1]].add(edge[0]);
            }
            Queue<Integer> queue = new ArrayDeque<>();
            queue.offer(0);
            vis[0] = true;
            int dis = 1;
            int ans = 0;
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    int cur = queue.poll();
                    for (var v : list[cur]) {
                        if (vis[v]) {
                            continue;
                        }
                        queue.offer(v);
                        int t = patience[v] * ((2 * dis - 1) / patience[v]) + 2 * dis + 1;
                        ans = Math.max(ans, t);
                        vis[v] = true;
                    }
                }
                dis++;
            }
            return ans;
        }
    }
}
