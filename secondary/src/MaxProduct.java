public class MaxProduct {
    public static void main(String[] args) {
        System.out.println(new MaxProduct().new Solution().maxProduct(new String[]{"abcw","baz","foo","bar","xtfn","abcdef"}));
    }

    class Solution {
        public int maxProduct(String[] words) {
            int ans = 0;
            int n = words.length;
            int[] masks = new int[n + 1];
            for (int i = 0; i < n; i++) {
                String s = words[i];
                for (int j = 0; j < s.length(); j++) {
                    masks[i] |= 1 << (s.charAt(j) - 'a');
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if ((masks[i] & masks[j]) == 0) {
                        ans = Math.max(ans, words[i].length() * words[j].length());
                    }
                }
            }
            return ans;

        }
    }
}
