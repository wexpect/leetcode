 Total Accepted: 3835 Total Submissions: 11620 My Submissions
Given an array and a value, remove all instances of that value in place and return the new length.

The order of elements can be changed. It doesn't matter what you leave beyond the new length.



public class Solution {
    public int removeElement(int[] arr, int elem) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if( arr == null)
            return -1;
            
        if( arr.length == 0 )
            return 0;            
            
        int i = 0;
        int j = arr.length - 1; 
        
        while(i < j){
            
            if( arr[i] == elem ){
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                
                // i++; do not change i here, because arr[i] might == elem
                j--; 
            }
            else
                i++;
        }
        
        for(int k = arr.length-1; k >= 0; k--){
            if( arr[k] != elem)
                return k + 1;
        }
        
        return 0;
    }
}


/*
Submission Result: Runtime Error

Last executed input:	[], 0

*/