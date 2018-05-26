Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 2,3,6,7 and target 7, 
A solution set is: 
[7] 
[2, 2, 3] 


public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // List<List<Integer>> allLists = new ArrayList<ArrayList<Integer>>(); // not work
        // List<List<Integer>> allLists = new ArrayList<List<Integer>>(); // not work
        List<List<Integer>> allLists = new ArrayList<List<Integer>>();
        
        if( candidates == null || candidates.length == 0 )
            return allLists;

        if( target == 0 ){
            allLists.add( new ArrayList<Integer>() );
            return allLists;
        }
        
        if( target < 0 )
            return allLists;
        
        
        for(int i = 0; i < candidates.length; i++){
            int val = candidates[i];
            
            List<List<Integer>> partialLists = combinationSum(candidates, target - val );
            
            for(List<Integer> list : partialLists){
                if( list.isEmpty() || (val >= list.get(list.size()-1) ) ){
                    list.add( val );
                    
                    allLists.add( list );
                }
            }
        }
        
        return allLists;
    }
}


/*
Compile Error
Line 7: error: incompatible types: ArrayList<ArrayList<Integer>> cannot be converted to List<List<Integer>>
List<List<Integer>> allLists = new ArrayList<ArrayList<Integer>>();

*/
