/**
 * Leetcode 13: Roman to Integer (EASY)
 * https://leetcode.com/problems/roman-to-integer/
 * 
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 * 
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * For example, two is written as II in Roman numeral, just two one's added together. Twelve is written as, XII, which is simply X + II. The number twenty seven is written as XXVII, which is XX + V + II.
 * 
 * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
 * 
 * I can be placed before V (5) and X (10) to make 4 and 9. 
 * X can be placed before L (50) and C (100) to make 40 and 90. 
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999.

 * Example 1:
 *  Input: "III"
 *  Output: 3
 * 
 * Example 2:
 *  Input: "IV"
 *  Output: 4
 * 
 * Example 3:
 *  Input: "IX"
 *  Output: 9
 * 
 * Example 4:
 *  Input: "LVIII"
 *  Output: 58
 *  Explanation: L = 50, V= 5, III = 3.
 * 
 * Example 5:
 *  Input: "MCMXCIV"
 *  Output: 1994
 *  Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 */

public class Leetcode13RomanToInteger {
    // Main solution in linear time (85.09% spd, 26.73% mem)
    public static int romanToInt(String s) {
        int total = 0;
        // Go through each character in the provided roman numeral value
        for(int i = 0; i < s.length(); i++) {
            // Get current and next numeral values
            int thisVal = getVal(s.charAt(i));
            int nextVal = i + 1 < s.length() ? getVal(s.charAt(i + 1)) : 0;
            // If current value is less than next, it will subtract
            if(thisVal < nextVal) {
                total -= thisVal;
            } else {   
                total += thisVal;
            }
        }

        return total;
    }

    // Returns value for corresponding numeral
    public static int getVal(char c) {
        switch(c) {
            case 'M': return 1000;
            case 'D': return 500;
            case 'C': return 100;
            case 'L': return 50;
            case 'X': return 10;
            case 'V': return 5;
            case 'I': return 1;
        }
        return 0;
    }
    
    public static void main(String[] args) {
        String[] testInputs = {"III", "IV", "IX", "LVIII", "MCMXCIV"};
        int[] testOutputs = {3, 4, 9, 58, 1994};

        for(int test = 0; test < testInputs.length; test++) {
            System.out.println();
            System.out.println("Input: " + testInputs[test]);            
            System.out.println("Expected: " + testOutputs[test]);

            int output1 = romanToInt(testInputs[test]);
            System.out.println("Output: " + output1);
            System.out.println((output1 == testOutputs[test] ? "--- PASS ---" : "--- FAIL ---"));
        }
    }
}