Combinations Total Accepted: 2931 Total Submissions: 10098 My Submissions
Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

For example,
If n = 4 and k = 2, a solution is:

[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]




public class Solution {
    
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        if( n < 0 || k < 0 || n < k)
            return null;
            
        ArrayList< ArrayList<Integer> > combArrList = combine( n, k, n);
        
        int i = 0;
        while( i < combArrList.size() ){
            if( combArrList.get(i).size() != k ){
                combArrList.remove(i);
            }
            else
                i++;
        }
        
        return combArrList;
    }
    
    public ArrayList<ArrayList<Integer>> combine(int n, int k, int j) {

        if( j == 0 ){
            ArrayList<Integer> combList = new ArrayList<Integer>();
            ArrayList< ArrayList<Integer> > combArrList = new ArrayList< ArrayList<Integer> >();
            combArrList.add( combList );
            
            return combArrList;
        }
        
        ArrayList< ArrayList<Integer> > combArrList = combine( n, k, j-1);
        int currentSize = combArrList.size(); // must calculate the size of subsetsList here first, because subsetList will keep growing; if not, error called "Concurrent Modification" will happen
        
        for( int i = 0; i < currentSize; i++){
            ArrayList<Integer> combList = combArrList.get(i);
            
            if( combList.size() < k &&  (combList.size() + n-j+1 >= k ) ){
                ArrayList<Integer> newCombList = new ArrayList<Integer>();
                newCombList.addAll( combList );   // addAll is important
                newCombList.add( j );
                combArrList.add( newCombList );                        
            }
        }
        return combArrList;        
    }        
}