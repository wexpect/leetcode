Given a non-negative number represented as an array of digits, plus one to the number.

The digits are stored such that the most significant digit is at the head of the list.


public class Solution {
    public int[] plusOne(int[] digits) {
        if( digits == null )
            return null;
        
        
        int in = 1;
        int sum = 0;
        
        int len = digits.length;
        
        for(int i = len - 1; i >= 0; i--){
            if( in == 0 )
                break;
            
            sum = digits[i] + in;
            
            in = sum / 10;
	    digits[i] = sum % 10;
        }
        
        if( in == 0 )
            return digits;
        else{
            int[] newArr = new int[len+1];
            newArr[0] = in;
            
            for( int i = 1; i <= len; i++){
                newArr[i] = digits[i-1];
            }
            
            return newArr;
        }
     
    }
}
