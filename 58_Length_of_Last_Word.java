Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.

For example, 
Given s = "Hello World",
return 5.


public class Solution {
    public int lengthOfLastWord(String s) {
        if( s == null )
            return 0;
        
        int wordRightInd = -1;
        int spaceInd = -1;
        
        for( int i = s.length() - 1; i >= 0; i--){
            
            if( s.charAt(i) != ' ' ){
                if( wordRightInd == -1 ){
                    wordRightInd = i;
                }
            }
            else{
                if( wordRightInd != -1){
                    spaceInd = i;
                    break;                    
                }
            }
        }
        
        return wordRightInd - spaceInd;
        
    }
}


/*
Wrong Answer
Input:	"a "
Output:	0
Expected:	1
*/
