Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

For example, 
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.


public class Solution {
    public int trap(int[] A) {
        if( A == null || A.length <= 2 )
            return 0;
        
        int highestInd = getHighest(A);
        int highestVal = A[highestInd];
        
        int boundVal = A[0];
        int sum = 0;
        
        for(int i = 1; i < highestInd; i++){
            sum += trapWater(boundVal, A[i], highestVal);
            
            if( A[i] > boundVal ){
                boundVal = A[i];
            }
        }
        
        boundVal = A[A.length-1];
        for(int i = A.length-2; i > highestInd; i--){
            sum += trapWater(highestVal, A[i], boundVal);
            
            if( A[i] > boundVal ){
                boundVal = A[i];
            }
        }
        
        return sum;
    }
    
    public int getHighest(int[] arr){
        int maxInd = Integer.MIN_VALUE;
        int maxVal = Integer.MIN_VALUE;
        
        for(int i = 0; i < arr.length; i++){
            if( arr[i] > maxVal ){
                maxVal = arr[i];
                maxInd = i;
            }
        }
        
        return maxInd;
    }
    
    public int trapWater(int val1, int val2, int val3){
        if( val2 < val1 && val2 < val3){
            return Math.min(val1,val3) - val2;
        }
        else
            return 0;
    }
}
