/**
 * LeetCode 9: Palindrome Number
 * https://leetcode.com/problems/palindrome-number/
 * 
 * Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
 * 
 * Example 1:
 *  Input: 121
 *  Output: true
 * 
 * Example 2:
 *  Input: -121
 *  Output: false
 *  Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 * 
 * Example 3:
 *  Input: 10
 *  Output: false
 *  Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 * 
 * Follow up:
 *  Coud you solve it without converting the integer to a string?
 */
public class Leetcode9PalindromeNumber {
    // String approach: convert to string, reverse string (9.23% spd, 5.02% mem)
    public static boolean isPalindromeString(int x) {
        String xAsString = Integer.toString(x);
        String palindromeAsString = "";
        for(int i = xAsString.length() - 1; i >= 0; i--) {
            palindromeAsString += xAsString.charAt(i);
        }
        
        return palindromeAsString.equals(xAsString);
    }

    // String approach (one pass), check as we go: convert to string, compare to normal
    // as we convert to palindrome. (60.61% spd, 14.76% mem)
    public static boolean isPalindromeBetterString(int x) {
        // Base case: no negative is a palindrome
        if(x < 0) {
            return false;
        }

        String xAsString = Integer.toString(x);
        int length = xAsString.length();
        
        //Check if each char has a match on the other side of the number
        for(int i = 0; i < length; i++) {
            if(xAsString.charAt(i) != xAsString.charAt(length - 1 - i)) {
                return false;
            }
        }
        
        return true;
    }

    // No-string approach: reverse int to find equivalency (83.78% spd, 11.49% mem)
    public static boolean isPalindromeNoString(int x) {
        // Base case: no negative is a palindrome
        if(x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int original = x;

        // Find the reversed value
        int reversed = 0;
        while(x > 0) {
            reversed = (reversed * 10) + (x % 10);
            x /= 10;
        }
        
        // Even case: numbers are equal
        // Odd case: numbers are equal when middle digit is removed from reverse
        return original == reversed;
    }

    // Best approach: no use of string, find halfway equivalency (100% spd, 9.98% mem)
    public static boolean isPalindrome(int x) {
        // Base case: no negative is a palindrome
        if(x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        // Find the reversed value halfway through the number
        int reversed = 0;
        while(x > reversed) {
            reversed = (reversed * 10) + (x % 10);
            x /= 10;
        }
        
        // Even case: numbers are equal
        // Odd case: numbers are equal when middle digit is removed from reverse
        return x == reversed || x == reversed / 10;
    }

    public static void main(String[] args) {
        int[] testInputs = {121, -121, 10};
        boolean[] testOutputs = {true, false, false};

        for(int test = 0; test < testInputs.length; test++) {
            System.out.println();
            System.out.println("Input: " + testInputs[test]);            
            System.out.println("Expected: " + testOutputs[test]);

            boolean output1 = isPalindromeString(testInputs[test]);
            System.out.println("String Aproach Output: " + output1);
            System.out.println((output1 == testOutputs[test] ? "--- PASS ---" : "--- FAIL ---"));
            boolean output2 = isPalindromeBetterString(testInputs[test]);
            System.out.println("Better String Approach Output: " + output2);
            System.out.println((output2 == testOutputs[test] ? "--- PASS ---" : "--- FAIL ---"));
            boolean output3 = isPalindromeNoString(testInputs[test]);
            System.out.println("No String Approach Output: " + output3);
            System.out.println((output3 == testOutputs[test] ? "--- PASS ---" : "--- FAIL ---"));
            boolean output4 = isPalindrome(testInputs[test]);
            System.out.println("Best Approach Output: " + output4);
            System.out.println((output4 == testOutputs[test] ? "--- PASS ---" : "--- FAIL ---") + "\n");
        }
    }
}