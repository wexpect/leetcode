Permutations II Total Accepted: 2345 Total Submissions: 9244 My Submissions
Given a collection of numbers that might contain duplicates, return all possible unique permutations.

For example,
[1,1,2] have the following unique permutations:
[1,1,2], [1,2,1], and [2,1,1].


public class Solution {
    // Solu 0: not good
    // resursion
    // use HashSet<Perm> to store all Perm object made from n-1 elements, and return to the n elements level
    // the Perm object contains a arrList<Integer> to store the permutation, also need to define hashCode() and equals()
    // eventually, convert the HashSet<Perm> for n elements to ArrayList<ArrayList<Integer>>
    
    // Solu 1: for each arr[n] to insert into pisition i of arrList<Integer> obtained from arr[n-1]
    // if arr[n] = the element at position i, then do not insert it, meaning we do not need this newArrList<Integer>
    
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
    }
}