Pow(x, n) Total Accepted: 3448 Total Submissions: 13850 My Submissions
Implement pow(x, n).



public class Solution {
    
    // Solu 1: brute force, for loop
    
    
    // Solu 2:
    public double pow(double x, int n) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int sign = 1;
        if( n < 0){
            sign = -1;
            n = -n;
        }
        
        double v = 0;
        
        if( n == 0 )
            v = 1;
        else if( n == 1)
            v = x;
        else{            
            double tmp = pow(x, n/2);
            if( n % 2 == 0)
                v = tmp * tmp;
            else
                v = tmp * tmp * x;
        }
        
        if(sign == 1)
            return v;
        else
            return 1/v;
    }
}

/*
Submission Result: Wrong Answer

Input:	8.95371, -1
Output:	8.95371
Expected:	0.11169


*/