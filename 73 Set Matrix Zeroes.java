Set Matrix Zeroes Total Accepted: 2462 Total Submissions: 8331 My Submissions
Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.

click to show follow up.

Follow up:
Did you use extra space?
A straight forward solution using O(mn) space is probably a bad idea.
A simple improvement uses O(m + n) space, but still not the best solution.
Could you devise a constant space solution?



public class Solution {
    
    // Solu 1: brute force, using O(mn) space
    // Solu 2: using one row[] and one column[], using O(m+n) spce
    
    // Solu 3: O(1)
    // Idea: 
    // using first column of the matrix as row[], and first row of the matrix as the column[]
    // the first pass: change the value of row[] and column[]
    // the second pass: do not touch the first column and first row of the matrix, start from matrix[1][1] until matrix[m-1][n-1] 
    
    public void setZeroes(int[][] matrix) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
    }
}