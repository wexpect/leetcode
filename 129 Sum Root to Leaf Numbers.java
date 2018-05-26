Sum Root to Leaf Numbers Total Accepted: 3427 Total Submissions: 12465 My Submissions
Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

For example,

    1
   / \
  2   3
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.

Return the sum = 12 + 13 = 25.





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
    public int sumNumbers(TreeNode root) {
        if( root == null)
            return 0;
        
        Result result = new Result();
        getSum(root, 0, result);
        
        return result.sum;
    }
    
    public void getSum(TreeNode n, int value, Result result){
        
        value = 10 * value + n.val;

        if( n.left == null && n.right == null ){
            result.sum += value;
            return;
        }
        else{
            if( n.left != null)
                getSum(n.left, value, result);
            if( n.right != null)
                getSum(n.right, value, result);
        }

    }
    
    public class Result{
        public int sum = 0;
    }
}

/*
Submission Result: Wrong Answer

Input:	{9}
Output:	18
Expected:	9

*/