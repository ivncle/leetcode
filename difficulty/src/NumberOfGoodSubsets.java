public class NumberOfGoodSubsets {
    public static void main(String[] args) {
        System.out.println(new NumberOfGoodSubsets().new Solution().numberOfGoodSubsets(new int[]{10, 11, 5, 1, 10, 1, 3, 1, 26, 11, 6, 1, 1, 15, 1, 7, 22,
                1, 1, 1, 1, 1, 23, 1, 29, 5, 6, 1, 1, 29, 1, 1, 21, 19, 1, 1, 1, 2, 1, 11, 1, 15, 1, 22, 14, 1, 1, 1, 1, 6, 7, 1, 14, 3, 5, 1, 22, 1, 1, 1, 17, 1, 29, 2, 1, 15, 10, 1, 5, 7, 1,
                1, 1, 30, 1, 30, 1, 21, 10, 1, 1, 1, 1, 1, 2, 6, 5, 7, 3, 1, 1, 19, 29, 1, 7, 13, 14, 1, 5, 26, 19, 11, 1, 1, 1, 1, 1, 1, 1, 1, 22, 15, 1, 1, 13, 1, 17, 1, 1, 1, 13, 6, 1, 10,
                1, 1, 17, 1, 1, 3, 14, 7, 17, 1, 13, 1, 1, 1, 1, 1, 11, 1, 1, 6, 1, 1, 1, 1, 1, 2, 1, 30, 2, 26, 1, 1, 14, 1, 26, 29, 30, 1, 13, 21, 1, 1, 14, 21, 1, 23, 1, 15, 23, 21, 1, 30,
                19, 19, 1, 10, 23, 3, 3, 17, 22, 2, 26, 1, 11, 1, 23, 1, 1, 1, 15, 1, 1, 13, 1, 1}));


    }

    class Solution {
        int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};
        int[] bads = {4, 9, 25};
        int MOD = (int) (1e9 + 7);
        int[] count = new int[31];
        long[] dp = new long[1 + (1 << 10)];

        public int numberOfGoodSubsets(int[] nums) {

            long ans = 0;
            for (var num : nums) {
                count[num]++;
            }
            dp[0] = 1;
            for (int i = 2; i <= 30; i++) {
                if (count[i] == 0 || check(i)) {
                    continue;
                }
                int cur = getMask(i);
                for (int pre = 0; pre < (1 << 10); pre++) {
                    if ((pre & cur) > 0) {
                        continue;
                    }
                    dp[pre | cur] += dp[pre] * count[i];
                    dp[pre | cur] %= MOD;
                }
            }
            for (int i = 1; i <= (1 << 10); i++) {
                ans += dp[i];
                ans %= MOD;
            }

            ans *= pow(2, count[1]);
            /*System.out.println(Math.pow(2, count[1]) % MOD);
            ans *= Math.pow(2, count[1]);*/
            ans %= MOD;
            return (int) ans;
        }

        long pow(long base, int k) {
            long ans = 1L;
            while (k > 0) {
                if (k % 2 == 1) {
                    ans = (ans * base) % MOD;
                }
                base = (base * base) % MOD;
                k >>= 1;
            }
            return ans;
        }

        boolean check(int num) {
            for (var bad : bads) {
                if (num % bad == 0) {
                    return true;
                }
            }
            return false;
        }

        int getMask(int num) {
            int ans = 0;
            for (int i = 0; i < 10; i++) {
                if (num % primes[i] == 0) {
                    ans += (1 << i);
                }
            }
            return ans;
        }
    }

}
