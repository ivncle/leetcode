public class MinDistance {

    class Solution {
        public int minDistance(String word1, String word2) {
            int[][] dp = new int[600][600];
            for (int i = 0; i < word1.length(); i++) {
                char a = word1.charAt(i);
                for (int j = 0; j < word2.length(); j++) {
                    char b = word2.charAt(j);
                    if (a == b) {
                        if (i == 0 || j == 0) {
                            dp[i][j] = 1;
                        } else {
                            dp[i][j] = dp[i - 1][j - 1] + 1;
                        }
                    } else {
                        if (i == 0 || j == 0) {
                            if (i == 0 && j != 0) {
                                dp[i][j] = dp[i][j - 1];
                            } else if (i != 0 && j == 0) {
                                dp[i][j] = dp[i - 1][j];
                            }
                            else {
                                dp[i][j] = 0;
                            }
                        } else{
                            dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                        }

                    }
                }
            }
            return word1.length() + word2.length() - 2 * dp[word1.length() - 1][word2.length() - 1];
        }
    }

    public static void main(String[] args) {
        System.out.println(new MinDistance().new Solution().minDistance("park", "spake"));
//        while (true) {
//            ;
//        }
    }
}
