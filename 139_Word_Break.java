Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

For example, given
s = "leetcode",
dict = ["leet", "code"].

Return true because "leetcode" can be segmented as "leet code".



public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        if( s == null || s.isEmpty() )
            return false;
        
        HashMap<String, Boolean> record = new HashMap<String, Boolean>();
        
        return canBreak(s, dict, record);
    }
    
    public boolean canBreak(String s, Set<String> dict, HashMap<String, Boolean> record){
        if( s.isEmpty() )
            return true;
        
        if( record.containsKey(s) )
            return record.get(s);
        else{
            for(String word : dict ){
                if( s.startsWith(word) ){
                    if( canBreak( s.substring(word.length()), dict, record ) ){
                        record.put(s, true);
                        return true;
                    }
                }
            }    
                
            record.put(s, false);
            return false;    
        }
    }
}
/*
If code without Dynamic Programming, get the following errors:

Time Limit Exceeded
Last executed input:	"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa.....
*/



/*
public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        if( s == null || s.length() == 0 )
            return false;
            
        return canBreak(s, 0, s.length()-1, dict);
    }
    
    public boolean canBreak(String str, int left, int right, Set<String> dict){
        if( left > right )
            return true;
        
        for(int i = left + 1; i <= right + 1; i++){
            String word = str.substring(left, i);
            
            if( dict.contains(word) ){
                if( canBreak(str, i, right, dict) ){
                    return true;
                }
            }
        }
        
        return false;
    }
    
}
*/


/*
Time Limit Exceeded
Last executed input:	"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa.....
*/
