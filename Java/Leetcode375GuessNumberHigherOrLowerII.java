import HelperClasses.GuessGame;

/**
 * Leetcode 375: Guess Number Higher or Lower II (Medium)
 * https://leetcode.com/problems/guess-number-higher-or-lower-ii/
 * 
 * We are playing the Guess Game. The game is as follows:
 * I pick a number from 1 to n. You have to guess which number I picked.
 * Every time you guess wrong, I'll tell you whether the number I picked is higher or lower.
 * 
 * However, when you guess a particular number x, and you guess wrong, you pay $x. 
 * You win the game when you guess the number I picked.
 * 
 * Example:
 *  n = 10, I pick 8.
 *      First round:  You guess 5, I tell you that it's higher. You pay $5.
 *      Second round: You guess 7, I tell you that it's higher. You pay $7.
 *      Third round:  You guess 9, I tell you that it's lower. You pay $9.
 *  Game over. 8 is the number I picked.
 *  You end up paying $5 + $7 + $9 = $21.
 */
public class Leetcode375GuessNumberHigherOrLowerII extends GuessGame{

    // DP approach (100% spd, 5.17% mem)
    public static int getMoneyAmount(int n) {
        return 0;
    }
}