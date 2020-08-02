/**
 * Leetcode 8: String to Integer (Atoi) (MEDIUM)
 * https://leetcode.com/problems/string-to-integer-atoi/
 * 
 * Implement atoi which converts a string to an integer.
 * The function first discards as many whitespace characters as necessary until the first non-whitespace character 
 * is found. Then, starting from this character, takes an optional initial plus or minus sign 
 * followed by as many numerical digits as possible, and interprets them as a numerical value.
 * The string can contain additional characters after those that form the integral number, 
 * which are ignored and have no effect on the behavior of this function.
 * If the first sequence of non-whitespace characters in str is not a valid integral number, 
 * or if no such sequence exists because either str is empty or it contains only whitespace characters, 
 * no conversion is performed.
 * If no valid conversion could be performed, a zero value is returned.
 * 
 * Note:
 * Only the space character ' ' is considered as whitespace character.
 * Assume we are dealing with an environment which could only store integers within the 
 * 32-bit signed integer range: [−231,  231 − 1]. If the numerical value is out of the 
 * range of representable values, INT_MAX (231 − 1) or INT_MIN (−231) is returned.
 * 
 * Example 1:
 * Input: "42"
 * Output: 42
 * 
 * Example 2:
 * Input: "   -42"
 * Output: -42
 * Explanation: The first non-whitespace character is '-', which is the minus sign.
 *              Then take as many numerical digits as possible, which gets 42.
 * 
 * Example 3: 
 * Input: "4193 with words"
 * Output: 4193
 * Explanation: Conversion stops at digit '3' as the next character is not a numerical digit.
 * 
 * Example 4:
 * Input: "words and 987"
 * Output: 0
 * Explanation: The first non-whitespace character is 'w', which is not a numerical 
 *              digit or a +/- sign. Therefore no valid conversion could be performed.
 * 
 * Example 5:
 * Input: "-91283472332"
 * Output: -2147483648
 * Explanation: The number "-91283472332" is out of the range of a 32-bit signed integer.
 *              Thefore INT_MIN (−231) is returned.
*/
public class Leetcode8StringToIntegerAtoi {
    // Linear one-pass approach (87.31% spd, 35.04% mem)
    public static int myAtoi(String str) {
        long ret = 0;
        boolean negative = false;
        boolean findingNum = false;
        int i = 0;
        while(i < str.length() && !(ret > Integer.MAX_VALUE || ret < Integer.MIN_VALUE)) {
            char c = str.charAt(i);
            if(c == ' ' && !findingNum) {
                // Ignore whitespace before first numeric value
                i++;
                continue;
            } else if(c >= '0' && c <= '9') {
                // Append each consecutive numeric value
                findingNum = true;
                ret = ret * 10 + (int) c - '0';
                i++;
            } else if((c == '-' || c == '+') && !findingNum) {
                // Negate value if negative is foud first
                negative = c == '-';
                i++;
                findingNum = true;
            } else {
                break;
            }
        }
        ret = negative ? -ret : ret;
        return (int) Math.max(Math.min(ret, Integer.MAX_VALUE), Integer.MIN_VALUE);
    }

    public static void main(String[] args) {
        String[] testInputs = {"42", "-42", "4193 with words", "words and 987", "-91283472332", "9223372036854775808"};
        int[] testOutputs = {42, -42, 4193, 0, -2147483648, 2147483647};

        for(int test = 0; test < testInputs.length; test++) {
            System.out.println();
            System.out.println("Input: " + testInputs[test]);            
            System.out.println("Expected: " + testOutputs[test]);

            int output1 = myAtoi(testInputs[test]);
            System.out.println("Output: " + output1);
            System.out.println(output1 == testOutputs[test] ? "--- PASS ---" : "--- FAIL ---");
        }
    } 
}