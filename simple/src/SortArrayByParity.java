import java.util.Arrays;
import java.util.Collections;

public class SortArrayByParity {
    public static void main(String[] args) {
        System.out.println(new SortArrayByParity().new Solution().sortArrayByParity(new int[]{
                3,1,2,4
        }));
    }
    class Solution {
        public int[] sortArrayByParity(int[] nums) {
            Integer[] numsInt = Arrays.stream(nums).boxed().toArray(Integer[]::new);
            Arrays.sort(numsInt, (Integer x, Integer y) -> {
                if (x % 2 == y % 2) {
                    return 0;
                } else if (x % 2 == 0) {
                    return -1;
                } else {
                    return 1;
                }
            });
            nums = Arrays.stream(numsInt).mapToInt(Integer::valueOf).toArray();
            return nums;
        }
    }
}
