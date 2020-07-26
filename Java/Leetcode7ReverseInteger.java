/**
 * Given a 32-bit signed integer, reverse digits of an integer.

 * Example 1:
 * 
 *  Input: 123
 *  Output: 321
 *  Example 2:
 * 
 *  Input: -123
 *  Output: -321
 *  Example 3:
 * 
 *  Input: 120
 *  Output: 21
 * 
 * Note:
 *  Assume we are dealing with an environment which could only store integers within the 
 *  32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem, 
 *  assume that your function returns 0 when the reversed integer overflows.
 */
class Leetcode7ReverseInteger {
    public static int reverse(int x) {
        if(x < Math.pow(-2, 31)) {
            return 0;
        }

        long reverse = 0;

        // Break down by each digit to append to result int.
        while(x != 0) {
            int singleDigit = x % 10;   // Get smallest digit
            x /= 10;    // Remove digit from x

            reverse = reverse * 10 + singleDigit;
            if(reverse > Integer.MAX_VALUE || reverse < Integer.MIN_VALUE) {
                return 0;
            }
        }

        return (int)reverse;
    }

    public static void main(String[] args) {
        int[][] testIO = {
            {123, 321},
            {-123, -321},
            {120, 21}
        };

        for(int[] expectedIO : testIO) {
            System.out.println("Input: " + expectedIO[0]);            
            System.out.println("Expected: " + expectedIO[1]);

            int output = reverse(expectedIO[0]);
            System.out.println("Output: " + output);
            System.out.println((output == expectedIO[1] ? "--- PASS ---" : "--- FAIL ---") + "\n");
        }
    }
}