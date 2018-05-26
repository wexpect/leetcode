Word Search Total Accepted: 2223 Total Submissions: 11715 My Submissions
Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

For example,
Given board =

[
  ["ABCE"],
  ["SFCS"],
  ["ADEE"]
]
word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.




public class Solution {
    
    // Solu 1: DFS
    public boolean exist(char[][] board, String word) {
        if( board == null || word == null || word.isEmpty() )
            return false;
        
        for(int r = 0; r < board.length; r++){
            for(int c = 0; c < board[0].length; c++){
                if( board[r][c] == word.charAt(0) ){
                    Point p = new Point(r,c);
                    
                    // should not use boolean visited[][], becasue a cell may be visited multiple times from different routes
                    boolean[][] isChecking = new boolean[board.length][board[0].length];
                    
                    if( DFS(board, p, word, 0, isChecking) )
                        return true;
                }
            }
        }
        
        return false;
    }
    
    public boolean DFS(char[][] board, Point p, String word, int ind, boolean[][] isChecking){
        
        if( board[p.r][p.c] != word.charAt(ind) )
            return false;
        else{
            isChecking[p.r][p.c] = true;
                    
            if( ind == word.length()-1 )
                return true;
        }
        
        for(Point q : getAdjacent(p, board) ){
            if( ! isChecking[q.r][q.c] ){
                if( DFS(board, q, word, ind+1, isChecking) )
                    return true;
            }
        }
        
        // must reset isChecking, so that this letter can be used by other routes
        isChecking[p.r][p.c] = false; 
        
        return false;
    }
    
    public ArrayList<Point> getAdjacent(Point p, char[][] board){
        ArrayList<Point> list = new ArrayList<Point>();
        
        if( inBoard(p.r-1, p.c, board) )
            list.add(new Point(p.r-1, p.c) );
        if( inBoard(p.r+1, p.c, board) )
            list.add(new Point(p.r+1, p.c) );
        if( inBoard(p.r, p.c-1, board) )
            list.add(new Point(p.r, p.c-1) );
        if( inBoard(p.r, p.c+1, board) )
            list.add(new Point(p.r, p.c+1) );            
        
        return list;
    }
    
    public boolean inBoard(int r, int c, char[][] board){
        if( 0 <= r && r < board.length && 0 <= c && c < board[0].length)
            return true;
        else
            return false;
    }
    
    public class Point{
        public int r;
        public int c;
        
        public Point(int rr, int cc){
            r = rr;
            c = cc;
        }
    }
    
}

/*
Submission Result: Wrong Answer

Input:	["a"], "a"
Output:	false
Expected:	true


Submission Result: Wrong Answer

Input:	["ab","cd"], "cdba"
Output:	false
Expected:	true
*/