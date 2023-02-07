public class StrongPasswordChecker {
    public static void main(String[] args) {

    }
    class Solution {
        public int strongPasswordChecker(String password) {
            char[] cs = password.toCharArray();
            int n = cs.length;
            int A = 0, B= 0, C = 0;
            for (var c : cs) {
                if (c >= 'a' && c <= 'z') {
                    A = 1;
                } else if (c >= '0' && c <= '9') {
                    B = 1;
                } else if (c >= 'A' && c <= 'Z') {
                    C = 1;
                }
            }
            int m = A + B + C;
            if (n < 6) {
                return Math.max(6 - n, 3 - m);
            } else if (n <= 20) {
                int tot = 0;
                for (int i = 0; i < n;) {
                    int j = i;
                    while (j < n && cs[j] == cs[i]) {
                        j++;
                    }
                    if (j - i >= 3) {
                        tot += (j - i) / 3;
                    }
                    i = j;
                }
                return Math.max(tot, 3 - m);
            } else {
                int tot = 0;
                int[] counts = new int[3];
                for (int i = 0; i < n;) {
                    int j = i;
                    while (j < n && cs[j] == cs[i]) {
                        j++;
                    }
                    if (j - i >= 3) {
                        tot += (j - i) / 3;
                        counts[j - i % 3]++;
                    }
                    i = j;
                }
                int base = n - 20;
                int cur = base;
                for (int i = 0; i < 3; i++) {
                    if (i == 2) {
                        counts[i] = tot;
                    }
                    if (counts[i] != 0 && cur != 0) {
                        int t = Math.min(counts[i] * (i + 1), cur);
                        cur -= t;
                        tot -= t / (i + 1);
                    }
                }
                return base + Math.max(tot, 3 - m);
            }
        }
    }
}
