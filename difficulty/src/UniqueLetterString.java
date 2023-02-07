import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UniqueLetterString {
    public static void main(String[] args) {

    }
    class Solution {
        public int uniqueLetterString(String s) {
            int ans = 0;
            Map<Character, List<Integer>> m = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (!m.containsKey(c)) {
                    m.put(c, new ArrayList<Integer>());
                    m.get(c).add(-1);
                }
                m.get(c).add(i);
            }
            for (Map.Entry<Character, List<Integer>> entry : m.entrySet()) {
                List<Integer> list = entry.getValue();
                list.add(s.length());
                for (int i = 1; i < list.size() - 1; i++) {
                    ans += (list.get(i) - list.get(i - 1)) * (list.get(i + 1) - list.get(i));
                }
            }
            return ans;
        }
    }
}
