Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
For example,

Consider the following matrix:

[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
Given target = 3, return true.



public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if( matrix == null )
            return false;
        
        return searchMatrix(matrix, 0, matrix.length-1, 0, matrix[0].length-1, target);
    }
    
    public boolean searchMatrix(int[][] matrix, int minRow, int maxRow, int minCol, int maxCol, int target){
        if( minRow > maxRow || minCol > maxCol )
            return false;
        
        int row = (minRow + maxRow) /2;
        int col = (minCol + maxCol) /2;
        
        int val = matrix[row][col];
        
        if( target == val)
            return true;
            
        if( target < val)
            return searchMatrix(matrix, minRow, row - 1, minCol, maxCol, target) || 
                searchMatrix(matrix, row, row, minCol, col - 1, target);
        else
            return searchMatrix(matrix, row + 1, maxRow, minCol, maxCol, target) || 
                searchMatrix(matrix, row, row, col + 1, maxCol, target);
        
    }
}
