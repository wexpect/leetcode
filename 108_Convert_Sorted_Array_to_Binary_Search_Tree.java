Given an array where elements are sorted in ascending order, convert it to a height balanced BST.


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
    public TreeNode sortedArrayToBST(int[] num) {
        if( num == null || num.length == 0)
            return null;
            
        return toBST(num, 0, num.length - 1);
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
