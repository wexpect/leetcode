Word Ladder II Total Accepted: 1144 Total Submissions: 14122 My Submissions
Given two words (start and end), and a dictionary, find all shortest transformation sequence(s) from start to end, such that:

Only one letter can be changed at a time
Each intermediate word must exist in the dictionary
For example,

Given:
start = "hit"
end = "cog"
dict = ["hot","dot","dog","lot","log"]
Return
  [
    ["hit","hot","dot","dog","cog"],
    ["hit","hot","lot","log","cog"]
  ]
Note:
All words have the same length.
All words contain only lowercase alphabetic characters.




public class Solution {
    
    /*
     How to solve the case below: can not record visited node to solve it 
     
     a, b, c, d, g, h
     a, b, e, f, g, h     
     */
    
    
    /* The following idea is not right:
    In addition to the code in Word Ladder:
    use one more HashMap<String, Integer> to map the word to its distance to the source word
    use one more HashSet<String> to store all the last word that points to the target word
    only break the while loop when the distance is larger than the known shortest distance
    
    */
    
    public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
    }
}