import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LoudAndRich {
    public static void main(String[] args) {

    }
    class Solution {
        public int[] loudAndRich(int[][] richer, int[] quiet) {
            int n = quiet.length;
            int[] ans = new int[n];
            List<Integer>[] list = new ArrayList[n];
            for (int i = 0; i < n; i++) {
                list[i] = new ArrayList<>();
            }
            for (int[] r : richer) {
                list[r[1]].add(r[0]);
            }
            Arrays.fill(ans, -1);
            for (int i = 0; i < n; i++) {
                dfs(i, quiet, list, ans);
            }
            return ans;
        }

        private void dfs(int i, int[] quiet, List<Integer>[] list, int[] ans) {
            if (ans[i] != -1) {
                return;
            }
            ans[i] = i;
            for (int x : list[i]) {
                dfs(x, quiet, list,  ans);
                if (quiet[ans[i]] > quiet[ans[x]]) {
                    ans[i] = ans[x];
                }
            }
        }
    }
}
