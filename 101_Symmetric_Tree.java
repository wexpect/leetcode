Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following is not:
    1
   / \
  2   2
   \   \
   3    3
Note:
Bonus points if you could solve it both recursively and iteratively.


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
    
    // solu 1: recursion. works
    // public boolean isSymmetric(TreeNode root) {
    //     if( root == null )
    //         return true;
        
    //     return isSym(root.left, root.right);
    // }
    
    // public boolean isSym(TreeNode n1, TreeNode n2){
        
    //     if( n1 == null && n2 == null )
    //         return true;
    //     else if( n1 == null || n2 == null )
    //         return false;
    //     else{
    //         return ( n1.val == n2.val ) && isSym( n1.left, n2.right) && isSym( n1.right, n2.left);
    //     }
    // }
    
    
    // solu 2: iteration. works
    public boolean isSymmetric(TreeNode root) {
        if( root == null )
            return true;
      
        LinkedList<TreeNode> list1 = new LinkedList<TreeNode>();
        LinkedList<TreeNode> list2 = new LinkedList<TreeNode>();
        
        list1.addLast( root.left );
        list2.addLast( root.right );
        
        TreeNode n1 = null;
        TreeNode n2 = null;
        
        while( !list1.isEmpty() && !list2.isEmpty() ){
            n1 = list1.removeFirst();
            n2 = list2.removeFirst();
            
            if( (n1 == null && n2 != null) || (n1 != null && n2 == null) ){
                return false;
            }
            else if( n1 != null && n2 != null){
                if( n1.val != n2.val )
                    return false;
                
                list1.addLast( n1.left );
                list1.addLast( n1.right );
                
                list2.addLast( n2.right );
                list2.addLast( n2.left );
            }
        } 
        
        return true;
    }
    
}
