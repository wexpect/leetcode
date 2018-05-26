Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if( head == null )
            return null;
        
        int[] arr = listToArr( head );
        return toBST(arr, 0, arr.length - 1);
    }
    
    public int[] listToArr( ListNode head ){
        int count = 0;
        
        ListNode node = head;
        while( node != null ){
            count++;
            node = node.next;
        }
        
        int[] arr = new int[count];
        node = head;
        for(int i = 0; i < count; i++){
            arr[i] = node.val;
            node = node.next;
        }
        
        return arr;
    }
    
    public TreeNode toBST(int[] arr, int left, int right){
        if( left > right)
            return null;
        
        int mid = (left + right)/2;
        TreeNode node = new TreeNode( arr[mid] );
        node.left = toBST(arr, left, mid - 1);
        node.right = toBST(arr, mid + 1, right);
        
        return node;
    }
}
