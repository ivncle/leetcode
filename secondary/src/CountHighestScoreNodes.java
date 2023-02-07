import java.util.ArrayList;
import java.util.List;

public class CountHighestScoreNodes {
    public static void main(String[] args) {

    }

    class Solution {
        long maxScore = 0;
        int cnt = 0;
        int n;
        List<Integer>[] lists;
        public int countHighestScoreNodes(int[] parents) {
            this.n = parents.length;
            lists = new List[n];
            for (int i = 0; i < n; i++) {
                lists[i] = new ArrayList<>();
            }
            for (int i = 0; i < n; i++) {
                int p = parents[i];
                if (p != -1) {
                    lists[p].add(i);
                }
            }
            dfs(0);
            return cnt;
        }
        int dfs(int node) {
            long score = 1;
            int size = n - 1;
            for (var v : lists[node]) {
                int t = dfs(v);
                score *= t;
                size -= t;
            }
            if (node != 0) {
                score *= size;
            }
            if (score == maxScore) {
                cnt++;
            }
            if (score > maxScore) {
                maxScore = score;
                cnt = 1;
            }

            return n - size;
        }

    }
}
