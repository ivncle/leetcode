public class FindNthDigit {
    public static void main(String[] args) {
        System.out.println(new FindNthDigit().new Solution().findNthDigit(2));
    }
    class Solution {
        public int findNthDigit(int n) {
            int d = 1, count = 9;
            while (n > (long)d * count) {
                n -= (long)d * count;
                d++;
                count *= 10;
            }
            int index = n - 1;
            int start = (int)Math.pow(10, d - 1);
            int num = start + index / d;
            int ansIndex = index % d;
            int ans = num / (int)(Math.pow(10, d - ansIndex - 1)) % 10;
            return ans;
        }
    }
}
