import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GridIllumination {
    public static void main(String[] args) {
        System.out.println(new GridIllumination().new Solution().gridIllumination(5, new int[][]{}, new int[][]{}));
    }
    class Solution {
        public int[] gridIllumination(int n, int[][] lamps, int[][] queries) {
            int[] ans = new int[queries.length];
            Map<Integer, Integer> row = new HashMap<>();
            Map<Integer, Integer> col = new HashMap<>();
            Map<Integer, Integer> diagonal = new HashMap<>();
            Map<Integer, Integer> antiDiagonal = new HashMap<>();
            Set<Long> s = new HashSet<>();
            for (int[] lamp : lamps) {
                if (!s.add(hash(lamp[0], lamp[1]))) {
                    continue;
                }
                row.put(lamp[0], row.getOrDefault(lamp[0], 0) + 1);
                col.put(lamp[1], col.getOrDefault(lamp[1], 0) + 1);
                diagonal.put(lamp[0] - lamp[1], diagonal.getOrDefault(lamp[0] - lamp[1], 0) + 1);
                antiDiagonal.put(lamp[0] + lamp[1], antiDiagonal.getOrDefault(lamp[0] + lamp[1], 0) + 1);
            }
            for (int i = 0; i < queries.length; i++) {
                int r = queries[i][0];
                int c = queries[i][1];
                if (row.getOrDefault(r, 0) > 0 ||
                        col.getOrDefault(c, 0) > 0 ||
                        diagonal.getOrDefault(r - c, 0) > 0 ||
                        antiDiagonal.getOrDefault(r + c, 0) > 0) {
                    ans[i] = 1;
                }
                for (int j = r - 1; j <= r + 1; j++) {
                    for (int k = c - 1; k <= c + 1; k++) {
                        if (j < 0 || j >= n || k < 0 || k >= n) {
                            continue;
                        }
                        if (s.remove(hash(j, k))) {
                            row.put(j, row.get(j) - 1);
                            if (row.get(j) == 0) {
                                row.remove(j);
                            }
                            col.put(k, col.get(k) - 1);
                            if (col.get(k) == 0) {
                                col.remove(k);
                            }
                            diagonal.put(j - k, diagonal.get(j - k) - 1);
                            if (diagonal.get(j - k) == 0) {
                                diagonal.remove(j - k);
                            }
                            antiDiagonal.put(j + k, antiDiagonal.get(j + k) - 1);
                            if (antiDiagonal.get(j + k) == 0) {
                                antiDiagonal.remove(j + k);
                            }
                        }
                    }
                }
            }
            return ans;
        }
        long hash(int x, int y) {
            return (int)x + ((long)y << 32);
        }

    }
}
