import java.util.HashMap;
import java.util.Map;

import static java.lang.Math.min;

public class FindMinStep {

    public static void main(String[] args) {
        System.out.println(new FindMinStep().new Solution().findMinStep("WRRBBW", "RB"));
    }

    class Solution {
        Map<String, Integer> m = new HashMap<>();

        public int findMinStep(String board, String hand) {
            int ans = dfs(board, hand.toCharArray());

            return ans >= 6 ? -1 : ans;
        }

        int dfs(String board, char[] hand) {
            if (board.length() == 0) {
                return 0;
            }
            if (m.containsKey(board)) {
                return m.get(board);
            }
            int ans = 6;
            for (int i = 0; i < hand.length; i++) {
                char c = hand[i];
                if (c != '*') {
                    for (int j = 0; j < board.length(); j++) {
                        StringBuilder stringBuilder = new StringBuilder()
                                .append(board.substring(0, j))
                                .append(c)
                                .append(board.substring(j));
                        remove(stringBuilder, j);
                        hand[i] = '*';
                        ans = Math.min(ans, dfs(stringBuilder.toString(), hand) + 1);
                        hand[i] = c;
                    }
                }

            }
            m.put(board, ans);

            return ans;
        }

        void remove(StringBuilder stringBuilder, int index) {
            if (index < 0) {
                return;
            }
            char c = stringBuilder.charAt(index);
            int left = index, right = index;
            while (--left >= 0 && stringBuilder.charAt(left) == c) ;
            while (++right < stringBuilder.length() && stringBuilder.charAt(right) == c) ;
            if (right - left - 1 >= 3) {
                stringBuilder.delete(left + 1, right);
                remove(stringBuilder, left);
            }
        }
    }

}
