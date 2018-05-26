Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.


public class Solution {
    public int minPathSum(int[][] grid) {
        if( grid == null )
            return -1;
            
        return minPathSum(0,0,grid,grid.length,grid[0].length, new HashMap<Point, Integer>() );
    }
    
    public int minPathSum(int r, int c, int[][] grid, int numRow, int numCol, HashMap<Point, Integer> hashMap){
        if( r > numRow-1 || c > numCol - 1)
            return Integer.MAX_VALUE;
        
        if( r == numRow - 1 && c == numCol -1)
            return grid[r][c];
    
        Point point = new Point(r,c);
        
        if( hashMap.containsKey(point) )
            return hashMap.get( point );
            
        int sum = grid[r][c] + Math.min( minPathSum( r + 1, c, grid, numRow, numCol, hashMap),  minPathSum( r, c + 1, grid, numRow, numCol, hashMap) );
            
        hashMap.put(point, sum);
        
        return sum;
    }
    
    public class Point{
        public int r = 0;
        public int c = 0;
        
        public Point(int x, int y){
            r = x;
            c = y;
        }
        
        @Override
        public boolean equals(Object obj){
            Point p = (Point) obj;
            
            if( r == p.r && c == p.c)
                return true;
            else
                return false;
        }
        
        @Override
        public int hashCode(){
            return r + 31 * c;
        }
    }
    
}
