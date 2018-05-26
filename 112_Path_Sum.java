Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.




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
    public boolean hasPathSum(TreeNode root, int sum) {
        
        if( root == null )
            return false;
        
        
        if( root.left != null && root.right != null ){
            return hasPathSum( root.left, sum - root.val) || hasPathSum( root.right, sum - root.val );
        }
        else if( root.left != null ){
            return hasPathSum( root.left, sum - root.val );
        }
        else if( root.right != null ){
            return hasPathSum( root.right, sum - root.val );
        }
        else{
            if( root.val == sum )
                return true;
            else
                return false;
        }
            
    }
    
}

/*
Wrong Answer:

Input:	{}, 0
Output:	true
Expected:	false


Definition of leaf: node that has no children
Input:	{1,2}, 1  // so, the root node 1 is not a leaf
Output:	true
Expected:	false

*/
