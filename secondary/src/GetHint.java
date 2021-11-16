import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class GetHint {
    public static void main(String[] args) {
        System.out.println(new GetHint().new Solution().getHint("1122", "2211"));
    }

    class Solution {
        public String getHint(String secret, String guess) {
            int x = 0, y = 0;
            Map<Character, Integer> secretMap = new HashMap<>();
            Map<Character, Integer> guessMap = new HashMap<>();
            for (int i = 0; i < secret.length(); i++) {
                if (secret.charAt(i) == guess.charAt(i)) {
                    x++;
                } else {
                    if (secretMap.get(secret.charAt(i)) == null) {
                        secretMap.put(secret.charAt(i), 1);
                    } else {
                        secretMap.put(secret.charAt(i), secretMap.get(secret.charAt(i)) + 1);
                    }
                    if (guessMap.get(guess.charAt(i)) == null) {
                        guessMap.put(guess.charAt(i), 1);
                    } else {
                        guessMap.put(guess.charAt(i), guessMap.get(guess.charAt(i)) + 1);
                    }
                }
            }
            for (Map.Entry<Character, Integer> entry : secretMap.entrySet()) {
                //System.out.println(guessMap.get(entry.getKey()));
                if (guessMap.get(entry.getKey()) == null) {
                    continue;
                }else if (guessMap.get(entry.getKey()) > entry.getValue()) {
                    y += entry.getValue();
                } else {
                    y += guessMap.get(entry.getKey());
                }
            }
            return x + "A" + y + "B";
        }
    }
}
