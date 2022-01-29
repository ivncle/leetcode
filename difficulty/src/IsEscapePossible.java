import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class IsEscapePossible {
    public static void main(String[] args) {

    }
    class Solution {
        int step = 0;
        int n = 0;
        Set<Long> set = new HashSet<>();
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
            for (int[] p : blocked) {
                set.add((long)p[0] * 100 + p[1]);
            }
            n = blocked.length;
            step = (n * (n - 1)) / 2;
            return bfs(source, target) && bfs(target, source);

        }

        boolean bfs(int[] source, int[] target) {
            Set<Long> vis = new HashSet<>();
            Deque<int[]> deque = new ArrayDeque<>();
            deque.addLast(source);
            vis.add((long)source[0] * 100 + source[1]);
            while (!deque.isEmpty() && vis.size() <= step) {
                int[] f = deque.pollFirst();
                if (f[0] == target[0] && f[1] == target[1]) {
                    return true;
                }
                for (int i = 0; i < 4; i++) {
                    int tx = f[0] + dx[i], ty = f[1] + dy[i];
                    if (tx < 0 || tx >= 1e6 || ty < 0 || ty >= 1e6) {
                        continue;
                    }
                    long hash = tx * 100 + ty;
                    if (set.contains(hash)) {
                        continue;
                    }
                    if (vis.contains(hash)) {
                        continue;
                    }
                    deque.addLast(new int[]{tx, ty});
                    vis.add(hash);

                }
            }
            return vis.size() > step;
        }
    }
}
