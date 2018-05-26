Valid Number Total Accepted: 1409 Total Submissions: 14631 My Submissions
Validate if a given string is numeric.

Some examples:
"0" => true
" 0.1 " => true
"abc" => false
"1 a" => false
"2e10" => true
Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one.




public class Solution {
    
    // Solu 1: recursion
    
    public boolean isNumber(String str) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
               
        if( str == null)
            return false;
        
        str = str.trim();
        if( str.isEmpty() )
            return false;        
            
        return isNumHelper(str, 0);
    }
    
    public boolean isNumHelper(String str, int countE){        
        if( countE > 1)
            return false;
            
        if( str.isEmpty() )
            return false;
            
//        if( str.charAt(0) == 'e' || str.charAt(0) == 'E' )
 //           return false;
            
        int startInd = 0;
        if( str.charAt(0) == '+' || str.charAt(0) == '-' ){
            startInd = 1;
            if( str.substring(startInd).isEmpty() )
                return false;
        }
        
        int countDot = 0;
        int i = startInd;
        
        while( i < str.length() ){
            char c = str.charAt(i);
            
            if( '0' <= c && c <= '9' )
                i++;
            else if( c == '.' ){
                countDot++;
                
                if( countE > 0)
                    return false;
                
                if( countDot == 1){
                    if( i+1 < str.length() ){
                        char cNext = str.charAt(i+1);
                        
                        if( '0' <= cNext && cNext <= '9' )                            
                            i += 2;
                        else if( cNext == 'e' || cNext == 'E'){
                            if( i-1 >= 0 && '0' <= str.charAt(i-1) && str.charAt(i-1) <= '9' )
                                return isNumHelper( str.substring(i+2), countE+1);
                            else
                                return false;
                        }
                        else
                            return false;
                    }
                    else{ // i + 1 == str.length()
                        if( i-1 >= 0 && '0' <= str.charAt(i-1) && str.charAt(i-1) <= '9' )
                            return true;
                        else
                            return false;
                    }
                }
                else
                    return false;
            }
            else if( c == 'e' || c == 'E' ){
                if( i == startInd )
                    return false;
                else
                    return isNumHelper( str.substring(i+1), countE+1);
            }
            else
                return false;
        }
        
        return true;
    }
    
}


/*
Submission Result: Wrong Answer

Input:	"e9"
Output:	true
Expected:	false



Submission Result: Wrong Answer

Input:	".1"
Output:	false
Expected:	true



Input:	"3."
Output:	false
Expected:	true



Submission Result: Wrong Answer

Input:	"."
Output:	true
Expected:	false



Submission Result: Wrong Answer

Input:	".e1"
Output:	true
Expected:	false




Submission Result: Wrong Answer

Input:	"1e."
Output:	true
Expected:	false



Submission Result: Wrong Answer

Input:	"46.e3"
Output:	false
Expected:	true




Submission Result: Wrong Answer

Input:	"+E3"
Output:	true
Expected:	false




Submission Result: Wrong Answer

Input:	"6e6.5"
Output:	true
Expected:	false
*/