Given a binary tree, flatten it to a linked list in-place.

For example,
Given

         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:
   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
click to show hints.


Hints:
If you notice carefully in the flattened tree, each node's right child points to the next node of a pre-order traversal.



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
    public void flatten(TreeNode root) {
        if( root == null )
            return;
 

          
        // solu 2: iterative. in place  
        TreeNode node = root;
        
        while( node != null){
            
            if( node.left != null ){
                TreeNode rightMostNode = getRightMost( node.left );
                rightMostNode.right = node.right;
                node.right = node.left;
                node.left = null;
            }
            
            node = node.right;
        }
           
        return;
            
        // solu 1    
        // flat( root );
    }
  
    
/*
Solu 1: resursive (not in place)

In the final result, all node.left must be null, or else will get error "Time Limit Exceeded"
Time Limit Exceeded
Last executed input:	{1,2}
*/    
    public TreeNode flat(TreeNode node){
        if( node == null ){
            return null;
        }
        
        
        TreeNode tail = node;
        TreeNode left = node.left;
        TreeNode right = node.right;
        
        TreeNode leftTail = flat( left );
        TreeNode rightTail = flat( right );
        
        if( left != null ){
            tail.right = left;
            // left.left = tail;  
            tail = leftTail;
        }
        
        if( right != null ){
            tail.right = right;
            // right.left = tail;
            tail = rightTail;
        }
        
        node.left = null;
        tail.right = null;
        
        return tail;
    }


/*
Memory Limit Exceeded
*/    
/*    

    public TreeNode[] flat(TreeNode node){
        if( node == null ){
            TreeNode[] fullList = {null, null};
            return fullList;
        }
        
        
        TreeNode tail = node;
        TreeNode[] leftList = flat( node.left );
        TreeNode[] rightList = flat( node.right );
        
        if( leftList[0] != null ){
            tail.right = leftList[0];
            leftList[0].left = tail;
            tail = leftList[1];
        }
        
        if( rightList[0] != null ){
            tail.right = rightList[0];
            rightList[0].left = tail;
            tail = rightList[1];
        }
        
        node.left = null;
        tail.right = null;
        TreeNode[] fullList = {node, tail};
        
        return fullList;
    }
*/


}


/*
Ans:
https://oj.leetcode.com/discuss/22316/in-place-java-solution-with-detail-explanation

In order to do it in place, no stack or queue or recursive calls are allowed. Then, the only thing I can use is the tree structure itself.

Firstly, I want to traversal to the very most left TreeNode, and then put it in between of itself parent TreeNode and right brother TreeNode. That gives me a problem:

I need something to store its parent, and to work for each very most left TreeNode, I need to store each parent I meet, which leads to stack. That's extra space.

Thus, I cannot traversal until very most, neither can I traversal away from the main root node. Each time my TreeNode pointer is away from root node, I need to make sure the root node is fine to go.

That leads me to a second trial. Always going down the right branch, when a node has a left branch, put the left branch in between of itself and its right branch.

public class Solution {
    public void flatten(TreeNode root) {
        TreeNode head = new TreeNode(0);
        head.right = root;
        TreeNode node = head;
        while(node.right!=null){
            node = node.right;
            if(node.left!=null){
                TreeNode end = node.left;
                while(end.right!=null){
                    end = end.right;
                }
                TreeNode temp = node.right;
                node.right = node.left;
                node.left = null;
                end.right = temp;
            }
        }
        head.right = null;
    }
}
*/
