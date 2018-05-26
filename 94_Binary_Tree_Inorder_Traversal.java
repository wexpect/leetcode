Given a binary tree, return the inorder traversal of its nodes' values. (do it iteratively)

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [1,3,2].

Note: Recursive solution is trivial, could you do it iteratively?

confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.


OJ's Binary Tree Serialization:
The serialization of a binary tree follows a level order traversal, where '#' signifies a path terminator where no node exists below.

Here's an example:
   1
  / \
 2   3
    /
   4
    \
     5
The above binary tree is serialized as "{1,2,3,#,#,4,#,#,5}".




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
    public List<Integer> inorderTraversal(TreeNode root) {
        if( root == null)
            return new ArrayList<Integer>();
        
        //List<Integer> list = new List<Integer>();  //error: List is abstract; cannot be instantiated
        List<Integer> list = new ArrayList<Integer>();
        
        TreeNode node = root;
        
        while( node.left != null){
            node = rotate( node );
        }
    
        while( node.right != null){
            
            TreeNode rightNode = node.right;
            
            // Solu 1: works
            // if( rightNode.left != null){
            //     rightNode = rotate( rightNode );
            //     node.right = rightNode;
            // }
            // else{
            //     list.add(node.val);
                
            //     node = node.right;
            // }
            
        
            // Solu 2: works. essentially same as Solu 1, but simplier to write    
            while( rightNode.left != null){
                rightNode = rotate( rightNode );
            }
            
            node.right = rightNode;
                 
            list.add(node.val);
            
            node = node.right;
        }
        
        list.add(node.val);
        
        return list;
    }
    
    public TreeNode rotate( TreeNode node ){
        
        TreeNode rightMostNode = getRightMost( node.left );
        
        TreeNode newRoot = node.left;
        
        node.left = null;
        rightMostNode.right = node;
        
        return newRoot;
    }
    
    public TreeNode getRightMost(TreeNode node){
        
        while(node.right != null){
            node = node.right;
        }
        
        return node;
    }
    
    
}

/*
Compile Error
Line 15: error: List is abstract; cannot be instantiated
List<Integer> list = new List<Integer>();


Input:	{}
Output:	null
Expected:	[]
*/
