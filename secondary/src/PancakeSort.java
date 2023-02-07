import java.util.ArrayList;
import java.util.List;

public class PancakeSort {
    public static void main(String[] args) {
        System.out.println(new PancakeSort().new Solution().pancakeSort(new int[]{1, 2}));
    }
    class Solution {
        public List<Integer> pancakeSort(int[] arr) {
            List<Integer> ans = new ArrayList<>();
            for (int i = arr.length; i > 1; i--) {
                int index = 0;
                for (int j = 1; j < i; j++) {
                    if (arr[index] < arr[j]) {
                        index = j;
                    }
                }
                if(index == i - 1) {
                    continue;
                }
                remove(arr, index);
                ans.add(index + 1);
                remove(arr,i - 1);
                ans.add(i);

            }
            return ans;
        }
        void remove(int arr[], int index) {
            for (int i = 0, j = index; i < j; i++, j--) {
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
            }
        }

    }
}
