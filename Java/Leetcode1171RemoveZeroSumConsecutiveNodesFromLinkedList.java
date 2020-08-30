import java.util.HashMap;
import HelperClasses.ListNode;

/**
 * Leetcode 1171: Remove Zero Sum Consecutive Nodes from Linked List (MEDIUM)
 * https://leetcode.com/problems/remove-zero-sum-consecutive-nodes-from-linked-list/
 * 
 * Given the head of a linked list, we repeatedly delete consecutive sequences of nodes 
 * that sum to 0 until there are no such sequences.
 * After doing so, return the head of the final linked list.
 * You may return any such answer.
 * 
 * (Note that in the examples below, all sequences are serializations of ListNode objects.)
 * 
 * Example 1:
 *  Input: head = [1,2,-3,3,1]
 *  Output: [3,1]
 *  Note: The answer [1,2,1] would also be accepted.
 * 
 * Example 2:
 *  Input: head = [1,2,3,-3,4]
 *  Output: [1,2,4]
 * 
 * Example 3:
 *  Input: head = [1,2,3,-3,-2]
 *  Output: [1]
 *  
 * 
 * Constraints:
 *  The given linked list will contain between 1 and 1000 nodes.
 *  Each node in the linked list has -1000 <= node.val <= 1000.
 */
public class Leetcode1171RemoveZeroSumConsecutiveNodesFromLinkedList {

    // Running total HashMap approach (92.99% spd, 82.78% mem)
    public ListNode removeZeroSumSublists(ListNode head) {
        // HashMap containing sums of nodes
        HashMap<Integer, ListNode> sums = new HashMap<>();
        ListNode returnList = new ListNode(0, head);
        ListNode current = head;
        int runningSum = 0;

        sums.put(0, returnList); // Must put dummy node for case of entire list adding to 0

        // Run through each node in the list
        while(current != null) {
            runningSum += current.val; // Add to running total

            // If sum exists, this means all values between added to 0
            if(sums.containsKey(runningSum)) {
                ListNode nodePriorToZeroSequence = sums.get(runningSum);

                // Remove all nodes in between from the sums map
                ListNode removingNode = nodePriorToZeroSequence.next;
                int sumToBeRemoved = runningSum;
                while(removingNode != current) {
                    sumToBeRemoved += removingNode.val;
                    sums.remove(sumToBeRemoved);
                    removingNode = removingNode.next;
                }

                nodePriorToZeroSequence.next = current.next;                
            } else {
                sums.put(runningSum, current); // Add the sum to the map otherwise
            }

            current = current.next;
        }

        return returnList.next; // Return the head (after our dummy node)
    }
}