import java.util.ArrayList;
import java.util.List;

public class AddOperators {
    public static void main(String[] args) {
        System.out.println(new AddOperators().new Solution().addOperators("232", 8));
    }

    class Solution {
        //n表示字符数量，num表示字符串，target表示目标数字
        int n;
        String num;
        int target;
        //答案
        List list = new ArrayList();

        void dfs(StringBuffer str, int i, long s, long mul) {
            if (i == n) {
                if (s == target) {
                    list.add(str.toString());
                }
                return;
            } else {
                int index = str.length();
                if (i > 0) {
                    str.append('0');
                }
                long t = 0;
                for (int j = i; j < n && (j == i || num.charAt(i) != '0'); j++) {
                    t = t * 10 + num.charAt(j) - '0';
                    str.append(num.charAt(j));
                    if (i == 0) {
                        dfs(str, j + 1, t, t);
                    } else {
                        str.setCharAt(index, '+');
                        dfs(str, j + 1, s + t, t);

                        str.setCharAt(index, '-');
                        dfs(str, j + 1, s - t, -t);

                        str.setCharAt(index, '*');
                        dfs(str, j + 1, s - mul + mul * t, mul * t);
                    }
                }
                //回溯，传的是引用
                str.setLength(index);
            }

        }

        public List<String> addOperators(String num, int target) {
            this.n = num.length();
            this.num = num;
            this.target = target;
            StringBuffer stringBuffer = new StringBuffer();
            dfs(stringBuffer, 0, 0, 0);

            return list;
        }
    }
}
