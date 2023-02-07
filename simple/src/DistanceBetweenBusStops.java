import java.util.Arrays;
import java.util.PrimitiveIterator;
import java.util.stream.IntStream;

public class DistanceBetweenBusStops {
    public static void main(String[] args) {

    }
    class Solution {
        public int distanceBetweenBusStops(int[] distance, int start, int destination) {
            IntStream stream = Arrays.stream(distance);
            int sum = 0;
            PrimitiveIterator.OfInt iterator = stream.iterator();
            sum += iterator.nextInt();
            while (iterator.hasNext()) {
                sum += iterator.nextInt();
            }
            int ans = 0;
            int n = distance.length;

            for (int i = start; i != destination; i = (i + 1) % n) {
                ans += distance[i];
            }

            ans = Math.min(ans, sum - ans);
            return ans;
        }
    }
}
