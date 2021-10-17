public class IsPowerOfThree {
    public static void main(String[] args) {
        System.out.println(new IsPowerOfThree().new Solution().isPowerOfThree(2147483647));
    }

    class Solution {
        public boolean isPowerOfThree(int n) {
//        while (n != 0 && n % 3 == 0) {
//            n /= 3;
//        }
//        return n == 1;
            Object obj = new Object();
            String str = new String("a");
            long t = 1;
            while (t <= n) {
                if (t == n) {
                    return true;
                }
                t *= 3;
            }

            return false;

        }
    }
}


