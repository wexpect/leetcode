ZigZag Conversion Total Accepted: 1766 Total Submissions: 8215 My Submissions
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".




public class Solution {
    public String convert(String str, int nRows) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        if( str == null || nRows <= 0)
            return null;
            
        if( str.isEmpty() )
            return "";
            
        // this special case is very important            
        if( nRows == 1)            
            return str;
            
        ArrayList<ArrayList<Character>> arrList = new ArrayList<ArrayList<Character>>();
        int row = -1;
        int col = 0;
        int d = 1;
        
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);    
        
            if( d == 1){
                row += d;
                
                addToArrList(arrList, row,c);
                
                if( row == nRows - 1)
                    d = -1;
            }
            else if( d  == -1 ){
                row +=d;
                col++;
                
                addToArrList(arrList, row,c);
                
                if( row == 0 )
                    d = 1;
            }
        }
        
        return arrListToString(arrList);
    }
    
    public void addToArrList(ArrayList<ArrayList<Character>> arrList, int row, char c){
        if( row <= arrList.size()-1 )
            arrList.get(row).add(c);
        else{
            ArrayList<Character> cList = new ArrayList<Character>();
            cList.add(c);
            arrList.add(cList);
        }
    }
    
    public String arrListToString(ArrayList<ArrayList<Character>> arrList){
        StringBuffer strBuf = new StringBuffer();
        
        for(ArrayList<Character> cList : arrList){
            for(char c : cList){
                strBuf.append( c );
            }
        }
        
        return strBuf.toString();
    }
        
}