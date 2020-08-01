import HelperClasses.*;

/**
 * Leetcode 21: Merge Two Sorted Lists (EASY)
 * https://leetcode.com/problems/merge-two-sorted-lists/
 * 
 * Merge two sorted linked lists and return it as a new sorted list. 
 * The new list should be made by splicing together the nodes of the first two lists.
 * 
 * Example:
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 */
public class Leetcode21MergeTwoSortedLists {
    // Clean simple merge comparison (100% spd, 59.32% mem)
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode merged = new ListNode(); //Create dummy list node
        ListNode current = merged;
        while(l1 != null && l2 != null) {
            // Case: element from l1 is next to push onto list
            if (l2 == null || l2.val > l1.val) {
                current.next = l1;
                l1 = l1.next;
                current = current.next;
            } 
            // Case: element from l2 is lesser than l1 value
            else {
                current.next = l2;
                l2 = l2.next;
                current = current.next;
            }
        }
        current.next = l1 == null ? l2 : l1;
        return merged.next;
    }

    // Simple merge comparison (100% spd, 71.95% mem)
    public ListNode mergeTwoListsSimple(ListNode l1, ListNode l2) {
        ListNode merged = new ListNode(); //Create dummy list node
        ListNode current = merged;
        while(l1 != null || l2 != null) {
            // Case: element from l2 is only option
            if(l1 == null) {
                current.next = l2;
                l2 = l2.next;
                current = current.next;
            } 
            // Case: element from l1 is next to push onto list
            else if (l2 == null || l2.val > l1.val) {
                current.next = l1;
                l1 = l1.next;
                current = current.next;
            } 
            // Case: element from l2 is lesser than l1 value
            else {
                current.next = l2;
                l2 = l2.next;
                current = current.next;
            }
        }
        return merged.next;
    }
}