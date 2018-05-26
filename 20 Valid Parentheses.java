Valid Parentheses Total Accepted: 2826 Total Submissions: 10304 My Submissions
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.




public class Solution {
    public boolean isValid(String str) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if( str == null)
            return false;
            
        if( str.isEmpty())
            return true;

        Stack<Character> stack = new Stack<Character>();

        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);

            if( c == '(' || c == '[' || c == '{')
                stack.push(c);
            else{
                if( stack.isEmpty() )
                    return false;
                    
                char cPre = stack.pop();
                
                if( ! isMatch(cPre, c) )
                    return false;
            }
        }
        
        if( stack.isEmpty() )
            return true;
        else
            return false;
    }
    
    public boolean isMatch(Character c1, Character c2){
        if( ( c1 == '(' && c2 == ')' ) || ( c1 == '[' && c2 == ']' ) || (c1 == '{' && c2 == '}' ) )
            return true;
        else
            return false;
    }
    
}


/*
Submission Result: Wrong Answer

Input:	"([])"
Output:	false
Expected:	true

*/