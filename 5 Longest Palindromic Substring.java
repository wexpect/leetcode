Longest Palindromic Substring Total Accepted: 2941 Total Submissions: 13834 My Submissions
Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.


public class Solution {
    
    // Solu 1: brute force
    
    public String longestPalindrome(String str) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        if( str == null || str.isEmpty() )
            return null;
            
        for(int l = str.length(); l >= 1; l--){
            for(int i = 0; i + l - 1 <= str.length() - 1; i++){
                if( isPali(str, i, i + l - 1) )
                    return str.substring(i, i + l);
            }
        }
        
        return null;
    }
    
    public boolean isPali(String str, int left, int right){
        int i = left;
        int j = right;
        while( i <= (left+right)/2 ){
            if(str.charAt(i) == str.charAt(j) ){
                i++;
                j--;
            }
            else
                return false;
        }
        
        return true;
    }
}