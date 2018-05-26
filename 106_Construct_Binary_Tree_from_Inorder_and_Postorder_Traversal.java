Given inorder and postorder traversal of a tree, construct the binary tree.

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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if( postorder == null || inorder == null || postorder.length != inorder.length )
            return null;
            
        return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1 );        
    }
    

    public TreeNode build(int[] inorder, int leftIn, int rightIn, int[] postorder, int leftPost, int rightPost){
        if( leftIn > rightIn || leftPost > rightPost)
            return null;
        
        if( leftIn == rightIn || leftPost == rightPost)
            return new TreeNode( postorder[rightPost] );
        
        int rootVal = postorder[rightPost];
        int rootInd = search(inorder, leftIn, rightIn, rootVal);
        
        TreeNode root = new TreeNode( rootVal );
        
        root.left = build(inorder, leftIn, rootInd - 1, postorder, leftPost , leftPost + (rootInd - leftIn) -1 );
        root.right = build(inorder, rootInd + 1, rightIn, postorder, leftPost + (rootInd - leftIn), rightPost -1 );
        
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
