Valid Palindrome Total Accepted: 3172 Total Submissions: 15169 My Submissions
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.

Note:
Have you consider that the string might be empty? This is a good question to ask during an interview.

For the purpose of this problem, we define empty string as valid palindrome.




public class Solution {
    
    // Solu 1: brute force. Using 2 StringBuffers, store only the alphanumeric characters in the string in normal order and reverse order, and then convert them bckk to string and compare
    
    
    // Solu 2:
    public boolean isPalindrome(String str) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if( str == null)
            return false;
            
        str = str.trim().toLowerCase();
        
        int i = 0;
        int j = str.length()-1;
        
        while( i < j ){
            char c1 = str.charAt(i);
            char c2 = str.charAt(j);
            
            boolean c1IsAlpNum = isAlpNum(c1);
            boolean c2IsAlpNum = isAlpNum(c2);
            
            if( c1IsAlpNum && c2IsAlpNum){
                if( c1 == c2){
                    i++;
                    j--;
                }
                else
                    return false;
            }
            else if( c1IsAlpNum )        
                j--;
            else if( c2IsAlpNum )
                i++;
            else{
                i++;
                j--;
            }
        }
        
        return true;
    }
    
    public boolean isAlpNum(char c){
        return ('a' <= c && c <= 'z') || ('0' <= c && c <= '9') ;
    }
}


/*
Submission Result: Wrong Answer

Input:	"1a2"
Output:	true
Expected:	false

*/