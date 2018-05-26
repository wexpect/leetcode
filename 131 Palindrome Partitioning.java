Palindrome Partitioning Total Accepted: 2749 Total Submissions: 11630 My Submissions
Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

For example, given s = "aab",
Return

  [
    ["aa","b"],
    ["a","a","b"]
  ]




public class Solution {
    public ArrayList<ArrayList<String>> partition(String str) {
        if( str == null || str.isEmpty() )
            return null;
            
        HashMap<Integer, ArrayList<ArrayList<String>>> cache = new HashMap<Integer, ArrayList<ArrayList<String>>>();
        return part(str, 0, cache);
    }
    
    public ArrayList<ArrayList<String>> part(String str, int startInd, HashMap<Integer, ArrayList<ArrayList<String>>> cache){
        if( cache.containsKey(startInd) )
            return cache.get(startInd);
        
        if( startInd == str.length() ){
            
            // must initialize both list and arrList, and must add list to arrList
            ArrayList<String> list = new ArrayList<String>();
            ArrayList<ArrayList<String>> arrList = new ArrayList<ArrayList<String>>();
            arrList.add(list);
            return arrList;
        }
        
        ArrayList<ArrayList<String>> arrList = new ArrayList<ArrayList<String>>();
        
        for(int i = startInd; i < str.length(); i++){
            String s = str.substring(startInd, i+1);
            if( isPali(s) ){
                ArrayList<ArrayList<String>> oldArrList = part(str, i+1, cache);
                
                for(ArrayList<String> oldList : oldArrList){
                    ArrayList<String> list = new ArrayList<String>();
                    list.add(s);
                    list.addAll(oldList);
                    arrList.add(list);
                }
            }
        }
        
        cache.put(startInd, arrList);
        
        return arrList;
    }
    
    public boolean isPali(String str){
        int i = 0;
        int j = str.length()-1;
        
        while(i < j){
            if( str.charAt(i) != str.charAt(j) )
                return false;
                
            i++;
            j--;
        }
        
        return true;
    }
}