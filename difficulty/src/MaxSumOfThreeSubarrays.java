import java.lang.reflect.Array;

public class MaxSumOfThreeSubarrays {
    public static void main(String[] args) {
        System.out.println(new MaxSumOfThreeSubarrays().new Solution().maxSumOfThreeSubarrays(new int[]{1,2,1,2,6,7,5,1},2));
    }
    private class Solution {
        public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
            int[] ans = new int[3];

            int sum1 = 0, maxsum1 = 0, index1 = 0;
            int sum2 = 0, maxsum2 = 0, index11 = 0, index12 = 0;
            int sum3 = 0, maxsumTotal = 0;
            for (int i = 2 * k; i < nums.length; i++) {
                sum1 += nums[i - 2 * k];
                sum2 += nums[i - k];
                sum3 += nums[i];
                if (i >= 3 * k -1) {
                    if (sum1 > maxsum1) {
                        maxsum1 = sum1;
                        index1 = i - 3 * k + 1;
                    }
                    if (sum2 + maxsum1 > maxsum2) {
                        maxsum2 = sum2 + maxsum1;
                        index11 = index1;
                        index12 = i - 2 * k + 1;

                    }
                    if (sum3 + maxsum2 > maxsumTotal) {
                        maxsumTotal = sum3 + maxsum2;
                        ans[0] = index11;
                        ans[1] = index12;
                        ans[2] = i - k + 1;
                    }
                    sum1 -= nums[i - 3 * k + 1];
                    sum2 -= nums[i - 2 * k + 1];
                    sum3 -= nums[i - k + 1];
                }

            }
            System.out.println(ans[0] + " " + ans[1] + " " + ans[2]);
            return ans;
        }
    }
}
