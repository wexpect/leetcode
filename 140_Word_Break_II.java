Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.

Return all such possible sentences.

For example, given
s = "catsanddog",
dict = ["cat", "cats", "and", "sand", "dog"].

A solution is ["cats and dog", "cat sand dog"].


public class Solution {
    public List<String> wordBreak(String s, Set<String> dict) {
       if( s == null || s.isEmpty() )
            return null;
        
        HashMap<String, ArrayList<String>> record = new HashMap<String, ArrayList<String>>();
        
        return canBreak(s, dict, record);
    }
    
    public ArrayList<String> canBreak(String s, Set<String> dict, HashMap<String, ArrayList<String>> record){
        if( s.isEmpty() ){
            ArrayList<String> soluList = new ArrayList<String>();
            soluList.add("");
            return soluList;
        }
        
        if( record.containsKey(s) )
            return record.get(s);
        else{
            ArrayList<String> newSoluList = new ArrayList<String>();
            
            for(String word : dict ){
                if( s.startsWith(word) ){
                    ArrayList<String> soluList = canBreak( s.substring(word.length()), dict, record );
                    
                    for(String solu : soluList){
                        if( !solu.isEmpty() )
                            newSoluList.add( word + " " + solu);
                        else
                            newSoluList.add( word );
                    }
                }
            }    
            
            record.put(s, newSoluList);
            return newSoluList;    
        }
    }
}

/*
Wrong Answer:
Input:	"a", ["a"]
Output:	["a "]
Expected:	["a"]
*/
