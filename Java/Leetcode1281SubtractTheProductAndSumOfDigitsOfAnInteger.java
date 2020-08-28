/**
 * Leetcode 1281: Subtract the Product and Sum of Digits of an Integer (EASY)
 * https://leetcode.com/problems/subtract-the-product-and-sum-of-digits-of-an-integer/
 *
 * Given an integer number n, return the difference between the product of its digits and the sum of its digits.
 *  
 * Example 1:
 *     Input: n = 234
 *     Output: 15 
 *     Explanation: 
 *     Product of digits = 2 * 3 * 4 = 24 
 *     Sum of digits = 2 + 3 + 4 = 9 
 *     Result = 24 - 9 = 15
 * 
 * Example 2:
 *     Input: n = 4421
 *     Output: 21
 *     Explanation: 
 *     Product of digits = 4 * 4 * 2 * 1 = 32 
 *     Sum of digits = 4 + 4 + 2 + 1 = 11 
 *     Result = 32 - 11 = 21
 *  
 * Constraints:
 *     1 <= n <= 10^5
 */
public class Leetcode1281SubtractTheProductAndSumOfDigitsOfAnInteger {
    // Simple iterative modulus solution (100% spd, 71.97% mem)
    public int subtractProductAndSum(int n) {
        int sum = 0;
        int product = 1;

        while(n != -1) {
            int currentDigit = n % 10;
            n = (n/10 == 0) ? -1 : (n / 10); // If on last digit of n, mark as complete
            sum += currentDigit;
            product *= currentDigit;
        }

        return product - sum;
    }
}