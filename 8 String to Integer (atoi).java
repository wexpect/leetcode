String to Integer (atoi) Total Accepted: 2393 Total Submissions: 16656 My Submissions
Implement atoi to convert a string to an integer.

Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.

Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.

spoilers alert... click to show requirements for atoi.

Requirements for atoi:
The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.

The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.

If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.

If no valid conversion could be performed, a zero value is returned. If the correct value is out of the range of representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.



public class Solution {
        
    /* Solu 2: to check overflow, can also define num as long type. However, long type may also overflow:
        
        long num = 0;
        
        for (; index < len; index++) {
            if (str.charAt(index) < '0' || str.charAt(index) > '9')
                break;
            
            num = num* 10 + (str.charAt(index) - '0');
            
            if( (sign == 1 && num > Integer.MAX_VALUE ) || (sign == -1 && -num < Integer.MIN_VALUE ) )
                break;
        }   
        if (num*sign > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        
        if (num*sign < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
            
        return (int)num*sign;
        
    */
    
    // Solu 1:
    public int atoi(String str) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        if( str == null )
            return 0;
            
        str = str.trim();
        
        if( str.isEmpty() )
            return 0;
        
        int sign = 1;    
        int startInd = 0;
        
        if( str.charAt(0) == '+' ){
            sign = 1;
            startInd = 1;
        }
        else if( str.charAt(0) == '-' ){
            sign = -1;
            startInd = 1;
        }
        
        int num = 0;
        boolean hasValidNum = false;
        for(int i = startInd; i < str.length(); i++){
            char c = str.charAt(i);
            
            if( '0' <= c && c <= '9'){ // Character.isDigit( c )
                hasValidNum = true;
                
                int value = c - '0'; // Character.digit( c, 10 )
                
                if( num <= (Integer.MAX_VALUE - value)/10 ){ 
                    num = 10 * num + value;
                }
                else{  
                    if( sign == 1)
                        return Integer.MAX_VALUE;  // overflow
                    else if( sign == -1 )
                        return Integer.MIN_VALUE;  // overflow, or the string value = Integer.MIN_VALUE
                }
            }                   
            else{
                if( hasValidNum )
                    return sign * num;
                else
                    return 0;
            }
        }
        
        return sign * num;
    }
}



/*
Submission Result: Runtime Error

Last executed input:	""




Submission Result: Wrong Answer

Input:	"abc"
Output:	2147483647
Expected:	0




Submission Result: Wrong Answer

Input:	"  -0012a42"
Output:	0
Expected:	-12



Submission Result: Wrong Answer

Input:	"2147483648"
Output:	-2147483648
Expected:	2147483647
*/
