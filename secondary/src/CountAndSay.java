public class CountAndSay {
    public static void main(String[] args) {

        System.out.println(new CountAndSay().new Solution().countAndSay(5));

    }
    class Solution {
        public String countAndSay(int n) {
            String ans = "1";

            for (int i = 2; i <= n; i++){
                int star = 0, pos = 0;
                String curr="";
                while (ans.length() > pos) {

                    while (ans.length() > pos && ans.charAt(star) == ans.charAt(pos)) {
                        pos++;
                    }
                    curr += (pos - star);
                    curr += ans.charAt(pos-1);
                    star = pos;
                }
                ans = curr;

            }

            return ans;
        }
    }
}
