Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 10,1,2,7,6,1,5 and target 8, 
A solution set is: 
[1, 7] 
[1, 2, 5] 
[2, 6] 
[1, 1, 6] 



public class Solution {
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        if( num == null || target <= 0)
            return null;
        
        
        Arrays.sort(num); // sort does not return new arr
        
        HashSet<MyObj> objSet = new HashSet<MyObj>();
        objSet.add( new MyObj(0, new ArrayList<Integer>()) );
        
        for(int ele : num){
            HashSet<MyObj> tmpSet = new HashSet<MyObj>();
                
            for( MyObj obj : objSet){
                if( obj.sum + ele <= target){
                    ArrayList<Integer> newList = new ArrayList<Integer>();
                    newList.addAll( obj.list );
                    newList.add( ele );
                    
                    MyObj newObj = new MyObj( obj.sum + ele, newList);
                    
                    tmpSet.add( newObj );
                }
            } 
            
            objSet.addAll( tmpSet );
        }
        
        List<List<Integer>> returnList = new ArrayList<List<Integer>>();
        
        for(MyObj o : objSet ){
            if( o.sum == target){
                returnList.add( o.list );
            }
        }
        
        return returnList;
    }
    
    public class MyObj{
        public int sum = 0;
        public ArrayList<Integer> list = null;
        
        public MyObj(int sum, ArrayList<Integer> list){
            this.sum = sum;
            this.list = list;
        }
        
        
        // must have the following two methods, to use HashSet
        
        @Override
        public boolean equals(Object obj){
            MyObj o = (MyObj) obj;
            
            return list.equals( o.list );
        }
        
        @Override
        public int hashCode(){
            return list.hashCode();
        }
        
    }
}

/*
Wrong Answer
Input:	[1,1], 1
Output:	[[1],[1]]
Expected:	[[1]]
*/
