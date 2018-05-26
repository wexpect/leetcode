Given a sorted linked list, delete all duplicates such that each element appear only once.

For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.



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
    public ListNode deleteDuplicates(ListNode head) {
        if( head == null )
            return head;
        
        HashSet<Integer> hashSet = new HashSet<Integer>();
        
        hashSet.add( head.val );
        
        ListNode node = head;
        
        while( node.next != null ){
            int val = node.next.val;
            
            if( hashSet.contains( val ) ){
                node.next = node.next.next;
            }
            else{
                hashSet.add( val );
                node = node.next;
            }
        }
        
        return head;
    }
}
