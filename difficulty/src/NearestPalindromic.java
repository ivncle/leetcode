import java.util.ArrayList;
import java.util.List;

public class NearestPalindromic {
    public static void main(String[] args) {
        System.out.println(new NearestPalindromic().new Solution().nearestPalindromic("123"));
    }

    class Solution {
        public String nearestPalindromic(String n) {
            long number = Long.parseLong(n);
            long ans = -1;
            List<Long> candidates = getCandidates(n);
            for (var v : candidates) {

                if (v != number) {
                    if (ans == -1 ||
                            Math.abs(v - number) < Math.abs(ans - number) ||
                            Math.abs(v - number) == Math.abs(ans - number) && v < ans) {
                        ans = v;
                    }
                }

            }
            return Long.toString(ans);
        }

        private List<Long> getCandidates(String n) {
            int len = n.length();
            List<Long> ans = new ArrayList<>() {
                {
                    add((long) Math.pow(10, len) + 1);
                    add((long) Math.pow(10, len - 1) - 1);
                }
            };
            long self = Long.parseLong(n.substring(0, (len + 1) / 2));
            for (long i = self - 1; i <= self + 1; i++) {
                StringBuffer stringBuffer = new StringBuffer();
                String pre = String.valueOf(i);
                stringBuffer.append(pre);
                StringBuffer next = new StringBuffer(pre).reverse();
                stringBuffer.append(next.substring(len & 1));
                ans.add(Long.parseLong(stringBuffer.toString()));
            }
            return ans;
        }
    }
}
