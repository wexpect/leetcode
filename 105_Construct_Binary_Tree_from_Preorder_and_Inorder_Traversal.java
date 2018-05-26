Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.



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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if( preorder == null || inorder == null || preorder.length != inorder.length )
            return null;
            
        return build(inorder, 0, inorder.length - 1, preorder, 0, preorder.length - 1 );
    }
    
    public TreeNode build(int[] inorder, int leftIn, int rightIn, int[] preorder, int leftPre, int rightPre){
        if( leftIn > rightIn || leftPre > rightPre)
            return null;
        
        if( leftIn == rightIn || leftPre == rightPre)
            return new TreeNode( preorder[leftPre] );
        
        int rootVal = preorder[leftPre];
        int rootInd = search(inorder, leftIn, rightIn, rootVal);
        
        TreeNode root = new TreeNode( rootVal );
        
            root.left = build(inorder, leftIn, rootInd - 1, preorder, leftPre + 1, leftPre + (rootInd - leftIn) );
        root.right = build(inorder, rootInd + 1, rightIn, preorder, leftPre + (rootInd - leftIn) + 1, rightPre);
        
        return root;
    }
    
    
    public int search(int[] inorder, int leftIn, int rightIn, int target){
        for( int i = leftIn; i <= rightIn; i++){
            if( inorder[i] == target )
                return i;
        }
        
        return -1;
    }
}
