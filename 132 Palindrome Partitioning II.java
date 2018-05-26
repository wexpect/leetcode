Palindrome Partitioning II Total Accepted: 2461 Total Submissions: 14699 My Submissions
Given a string s, partition s such that every substring of the partition is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of s.

For example, given s = "aab",
Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.


public class Solution {
    
    /*
    Solu 1: brute force
    use the code in Palindrome Partitioning, then find the list with the min size
    
    // Solu 2:
    use the code in Palindrome Partitioning, each time before return the final ArrayList<ArrayList<String>>, only keep the ArrayList<String> with the min size.
    
    */
    public int minCut(String s) {
        
    }
}