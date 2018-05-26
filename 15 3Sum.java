3Sum Total Accepted: 3400 Total Submissions: 20837 My Submissions
Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:
Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ¡Ü b ¡Ü c)
The solution set must not contain duplicate triplets.
    For example, given array S = {-1 0 1 2 -1 -4},

    A solution set is:
    (-1, 0, 1)
    (-1, -1, 2)


public class Solution {
    
    /*
    // Solu 1: brute force
    1) sort the arr
    2) use three for loops, check each triplet, may add to HashSet
    
    3) the HashSet, need to define hashCode() and equals(Object obj)
    */    
    
    /*
    // Solu 2: 
    1) sort the array
    2) for each a = arr[i], check if the rest of the arr has b + c = -a (2sum problem), return hashSet<Point> 
    3) For the 2sum problem, using hashTable to store all element. for each b, check if c is in the hashTable. use hashSet to record the valid     
       Points so redundant Points only record oce, return the hashSet
    */
    
    public ArrayList<ArrayList<Integer>> threeSum(int[] arr) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        if( arr == null )
            return null;
            
        if( arr.length <= 2 )
            return new ArrayList<ArrayList<Integer>>();
        
        Arrays.sort( arr );
        
        ArrayList<ArrayList<Integer>> threeSumArrList = new ArrayList<ArrayList<Integer>>();
        
        HashSet<Integer> usedIntSet = new HashSet<Integer>();
        
        for(int i = 0; i <= arr.length-3; i++){
            if( ! usedIntSet.contains(arr[i]) ){
                usedIntSet.add( arr[i] ); // this is very important
                
                HashSet<Point> twoSumSet = getTwoSumSet(arr, i+1, -arr[i]);
                
                for(Point point : twoSumSet){
                    ArrayList<Integer> triplet = new ArrayList<Integer>();
                    triplet.add( arr[i] );
                    triplet.add( point.b );
                    triplet.add( point.c );
                    
                    threeSumArrList.add(triplet);
                }
            }
        }
        
        return threeSumArrList;
    }
    
    public HashSet<Point> getTwoSumSet(int[] arr, int ind, int target){
        HashMap<Integer, Integer> intCountMap = makeHM(arr, ind);
        
        HashSet<Point> twoSumSet = new HashSet<Point>();
        
        for(int i = ind; i < arr.length; i++){
            int num1 = arr[i];
            int num2 = target - num1;
            
            if(num2 != num1){
                if( intCountMap.containsKey(num2) ){
                    Point point = new Point( num1, num2);
                    twoSumSet.add( point );
                }
            }
            else{
                if( intCountMap.get(num2) > 1 ){
                    Point point = new Point( num1, num2);
                    twoSumSet.add( point );
                }
            }
        }
        
        return twoSumSet;        
    }
    
   public HashMap<Integer, Integer> makeHM(int[] arr, int ind){
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        
        for(int i = ind; i < arr.length; i++){
            int num = arr[i];
            
            if(hashMap.containsKey(num)){
                hashMap.put( num, hashMap.get( num )+1 );
            }
            else{
                hashMap.put(num, 1);
                
            }
        }
        return hashMap;
    }
    
    public class Point{
        public int b;
        public int c;
        
        public Point(int x, int y){
            b = Math.min(x, y);
            c = Math.max(x,y);
        }
        
        public int hashCode(){
            return 23*b + c;
        }
        
        public boolean equals(Object obj){
            Point p2 = (Point)obj;
            if( b == p2.b && c == p2.c)
                return true;
            else
                return false;
        }
    }
    
}

/*
Submission Result: Wrong Answer

Input:	[]
Output:	null
Expected:	[]



Submission Result: Wrong Answer

Input:	[0]
Output:	null
Expected:	[]
*/