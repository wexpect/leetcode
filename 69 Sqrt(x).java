Sqrt(x) Total Accepted: 3593 Total Submissions: 17175 My Submissions
Implement int sqrt(int x).

Compute and return the square root of x.




public class Solution {
    
    /*
    Solu 1: brute force, start from i = 1, check double iSquare = i * i > x
    */
    

    /*
    Solu 2: binary search
    
    must use double and long type, int would overflow
    */
        
    public int sqrt(int x) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        if(x == 0)
            return 0;
        else if( x < 0 )
            return -1;
            
        return (int)binarySearchRecursion(1, x, x);
    }
    
    public long binarySearchRecursion(long left, long right, int target){
        
        if( left > right){
            //System.out.println( left +" "+right );   
            return left-1;
        }
                
        long mid = (left + right) / 2;

        double midSquare = mid * mid;
        
        if( target == midSquare )
            return mid;
        else if( target < midSquare   ){
            //System.out.println("go left "+ left +" "+ (mid-1) );   
            return binarySearchRecursion(left, mid - 1, target);
        }
        else{
            //System.out.println("go right "+ mid+1 +" "+ right );   
            return binarySearchRecursion(mid+1, right, target);                    
        }
    }        
}