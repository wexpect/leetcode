Two Sum Total Accepted: 5391 Total Submissions: 24635 My Submissions
Given an array of integers, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

You may assume that each input would have exactly one solution.

Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2


public class Solution {
    public int[] twoSum(int[] arr, int target) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        if( arr == null || arr.length <= 1 ){
            return null;
        }
        
        HashMap<Integer, ArrayList<Integer>> hashMap = makeHM(arr);
        
        for(int i = 0; i < arr.length; i++){
            int num1 = arr[i];
            int num2 = target - num1;
            
            if(num2 != num1){
                if( hashMap.containsKey(num2) ){
                    int[] result = new int[2];
                    result[0] = i + 1;
                    result[1] = hashMap.get(num2).get(0) + 1;
                    return result;
                }
            }
            else{
                if( hashMap.get(num2).size() >= 2 ){
                    int[] result = new int[2];
                    result[0] = i + 1;
                    result[1] = hashMap.get(num2).get(1) + 1;
                    return result;
                    
                }
            }
        }
        
        return null;
    }
    
    public HashMap<Integer, ArrayList<Integer>> makeHM(int[] arr){
        HashMap<Integer, ArrayList<Integer>> hashMap = new HashMap<Integer, ArrayList<Integer>>();
        
        for(int i = 0; i < arr.length; i++){
            int num = arr[i];
            
            if(hashMap.containsKey(num)){
                hashMap.get( num ).add(i);
            }
            else{
                ArrayList<Integer> list = new ArrayList<Integer>();
                list.add(i);
                hashMap.put(num, list);
                
            }
        }
        return hashMap;
    }
    
}

/*
Submission Result: Wrong Answer

Input:	[2,1,9,4,4,56,90,3], 8
Output:	4, 4
Expected:	4, 5
*/            