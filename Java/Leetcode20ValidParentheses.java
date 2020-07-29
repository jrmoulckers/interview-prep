import java.util.Stack;

/**
 * Leetcode 20: Valid Parentheses (EASY)
 * https://leetcode.com/problems/valid-parentheses/
 * 
 * Given a string containing just the characters '(', ')', '{', '}', '[' and
 * ']', determine if the input string is valid. An input string is valid if:
 * 
 * 1. Open brackets must be closed by the same type of brackets. 2. Open
 * brackets must be closed in the correct order. Note that an empty string is
 * also considered valid.
 * 
 * Example 1: Input: "()" Output: true
 * 
 * Example 2: Input: "()[]{}" Output: true
 * 
 * Example 3: Input: "(]" Output: false
 * 
 * Example 4: Input: "([)]" Output: false
 * 
 * Example 5: Input: "{[]}" Output: true
 */
public class Leetcode20ValidParentheses {
    // Linear search with stack: best solution (99.15% spd, 20.90% mem)
    public static boolean isValid(String s) {
        Stack<Character> order = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            if(isOpeningBrace(s.charAt(i))) {
                order.push(s.charAt(i));
            } else if (order.empty() || !isCounterpart(order.peek(), s.charAt(i))) {
                return false;   // Closing brace without match: invalid
            } else {
                order.pop();
            } 
        }
        return order.empty();
    }

    // Returns whether the character is an opening brace
    public static boolean isOpeningBrace(char c) {
        switch(c) {
            case '(':
            case '{':
            case '[':
                return true;
        }
        return false;
    }

    // Returns whether the braces are counterparts
    public static boolean isCounterpart(char opening, char closing) {
        switch(opening) {
            case '(':
                return closing == ')';
            case '{':
            return closing == '}';
            case '[':
            return closing == ']';
        }
        return false;
    }

    public static void main(String[] args) {
        String[] testInputs = {"()", "()[]{}", "(]", "([)]", "{[]}"};
        boolean[] testOutputs = {true, true, false, false, true};

        for(int test = 0; test < testInputs.length; test++) {
            System.out.println();
            System.out.println("Input: " + testInputs[test]);            
            System.out.println("Expected: " + testOutputs[test]);

            boolean output1 = isValid(testInputs[test]);
            System.out.println("Output: " + output1);
            System.out.println((output1 == testOutputs[test] ? "--- PASS ---" : "--- FAIL ---"));
        }
    }  
}