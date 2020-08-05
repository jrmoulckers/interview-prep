import HelperClasses.GuessGame;

/**
 * Leetcode 278: Guess Number Higher or Lower (EASY)
 * https://leetcode.com/problems/guess-number-higher-or-lower/
 * 
 * We are playing the Guess Game. The game is as follows: I pick a number from 1
 * to n. You have to guess which number I picked. Every time you guess wrong,
 * I'll tell you whether the number is higher or lower. You call a pre-defined
 * API guess(int num) which returns 3 possible results (-1, 1, or 0):
 * 
 * -1 : My number is lower 1 : My number is higher 0 : Congrats! You got it!
 * Example : Input: n = 10, pick = 6 Output: 6
 */
public class Leetcode374GuessNumberHigherOrLower extends GuessGame{
    /** 
     * Forward declaration of guess API.
     * @param  num   your guess
     * @return 	     -1 if num is lower than the guess number
     *			      1 if num is higher than the guess number
     *               otherwise return 0
     * int guess(int num);
    */
    // Binary search approach (100% spd, 5.17% mem)
    public static int guessNumber(int n) {
        return makeGuess(1, n);
    }

    public static int makeGuess(int lo, int hi) {
        if(lo == hi) {
            return lo;
        }
        int mid = lo + (hi - lo) / 2;
        // Num is higher than mid
        if(guess(mid) > 0) {
            return makeGuess(mid + 1, hi);
        } else {
            return makeGuess(lo, mid);
        }
    }
}