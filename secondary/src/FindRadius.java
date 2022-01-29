import java.util.Arrays;

public class FindRadius {

    public static void main(String[] args) {
        System.out.println();
    }

    class Solution {

        public int findRadius(int[] houses, int[] heaters) {
            int ans = 0;
            Arrays.sort(heaters);
            for (var house : houses) {
                int i = binarySearch(heaters, house);
                int j = i + 1;
                int left = i < 0 ? Integer.MAX_VALUE : house - heaters[i];
                int right = j >= heaters.length ? Integer.MAX_VALUE : heaters[j] - house;
                ans = Math.min(ans, Math.min(left, right));
            }
            return ans;
        }

        int binarySearch(int[] heaters, int house) {
            int left = 0, right = heaters.length - 1;
            if (heaters[left] > house) {
                return -1;
            }
            if (heaters[right] < house) {
                return heaters.length - 1;
            }
            while (left < right) {
                int mid = (left + right) / 2;
                if (heaters[mid] > house) {
                    right = mid - 1;
                } else {
                    left = mid;
                }
            }
            return left;
        }
    }
}
