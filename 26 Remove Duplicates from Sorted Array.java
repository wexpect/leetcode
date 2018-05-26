Remove Duplicates from Sorted Array Total Accepted: 5281 Total Submissions: 15974 My Submissions
Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

For example,
Given input array A = [1,1,2],

Your function should return length = 2, and A is now [1,2].




public class Solution {
    public int removeDuplicates(int[] arr) {
        if( arr == null)
            return -1;
        
        if( arr.length <= 1)
            return arr.length;
            
        int k = 1;
        int curV = arr[0];
        
        for(int i = 1; i < arr.length; i++){
            if( arr[i] != curV){
                arr[k] = arr[i];
                k++;
                curV = arr[i];
            }
        }
        
        return k;
    }
    
}


