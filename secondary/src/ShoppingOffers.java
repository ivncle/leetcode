import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShoppingOffers {
    public static void main(String[] args) {

        //System.out.println(new ShoppingOffers().new Solution().shoppingOffers());

    }

    class Solution {
        Map<List<Integer>, Integer> memo = new HashMap<>();
        public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
            int n = price.size();

            List<List<Integer>> filterSpecial = new ArrayList<>();
            for (List<Integer> s : special) {
                int a = 0, b = 0;
                for (int i = 0; i < n; i++) {
                    a += s.get(i);
                    b += s.get(i) * price.get(i);
                }
                if (a > 0 && b > s.get(n)) {
                    filterSpecial.add(s);
                }
            }
            return dfs(price, needs, filterSpecial, n);
        }
        int dfs(List<Integer> price, List<Integer> needs, List<List<Integer>> filterSpecial, int n) {
            if(!memo.containsKey(needs)) {
                int minPrice = 0;
                for (int i = 0; i < n; i++) {
                    minPrice += needs.get(i) * price.get(i);
                }
                for (List<Integer> curSpecial : filterSpecial) {
                    int specialPrice = curSpecial.get(n);
                    List<Integer> nextNeeds = new ArrayList<>();
                    for (int i = 0; i < n; i++) {
                        if (curSpecial.get(i) > needs.get(i)) {
                            break;
                        }
                        nextNeeds.add(needs.get(i) - curSpecial.get(i));
                    }
                    if (nextNeeds.size() == n) {
                        minPrice = Math.min(minPrice, dfs(price, nextNeeds, filterSpecial, n) + specialPrice);
                    }
                }
                memo.put(needs, minPrice);
            }
            return  memo.get(needs);
        }
    }
}
