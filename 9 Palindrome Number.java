Palindrome Number Total Accepted: 3217 Total Submissions: 11203 My Submissions
Determine whether an integer is a palindrome. Do this without extra space.

click to show spoilers.

Some hints:
Could negative integers be palindromes? (ie, -1)

If you are thinking of converting the integer to string, note the restriction of using extra space.

You could also try reversing an integer. However, if you have solved the problem "Reverse Integer", you know that the reversed integer might overflow. How would you handle such case?

There is a more generic way of solving this problem.




public class Solution {    
    
    // Solu 1: reverse integer to long type, and compare
    
    // Solu 2    
    public boolean isPalindrome(int n) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
     
        if( n == 0 )   
            return true;
            
        if( n < 0 ){
           return false;    
           
            /*
            if( n == Integer.MIN_VALUE)
                return false;
            else
                n = -n;
            */    
        }
            
  
        int numDigit = countDigit( n );
        
        int vL = 0;
        int div = (int) Math.pow(10, numDigit-1);
        
        int vR = 0;
        
        for(int k = 1; k <= (numDigit/2); k++){
            vL = n / div;
            vR = n % 10;
            
            if( vL != vR )
                return false;
            
            n = ( n % div )/ 10;
            div = div / 100;
        }
        
        return true;
    }
    
    public int countDigit(int n){
        int count = 0;
        
        while( n > 0 ){
            count++;
            n /= 10;
        }
        
        return count;
    }
}

/*
Submission Result: Wrong Answer

Input:	-2147483648
Output:	true
Expected:	false


Submission Result: Wrong Answer

Input:	-1
Output:	true
Expected:	false


Submission Result: Wrong Answer

Input:	-2147447412
Output:	true
Expected:	false
*/