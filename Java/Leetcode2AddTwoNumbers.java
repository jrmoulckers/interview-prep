import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

import HelperClasses.ListNode;

/**
 * LeetCode 2: Add Two Numbers
 * https://leetcode.com/problems/add-two-numbers/
 * 
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * 
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * 
 * Example:
 * 
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */

public class Leetcode2AddTwoNumbers {
    // Arithmetic approach. Form single linked list with sum, treat carry case.
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ret = new ListNode(0); //Dummy pointer for list reference
        int carry = 0;
        ListNode curr = ret;

        while(l1 != null || l2 != null) {
            int v1 = (l1 != null)? l1.val : 0;
            int v2 = (l2 != null)? l2.val : 0;

            int sum = v1 + v2 + carry;
            carry = sum / 10;   // Treat carry case: add 1 to next node
            curr.next =  new ListNode(sum % 10);

            curr = curr.next;
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;                
        }
        // Edge case: carried value still exists: add another node with carry value
        if(carry > 0) {
            curr.next = new ListNode(carry);
        }
        return ret.next;
    }
}