import java.math.BigDecimal;

public class ComplexNumberMultiply {
    public static void main(String[] args) {

        System.out.println(new ComplexNumberMultiply().new Solution().complexNumberMultiply("1+1i", "1+1i"));

    }
    class Solution {
        String[] exchange(String s) {
            String[] str = new String[2];
            str[0] = "";
            str[1] = "";
            int flag = 0;
            for (int i = 0; i < s.length(); i++) {

                if (flag == 0) {
                    if (s.charAt(i) >= '0' && s.charAt(i) <= '9' || s.charAt(i) == '-') {
                        str[0] += s.charAt(i);
                    } else if (s.charAt(i) == '+') {
                        flag = 1;
                        continue;
                    }
                } else {
                    if (s.charAt(i) == '-' || s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                        str[1] += s.charAt(i);
                    }
                }
            }

            return str;
        }
        public String complexNumberMultiply(String num1, String num2) {
            // a + bi
            StringBuffer ans = new StringBuffer();
            String[] str1 = new String[2];
            String[] str2 = new String[2];

            str1 = exchange(num1);
            str2 = exchange(num2);


            BigDecimal decimala = new BigDecimal(str1[0]);
            BigDecimal decimalb = new BigDecimal(str2[0]);
            BigDecimal decimal = decimala.multiply(decimalb);

            BigDecimal decimala1 = new BigDecimal(str1[1]);
            BigDecimal decimalb1 = new BigDecimal(str2[1]);
            BigDecimal decimal1 = decimala1.multiply(decimalb1);

            ans.append(decimal.subtract(decimal1).toString());
            ans.append("+");

            decimala = new BigDecimal(str1[0]);
            decimalb = new BigDecimal(str2[1]);
            decimal = decimala.multiply(decimalb);

            decimala1 = new BigDecimal(str1[1]);
            decimalb1 = new BigDecimal(str2[0]);
            decimal1 = decimala1.multiply(decimalb1);

            ans.append(decimal.add(decimal1).toString());
            ans.append("i");

            return ans.toString();
        }
    }
}
