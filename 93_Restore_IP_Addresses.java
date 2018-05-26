Given a string containing only digits, restore it by returning all possible valid IP address combinations.

For example:
Given "25525511135",

return ["255.255.11.135", "255.255.111.35"]. (Order (of elements in the returned array/list) does not matter)



public class Solution {
    public List<String> restoreIpAddresses(String s) {
        if( s == null )
            return null;
        
        return restore( s, 4);
    }
    
    public List<String> restore(String str, int numSec){
        int strLen = str.length();
        
        if( strLen < 1 * numSec || strLen > 3 * numSec)
            return new ArrayList<String>();
        
        if( numSec == 1){
            ArrayList<String> returnList = new ArrayList<String>();
            
            if( isValid( str ) ){
                returnList.add( str );
            }
            
            return returnList;
        }
        
        List<String> strList = new ArrayList<String>();
        List<String> tmpList = new ArrayList<String>();
        String tmpIP = null;
        
        for(int i = 1; i <= Math.min(strLen, 3); i++){
            tmpIP = str.substring(0, i);
            
            if( isValid(tmpIP) ) {
                tmpList = restore( str.substring(i), numSec - 1);
                
                if( ! tmpList.isEmpty() ){
                    for(String s : tmpList){
                        strList.add( tmpIP + "." + s);
                    }
                }
            }
        }
        
        return strList;
    }
    
    public boolean isValid(String str){
        if( str.startsWith("0") ){
            if( str.length() == 1)
                return true;
            else
                return false;
        }
        else{
            int val = Integer.parseInt( str );
            if( (val > 0) && ( val <= 255) ) // remember to use () && () format, do not ignore ()
                return true;
            else
                return false;
        }
    }
}

/*
Input:	""
Output:	null
Expected:	[]

Input:	"010010"
Output:	["0.1.0.010","0.1.00.10","0.1.001.0","0.10.0.10","0.10.01.0","0.100.1.0","01.0.0.10","01.0.01.0","01.00.1.0","010.0.1.0"]
Expected:	["0.10.0.10","0.100.1.0"]

Input:	"010010"
Output:	["0.1.0.010","0.10.0.10","0.100.1.0"]
Expected:	["0.10.0.10","0.100.1.0"]
*/
