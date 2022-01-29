public class PoorPigs {
    public static void main(String[] args) {
        System.out.println(new PoorPigs().new Solution().poorPigs(1,1,1));
    }
    class Solution {
        public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
            //信息论
            int t = minutesToTest / minutesToDie + 1;
            return (int)Math.ceil(Math.log(buckets) / Math.log(t));
            //动态规划
        }
    }
}
