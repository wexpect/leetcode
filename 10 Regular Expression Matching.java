Regular Expression Matching Total Accepted: 2242 Total Submissions: 11854 My Submissions
Implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") ¡ú false
isMatch("aa","aa") ¡ú true
isMatch("aaa","aa") ¡ú false
isMatch("aa", "a*") ¡ú true
isMatch("aa", ".*") ¡ú true
isMatch("ab", ".*") ¡ú true
isMatch("aab", "c*a*b") ¡ú true





public class Solution {
    public boolean isMatch(String str1, String str2) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        if( str1 == null || str2 == null)
            return false;
            
        int i = 0;
        int j = 0;
        char preChar = ' ';
        
        while( i < str1.length() && j < str2.length() ){
            char c1 = str1.charAt(i);
            char c2 = str2.charAt(j);
            
            if( c1 == c2 || c2 == '.' ){
                i++;
                
                preChar = c2;
                j++;
            }
            else{
                if( c2 == '*' ){
                    if( c1 == preChar || preChar == '.' ){
                        i++;
                    }
                    else if( j+1 < str2.length() ){
                        if( c1 == str2.charAt(j+1) || str2.charAt(j+1) == '.' ){
                            i++;
                            
                            preChar = str2.charAt(j+1);
                            j = j+2;
                        }
                        else
                            return false;
                    }
                    else
                        return false;
                }
                else{
                    if( j+1 < str2.length() && str2.charAt(j+1) == '*' ){
                        i++;
                        
                        preChar = c2;
                        j = j+2;
                    } 
                    else
                        return false;
                }
            }
        }
        
        if( i == str1.length() ){
            if( j == str2.length() )
                return true;
            else if(  str2.charAt(j)=='*' ){
                
                int countStr1 = 0;
                for(int k = str1.length()-1; k >= 0; k--){
                    if( str1.charAt(k) == preChar )
                        countStr1++;
                    else
                        break;
                }
                
                int countStr2 = 0;
                int countStarInStr2 = 0;
                for(int k = str2.length()-1; k >= 0; k--){
                    if( str2.charAt(k) == preChar || str2.charAt(k) == '.' )
                        countStr2++;
                    else if( str2.charAt(k) == '*' )
                        countStarInStr2++;
                    else
                        break;
                }                
                
                if( countStr2 - countStarInStr2 <= countStr1 )
                    return true;
                else
                    return false;
            }
            else
        }
        else 
            return false;
    }
    
}


/*
Submission Result: Wrong Answer

Input:	"aaa", "aaaa"
Output:	true
Expected:	false



Submission Result: Wrong Answer

Input:	"aaa", "a*a"
Output:	false
Expected:	true
*/