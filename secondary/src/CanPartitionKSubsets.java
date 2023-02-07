import java.util.Arrays;

public class CanPartitionKSubsets {

    public static void main(String[] args) {

    }
    class Solution {
        int sum = 0;
        int[] nums;
        int n;
        int per;
        boolean[] dp;
        public boolean canPartitionKSubsets(int[] nums, int k) {
            this.nums = nums;
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
            }
            if (sum % k != 0) {
                return false;
            }
            per = sum / k;
            Arrays.sort(nums);
            n = nums.length;
            if (nums[n - 1] > per) {
                return false;
            }
            dp = new boolean[1 << n];
            Arrays.fill(dp, true);
            return dfs((1 << n) - 1, 0);
        }
        boolean dfs(int s, int p) {
            if (s == 0) {
                return true;
            }
            if (!dp[s]) {
                return dp[s];
            }
            dp[s] = false;
            for (int i = 0; i < n; i++) {
                if (nums[i] + p > per) {
                    break;
                }
                if (((s >> i) & 1) != 0) {
                    if (dfs(s ^ (1 << i), (p + nums[i]) % per)) {
                        return true;
                    }
                }
            }
            return false;
        }

    }
}
