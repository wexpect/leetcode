A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?


Note: m and n will be at most 100.



public class Solution {
    public int uniquePaths(int m, int n) {
        if( m < 0 || n < 0 )
            return -1;
            
        int[][] record = new int[m][n];
        for(int i = 0; i < m; i++){
            for( int j = 0; j < n; j++){
                record[i][j] = -1;
            }
        }
        
        return uniquePaths(0,0,m,n,record);
    }
    
    public int uniquePaths(int r, int c, int m, int n, int[][] record){
        if( r > m-1 || c > n-1)
            return 0;
            
        if( r == m-1 && c == n-1)
            return 1;
            
        if( record[r][c] >= 0)
            return record[r][c];
            
        int count = uniquePaths(r+1, c, m,n,record) + uniquePaths(r, c+1, m,n,record);
        record[r][c] = count;
        
        return count;
    }
    
}



