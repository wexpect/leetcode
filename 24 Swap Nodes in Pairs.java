Swap Nodes in Pairs Total Accepted: 3325 Total Submissions: 10554 My Submissions
Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode n) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        if( n == null || n.next == null)
            return n;
            
        ListNode preHead = new ListNode(-1);
        preHead.next = n;
        n = preHead;
        
        while( n.next != null && n.next.next != null){
            ListNode next1 = n.next;
            ListNode next2 = n.next.next;
            ListNode next3 = n.next.next.next;
            
            n.next = next2;
            next2.next = next1;
            next1.next = next3;
            
            n = next1;
        }
        
        return preHead.next;
    }
}