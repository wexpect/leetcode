Merge Two Sorted Lists Total Accepted: 3717 Total Submissions: 11477 My Submissions
Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.


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
    public ListNode mergeTwoLists(ListNode n1, ListNode n2) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        if( n1 == null && n2 == null)
            return null;
        
        ListNode newHead = null;
        ListNode newTail = null;
        ListNode cutNode = null;
        
        while( n1 != null || n2 != null){
            if( ( n1 != null && n2 != null && n1.val < n2.val) || n2 == null ) {
                cutNode = n1;
                n1 = n1.next;
            }
            else{
                cutNode = n2;
                n2 = n2.next;                
            }
            
            if( newHead == null ){
                newHead = cutNode;
                newTail = newHead;
            }
            else{
                newTail.next = cutNode;
                newTail = cutNode;
            }
        }
        
        newTail.next = null;
        
        return newHead;
    }
    
}
