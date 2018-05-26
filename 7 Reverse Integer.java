Reverse Integer Total Accepted: 4366 Total Submissions: 10742 My Submissions
Reverse digits of an integer.

Example1: x = 123, return 321
Example2: x = -123, return -321

click to show spoilers.

Have you thought about this?
Here are some good questions to ask before coding. Bonus points for you if you have already thought through this!

If the integer's last digit is 0, what should the output be? ie, cases such as 10, 100.

Did you notice that the reversed integer might overflow? Assume the input is a 32-bit integer, then the reverse of 1000000003 overflows. How should you handle such cases?

Throw an exception? Good, but what if throwing an exception is not an option? You would then have to re-design the function (ie, add an extra parameter).




public class Solution {
    
    //Solu 3: best solution. check if overflow happens.
    public int reverse(int n){
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        int sign;
        
        if( n == 0){
            return 0;
        }
        else if(n > 0){          
            sign = 1;
        }
        else{
            n = -n;
            sign = -1;
        }
        
        
        int rN = 0;
        while(n > 0){
            int v = n % 10;
            
            if( rN <= ( Integer.MAX_VALUE - v )/10  ){
                rN = 10 * rN + v;                
                n = n / 10;                
            }
            else{
                if( sign == 1)
                    return Integer.MAX_VALUE;  // overflow
                else if( sign == -1 )
                    return Integer.MIN_VALUE;  // overflow, or the string value = Integer.MIN_VALUE
            }
        }
        
        return sign * rN;
    }
    
    
    /*    
    //Solu 1: check if overflow happens, using StringBuffer
    public int reverse(int n){
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        int sign;
        
        if( n == 0){
            return 0;
        }
        else if(n > 0){          
            sign = 1;
        }
        else{
            n = -n;
            sign = -1;
        }
        
        
        StringBuffer strBuf = new StringBuffer();
        boolean zeroIsValid = false;
        
        int rN = 0;
        while(n > 0){
            int v = n % 10;
            rN = 10 * rN + v;
            n = n / 10;
            
            if( v != 0 ){
                strBuf.append(v);
                
                zeroIsValid = true;
            }
            else{
                if( zeroIsValid )
                    strBuf.append(v);
            }
        }
        
        // check if overflow happens
        String rNStr = Integer.toString( rN );
        String rNExpectedStr = strBuf.toString();
        if( rNStr.equals( rNExpectedStr ) ){
            return sign * rN;
        }
        else
            return Integer.MAX_VALUE;
    }
    */


    /*
    // Solu 2: use long type to hold the reversed number, to avoid overflow
    // int: integer, 4 bytes
    // long: long integer, 8 bytes
   public long reverse(int n){
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        int sign;
        
        if( n == 0){
            return 0;
        }
        else if(n > 0){          
            sign = 1;
        }
        else{
            n = -n;
            sign = -1;
        }
        
        long rN = 0;
        while(n > 0){
            rN = 10 * rN + n % 10;
            n = n / 10;
        }
        
        return sign * rN;
    }    
    */
        
}
        