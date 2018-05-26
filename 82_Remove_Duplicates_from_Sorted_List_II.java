Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

For example,
Given 1->2->3->3->4->4->5, return 1->2->5.
Given 1->1->1->2->3, return 2->3.



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
        
        
        ListNode node = head;
        
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        
        while( node != null){
            int val = node.val;
            
            if( hashMap.containsKey( val) ) {   // HashMap: containsKey()
                hashMap.put( val, hashMap.get(val) + 1 );  // HashMap: put()
            }
            else{
                hashMap.put( val, 1);
            }
            
            node = node.next;
        }
        
        node = head;
        
        while( node.next != null ){
            int val = node.next.val;
            
            if( hashMap.get(val) >= 2 ){
                node.next = node.next.next;
            }
            else{
                node = node.next;
            }
        }
        
        if( hashMap.get( head.val ) >= 2 )
            return head.next;
        else
            return head;
            
    }
}

