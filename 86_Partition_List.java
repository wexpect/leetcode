Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5.




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
    // Solu 1: does not work, see code comments
/*    
	  public static ListNode partition(ListNode head, int x) {
	        if( head == null || head.next == null)
	            return head;
	        
	        
	        ListNode node = head;
	        ListNode l1Head = null;
	        ListNode l1Tail = null;
	        ListNode l2Head = null;
	        ListNode l2Tail = null;
	        
	        while( node != null){
	            if( node.val < x){
	                appendToList(l1Head, l1Tail, node);
	            }
	            else{
	                appendToList(l2Head, l2Tail, node);
	            }
	            
	            node = node.next;
	        }
	        
	        if( l1Head != null){
	            l1Tail.next = l2Head;
	            return l1Head;
	        }
	        else
	            return l2Head;
	        
	    }
	    
	    
	  
	    public static void appendToList(ListNode head, ListNode tail, ListNode node){
	    
	               if( head == null){    // this does not work because the references head and tail point to other obejcts
	                    head = node;
	                    tail = node;
	                }
	                else{
	                    tail.next = node;
	                    tail = node;
	                }
	    }
*/	    
	    
	    
    // Solu 2: works
    public ListNode partition(ListNode head, int x) {
        if( head == null || head.next == null)
            return head;
        
        
        ListNode node = head;
        ListNode l1Head = null;
        ListNode l1Tail = null;
        ListNode l2Head = null;
        ListNode l2Tail = null;
        
        while( node != null){
            if( node.val < x){
                if( l1Head == null){
                    l1Head = node;
                    l1Tail = node;
                }
                else{
                    l1Tail.next = node;
                    l1Tail = node;
                }
            }
            else{
                if( l2Head == null){
                    l2Head = node;
                    l2Tail = node;
                }
                else{
                    l2Tail.next = node;
                    l2Tail = node;
                }
            }
            
            node = node.next;
        }
        
        
        if( l2Tail != null )
            l2Tail.next = null;  // without this, result is a loop, causing: Time Limit Exceeded
        
        if( l1Head != null){
            l1Tail.next = l2Head;
            return l1Head;
        }
        else
            return l2Head;
        
    }
    
}
