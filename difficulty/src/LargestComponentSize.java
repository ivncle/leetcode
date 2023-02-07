import java.util.Arrays;

public class LargestComponentSize {
    public static void main(String[] args) {

    }
    class Solution {
        public int largestComponentSize(int[] nums) {
            int m = Arrays.stream(nums).max().getAsInt();
            UnionFind unionFind = new UnionFind(m + 1);
            for (var num : nums) {
                for (int i = 2; i * i <= num; i++) {
                    if (num % i == 0) {
                        unionFind.union(num, i);
                        unionFind.union(num, num / i);
                    }
                }
            }
            int[] counts = new int[m + 1];
            int ans = 0;
            for(var num : nums) {
                int root = unionFind.find(num);
                counts[root]++;
                ans = Math.max(ans, counts[root]);
            }
            return ans;
        }
    }
    class UnionFind{
        int[] parent;
        int[] rank;
        public UnionFind(int m) {
            parent = new int[m];
            for (int i = 0; i < m; i++) {
                parent[i] = i;
            }
            rank = new int[m];
        }
        public void union(int x, int y) {
            int rootx = find(x);
            int rooty = find(y);
            if (rooty != rootx) {
                if (rank[rooty] > rank[rootx]) {
                    parent[rooty] = rootx;
                } else if (rank[rooty] < rank[rootx]) {
                    parent[rootx] = rooty;
                } else {
                    parent[rooty] = rootx;
                    rank[rootx]++;
                }
            }
        }
        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }


    }
}
