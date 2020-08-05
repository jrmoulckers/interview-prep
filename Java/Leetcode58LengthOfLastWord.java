/**
 * Leetcode 58: Length of Last Word (EASY)
 * https://leetcode.com/problems/length-of-last-word/
 * 
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', 
 * return the length of last word (last word means the last appearing word if we loop from 
 * left to right) in the string.
 * If the last word does not exist, return 0.
 * 
 * Note: A word is defined as a maximal substring consisting of non-space characters only.
 * 
 * Example:
 *  Input: "Hello World"
 *  Output: 5
 */
public class Leetcode58LengthOfLastWord {

    // Simple reverse linear pass approach (100% spd, 5.02% mem)
    public static int lengthOfLastWord(String s) {                
        int count = 0;
        for(int i = s.length() - 1; i >= 0; i--){
            if(s.charAt(i) == ' ') {
                if(count!=0) {
                    return count;
                }
            }
            else {
                count++;
            }
        }
        return count;      
    }
    
    public static void main(String[] args) {
        String[] testInputs = {"Hello World", "a", "a "};

        int[] testOutputs = {5, 1, 1};

        for(int test = 0; test < testInputs.length; test++) {
            System.out.println();
            System.out.println("Input: " + testInputs[test]);            
            System.out.println("Expected: " + testOutputs[test]);
            int output = lengthOfLastWord(testInputs[test]);
            System.out.println("Output: " + output);
            System.out.println(output == testOutputs[test] ? "--- PASS ---" : "--- FAIL ---");
        }
    } 
}