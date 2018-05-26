Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.



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
    public int maxDepth(TreeNode root) {
        if( root == null )
            return 0;
            
        return maxDep( root );
    }
    
    public int maxDep(TreeNode node){
        if( node == null )
            return -1;
        
        return 1 + Math.max( maxDepth(node.left), maxDepth(node.right) );            
    }
}

/*
Wrong Answer
Input:	{}
Output:	-2
Expected:	0
*/




http://stackoverflow.com/questions/2603692/what-is-the-difference-between-tree-depth-and-height

The depth of a node is the number of edges from the node to the tree's root node.
A root node will have a depth of 0.

The height of a node is the number of edges on the longest path from the node to a leaf.
A leaf node will have a height of 0.


