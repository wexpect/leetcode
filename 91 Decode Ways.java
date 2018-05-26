Decode Ways Total Accepted: 2244 Total Submissions: 14932 My Submissions
A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given an encoded message containing digits, determine the total number of ways to decode it.

For example,
Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

The number of ways decoding "12" is 2.



public class Solution {
    public int numDecodings(String str) {
        if( str == null )
            return -1;
        else if( str.isEmpty() )
            return 0;
            
        HashMap<Integer, Integer> cache = new HashMap<Integer, Integer>();            
            
        return getNum(str, 0, cache);
    }
    
    public int getNum(String str, int i, HashMap<Integer, Integer> cache){
        if( cache.containsKey(i) )
            return cache.get(i);
            
        if( i == str.length()-1 ){
            if( str.charAt(i) == '0' )
                return 0;
            else
                return 1;
        }
        
        if( i == str.length() )
            return 1;
        
        int count = 0;
        
        int value = Integer.parseInt( str.substring(i, i+1) );
        if( 1 <= value && value <= 9)
            count += getNum(str, i+1, cache);
        
        value = Integer.parseInt( str.substring(i, i+2) );
        if( 10 <= value && value <= 26)
            count += getNum(str, i+2, cache);
    
        cache.put(i, count);
        return count;
    }
}

/*
Submission Result: Wrong Answer

Input:	"10"
Output:	2
Expected:	1




Submission Result: Runtime Error

Last executed input:	"0"

*/