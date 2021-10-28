public class ReorderedPowerOf2 {
    public static void main(String[] args) {
        System.out.println(new ReorderedPowerOf2().new Solution().reorderedPowerOf2(
                10));
    }

    class Solution {
        boolean flag = false;
        int[] vis = new int[100];
        int n;
        String target;
        boolean isPowerOf2(int t) {
            //System.out.println((t & (t - 1)));1010
            return (t & (t - 1)) == 0;
        }
        void dfs(String str, int len) {
            //有答案直接回溯
            if (flag) {
                return ;
            }
            if (len == n) {
                System.out.println(str);
                if (str.charAt(0) == '0') {

                } else {
                    int t = Integer.parseInt(str);
                    //判断
                    if (isPowerOf2(t)) {
                        flag = true;
                    }
                }
                return;
            }
            //搜索
            for (int i = 0; i < n; i++) {
                if (vis[i] == 0) {

                    if (str.length() == 0 && target.charAt(i) == '0' || vis[i] == 1) {
                        continue;
                    }
                    vis[i] = 1;
                    dfs(str + target.charAt(i), len + 1);
                    vis[i] = 0;
                }
            }
        }
        String numberToString(int n) {
            String s = "";

            while (n != 0) {
                s += (n % 10);
                n /= 10;
            }

            return s;
        }
        public boolean reorderedPowerOf2(int n) {
            this.target = numberToString(n);
            this.n = target.length();
            dfs("", 0);
            return flag;
        }

    }
}
