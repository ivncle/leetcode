public class FindKthNumber {
    public static void main(String[] args) {
        System.out.println(new FindKthNumber().
                new Solution().findKthNumber(13, 2));
    }
    class Solution {
        public int findKthNumber(int n, int k) {
            int cur = 1;
            k--;
            while (k > 0) {
                int steps = getSteps(cur, n);
                if (steps <= k) {
                    k -= steps;
                    cur++;
                } else {
                    cur = cur * 10;
                    k--;
                }
            }
            return cur;
        }
        int getSteps(int cur, int n) {
            int steps = 0;
            long left = cur;
            long right = cur;
            while (left <= n) {
                steps += Math.min(right, n) - left + 1;
                left = left * 10;
                right = right * 10 + 9;
            }
            return steps;
        }

    }
}
