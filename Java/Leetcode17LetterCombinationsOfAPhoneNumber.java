import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Leetcode 17: Letter Combinations of a Phone Number (MEDIUM)
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 * 
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 * 
 * (Use normal phone dialpad)
 * 
 * Example:
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 
 * Note:
 * Although the above answer is in lexicographical order, your answer could be in any order you want.
 */
public class Leetcode17LetterCombinationsOfAPhoneNumber {
    static Map<String, String> phone = new HashMap<>() {
        private static final long serialVersionUID = -8400616138424692332L;
        {
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};    
    // Recursive solution (fastest) (25.64% spd, 11.43% mem)
    public static List<String> letterCombinations(String digits) {
        List<String> generated = new ArrayList<>();
        generateRecursively(generated, "", digits);
        return generated;
    }

    public static void generateRecursively(List<String> generated, String current, String digits) {
        // Base case: reached length of input
        if(current.length() == digits.length()) {
            if(current.length() != 0) {
                generated.add(current);
            };
            return;
        }
        String currentDigit = digits.charAt(current.length()) + "";
        String digitLetters = phone.get(currentDigit);
        // Append each letter for this digit
        for(int letter = 0; letter < digitLetters.length(); letter++) {
            generateRecursively(generated, current + digitLetters.charAt(letter), digits);
        }
    }

    public static void main(String[] args) {
        String[] testInputs = {"23", ""};
        String[][] testOutputs = {
            {"ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"},
            {}
        };

        for(int test = 0; test < testInputs.length; test++) {
            System.out.println();
            System.out.println("Input: " + testInputs[test]);            
            System.out.println("Expected: " + Arrays.toString(testOutputs[test]));

            List<String> output1 = letterCombinations(testInputs[test]);
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