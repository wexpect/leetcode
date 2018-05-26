Longest Substring Without Repeating Characters Total Accepted: 3545 Total Submissions: 15567 My Submissions
Given a string, find the length of the longest substring without repeating characters. For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.


public class Solution {
    
    /* Solu 1:
        brute force. for each char, scan through the chars after it and check if they already exist in the hash table
    
    */
    
    
    /* Solu 2:
        if there is a match, skip to the ind+1 where the matching chars first appear
    
    */    
    public int lengthOfLongestSubstring(String str) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        if( str == null ){
            return -1;
        }
        
        if( str.isEmpty() ){
            return 0;
        }
        
        
        HashMap<Character, Integer> cToIndMap = new HashMap<Character, Integer>();
        int maxLen = Integer.MIN_VALUE;
        int startInd = 0;
        int i = 0;
        
        while( i < str.length() ){
            char c = str.charAt(i);
            
            if( ! cToIndMap.containsKey(c) ){
                cToIndMap.put( c, i );
                i++;
            }
            else{
                int len = i - startInd;
                if( len > maxLen ){
                    maxLen = len;
                }
                
                startInd = cToIndMap.get(c) + 1;
                i = startInd;
                cToIndMap.clear();
            }
        } 
        
        int len = i - startInd;
        if( len > maxLen )
            maxLen = len;
        
        return maxLen;
    }
}

/*
Submission Result: Wrong Answer

Input:	""
Output:	-1
Expected:	0
*/
