Letter Combinations of a Phone Number Total Accepted: 3057 Total Submissions: 12553 My Submissions
Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.



Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Note:
Although the above answer is in lexicographical order, your answer could be in any order you want.




public class Solution {
    public ArrayList<String> letterCombinations(String digits) {
        if( digits == null)
            return null;
            
        for(int i = 0; i < digits.length(); i++){
            char c = digits.charAt(i);
            
            if(  !('0' <= c && c <= '9' ) )
                return null;
        }            
            
        HashMap<Character, String> map = makeMap();
        
        return digToStr(digits, digits.length()-1, map);
    }
    
    public ArrayList<String> digToStr(String str, int ind, HashMap<Character, String> map){
        if( ind == -1){
            ArrayList<String> newArrList = new ArrayList<String>();
            newArrList.add("");
            return newArrList;
        }
        
        
        ArrayList<String> oldArrList = digToStr(str, ind-1, map);
        ArrayList<String> newArrList = new ArrayList<String>();
        String letterOptions = map.get( str.charAt(ind) );
        
        for(String letterStr : oldArrList){
            for(int i = 0; i < letterOptions.length(); i++){
                newArrList.add( letterStr + letterOptions.charAt(i) );
            }
        }
        
        return newArrList;
    }
    
    public HashMap<Character, String> makeMap(){
        HashMap<Character, String> map = new HashMap<Character, String>();
        
        map.put('0', "_");
        map.put('1', "%");
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        
        return map;
    }
}