import java.util.Arrays;

public class LongestDiverseString {
    public static void main(String[] args) {
        System.out.println(new LongestDiverseString().new Solution().longestDiverseString(1, 1,11));
    }
    class Solution {
        public String longestDiverseString(int a, int b, int c) {
            String ans = "";
            Pair[] pairs = {new Pair(a, 'a'), new Pair(b, 'b'), new Pair(c, 'c')};

            while (true) {
                Arrays.sort(pairs, (x, y) ->
                        y.number - x.number
                );
                boolean flag = false;
                for (Pair pair : pairs) {
                    if (pair.number <= 0) {
                        break;
                    }
                    int n = ans.length();
                    if (n >= 2 && ans.charAt(n - 1) == pair.ch && ans.charAt(n - 2) == pair.ch) {
                        continue;
                    }
                    ans += pair.ch;
                    pair.number--;
                    flag = true;
                    break;
                }
                if (!flag) {
                    break;
                }
            }
            return ans;
        }
        class Pair{
            int number;
            char ch;

            public Pair(int number, char ch) {
                this.number = number;
                this.ch = ch;
            }
        }
    }
}
