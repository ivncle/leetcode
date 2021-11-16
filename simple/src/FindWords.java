import java.util.ArrayList;
import java.util.List;
import java.util.SplittableRandom;

public class FindWords {
    public static void main(String[] args) {
        for (String s : new FindWords().new Solution().findWords(new String[]{"abdfs"})) {
            System.out.println(s);
        }
        //System.out.println(new FindWords().new Solution().findWords(new String[]{"Hello", "Alaska", "Dad", "Peace"}));
    }

    class Solution {
        String[] checks = {"qwertyuiop", "asdfghjkl", "zxcvbnm"};

//        boolean check(String s, char c) {
//            int i;
//            for (i = 0; i < s.length(); i++) {
//                if (s.charAt(i) != c) {
//                    break;
//                }
//            }
//            if (i != s.length()) {
//                return true;
//            }
//            return false;
//        }

        public String[] findWords(String[] words) {
            List<String> list = new ArrayList<String>();
            for (String s : words) {
                String str = s.toLowerCase();
                int flag = 0;
                //System.out.println(str);
                for (int i = 0; i < checks.length; i++) {
                    if (checks[i].contains(new String(new char[]{str.charAt(0)}))) {
                        flag = i;
                        break;
                    }
                }
                int i;
                for (i = 1; i < str.length(); i++) {
                    if (checks[flag].contains(new String(new char[]{str.charAt(i)}))) {
                        continue;
                    } else {
                        break;
                    }

                }
                if (i == str.length()) {
                    list.add(s);
                }
            }
            String[] ans = new String[list.size()];
            int i = 0;
            for (String s : list) {
                ans[i++] = s;
            }
            return ans;
        }
    }
}
