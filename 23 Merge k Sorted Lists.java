Merge k Sorted Lists Total Accepted: 2661 Total Submissions: 12213 My Submissions
Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.



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
    
    /*
     Solu 1: iteratively use "merge 2 sorted lists", until all k list are merged
     time O( k * sum(n_i) )
     space O( sum(n_i) ) 
    */
    
    /*
     Sollu 2: merge k list together, using minHeap<Element> to store the first value of each list
     Element is an object containg the value and the correspond index of that list
     
     while( countEmptyList < k ){
     }
    
    time O(k + lgk * sum(n_i) ), where k for build minHeap, lgk * sum(n_i) for get min, 
    space O( sum(n_i) ) 
    */
    
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
    }
}