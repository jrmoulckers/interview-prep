import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Leetcode 22: Generate Parentheses (MEDIUM)
 * https://leetcode.com/problems/generate-parentheses/
 * 
 *  Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * 
 * For example, given n = 3, a solution set is: 
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 */
public class Leetcode22GenerateParentheses {
    // Recursive backtracking solution (89.18% spd, 18.42% mem)
    public static List<String> generateParenthesis(int n) {
        List<String> generated = new ArrayList<>();
        generateRecursively(generated, "", 0, 0, n);
        return generated;
    }

    public static void generateRecursively(List<String> generated, String current, int open, int closed, int n) {
        // Base case: reached length
        if(current.length() == n * 2) {
            generated.add(current);
            return;
        }

        // Treat open case: add one to open count, add opening parenthesis
        if(open < n) {
            generateRecursively(generated, current + '(', open + 1, closed, n);
        } 
        // Treat closed case: add one to closed count, add closing parenthesis
        if(closed < open) {
            generateRecursively(generated, current + ')', open, closed + 1, n);
        }
    }

    public static void main(String[] args) {
        int[] testInputs = {3};
        String[][] testOutputs = {
            {  "((()))", "(()())", "(())()", "()(())", "()()()"}
        };

        for(int test = 0; test < testInputs.length; test++) {
            System.out.println();
            System.out.println("Input: " + testInputs[test]);            
            System.out.println("Expected: " + Arrays.toString(testOutputs[test]));

            List<String> output1 = generateParenthesis(testInputs[test]);
            System.out.println("Output: " + output1);
            System.out.println((isEquivalent(output1, testOutputs[test]) ? "--- PASS ---" : "--- FAIL ---"));
        }
    }  

    // Compares both string arrays
    public static boolean isEquivalent(List<String> a, String[] b) {
        if (a.size() != b.length) {
            return false;
        }

        for(int i = 0; i < a.size(); i++) {
            if(!a.get(i).equals(b[i])) {
                return false;
            }
        }

        return true;
    }
}