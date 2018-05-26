/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */


// none of the following solutions can pass the OJ test
 
 public class Solution {
    public int maxPoints(Point[] points) {
       if( points == null || points.length == 0 )
            return 0;
            
        if( points.length == 1 )
            return 1;
       
       
       HashMap<Line, Integer> lineCountMap = new HashMap<Line, Integer>();
       int maxLineCount = 0;
       Line maxLine = null;
       
       for(int i = 0; i <= points.length -2; i++){
           for(int j = i+1; j <= points.length -1; j++){
               if( !samePoint( points[i], points[j] ) ){
                   Line line = makeLine( points[i], points[j] );
                   
                   if( !lineCountMap.containsKey( line ) ){
                       lineCountMap.put( line, 1);
                   }
                   else{
                       lineCountMap.put( line, lineCountMap.get(line) + 1 );
                   }
                   
                   if( lineCountMap.get(line) > maxLineCount ){
                       maxLineCount = lineCountMap.get(line);
                       maxLine = line;
                   }
               }
           }
       }
       
       // in case all points are the same
      if( maxLine == null )
            return points.length;
            
       int maxCount = 0;
       for(Point p : points ){
           if( onLine( p, maxLine ) )
            maxCount++;
       }
       
       return maxCount;
    }
    
    public Line makeLine( Point p1, Point p2 ){
        if( p1.x != p2.x ){
            double a = (double)( p2.y - p1.y ) / (double)( p2.x - p1.x );
            double b = (double)p1.y - a * (double)p1.x;
            
            return new Line( a, b );
        }
        else{
            return new Line( (double) p1.x );
        }
    }
    
    public boolean onLine( Point p, Line line){
        if( line.aIsInf ){
            return equal( line.x, (double)p.x );
        }    
        else{
            return equal( line.a * (double)p.x + line.b, (double)p.y );
        }
    }
    

        public boolean equal( double v1, double v2 ){
            double epsilon = 0.1;
            
            return Math.abs( v1 - v2 ) <= epsilon;
        }        


    public boolean samePoint( Point p1, Point p2 ){
        return ( p1.x == p2.x ) && (p1.y == p2.y );
    }
    

    public class Line{
        public double a;
        public double b;
        public boolean aIsInf = false;
        public double x;
        
        public Line( double a, double b){
            this.a = a;
            this.b = b;
            aIsInf = false;
        }
        
        public Line( double x ){
            aIsInf = true;
            this.x = x;
        }
        
        public boolean equals( Object o2 ){
            Line l2 = (Line) o2;
            
            if( aIsInf && l2.aIsInf ){
                return equalHelp( x, l2.x );
            }
            else if( !aIsInf && !l2.aIsInf ){
                return equalHelp( a, l2.a ) && equalHelp( b, l2.b );
            }
            else
                return false;
        }
        
        
        public boolean equalHelp( double v1, double v2 ){
            double epsilon = 0.1;
            
            return Math.abs( v1 - v2 ) <= epsilon;
        } 
        
        public int hashCode(){
            if( aIsInf ){
                return (int) (1000 * x);
            }
            else{
                return 31 * (int)(1000 * a) + (int)(1000 * b) ;
            }
        }
    }
}

/*
Submission Result: Runtime Error
Runtime Error Message:	Line 70: java.lang.NullPointerException
Last executed input:	[(0,0),(0,0)]
*/



 
 /*
 public class Solution {
    public int maxPoints(Point[] points) {
        if( points == null || points.length == 0 )
            return 0;
        
        if( points.length == 1 )
            return 1;
    
        int maxCount = 0;
        Line maxLine = null;
    
        for(int i = 0; i <= points.length -2; i++){
            
            int otherSamePoint = 0;
            
            for(int j = i + 1; j <= points.length -1; j++){
                if( samePoint( points[i], points[j] ) ){
                    otherSamePoint++;
                    continue;
                }
                
                
                Line line = makeLine( points[i], points[j] );
                
    
                    int count = 2 + otherSamePoint;
                    otherSamePoint = 0;
                    
                    for( int k = j + 1; k <= points.length-1; k++){
                        if( onLine( points[k], line ) ){
                            count++;
                        }
                    }
                    
                
                    if( count > maxCount ){
                        maxCount = count;
                        maxLine = line;
                    }
    
            }
            
            if( otherSamePoint > 0 ){
                if( 1 + otherSamePoint > maxCount ){
                    maxCount = 1 + otherSamePoint;
                    maxLine = null;
                }
            }
        }
        
        return maxCount;
    }
    
    public Line makeLine( Point p1, Point p2 ){
        if( p1.x != p2.x ){
            double a = (double)( p2.y - p1.y ) / (double)( p2.x - p1.x );
            double b = (double)p1.y - a * (double)p1.x;
            
            return new Line( a, b );
        }
        else{
            return new Line( (double) p1.x );
        }
    }
    
    public boolean onLine( Point p, Line line){
        if( line.aIsInf ){
            return equal( line.x, (double)p.x );
        }    
        else{
            return equal( line.a * (double)p.x + line.b, (double)p.y );
        }
    }
    

        public boolean equal( double v1, double v2 ){
            double epsilon = 0.5;
            
            return Math.abs( v1 - v2 ) <= epsilon;
        }        


    public boolean samePoint( Point p1, Point p2 ){
        return ( p1.x == p2.x ) && (p1.y == p2.y );
    }
    
    public class Line{
        public double a;
        public double b;
        public boolean aIsInf;
        public double x;
        
        public Line( double a, double b){
            this.a = a;
            this.b = b;
            aIsInf = false;
        }
        
        public Line( double x ){
            aIsInf = true;
            this.x = x;
        }
        
        
    }
}
*/

public class Solution {
    public int maxPoints(Point[] points) {
        if( points == null || points.length == 0 )
            return 0;
        
        if( points.length == 1 )
            return 1;
    
    
        HashMap<Line, Integer> lineCountMap = new HashMap<Line, Integer>();
        int maxCount = 0;
        Line maxLine = null;
    
    
    
        for(int i = 0; i <= points.length -2; i++){
            
            int otherSamePoint = 0;
            
            for(int j = i + 1; j <= points.length -1; j++){
                if( samePoint( points[i], points[j] ) ){
                    otherSamePoint++;
                    continue;
                }
                
                
                Line line = makeLine( points[i], points[j] );
                
                if( !lineCountMap.containsKey(line) ){
                    int count = 2 + otherSamePoint;
                    otherSamePoint = 0;
                    
                    for( int k = j + 1; k <= points.length-1; k++){
                        if( onLine( points[k], line ) ){
                            count++;
                        }
                    }
                    
                    lineCountMap.put( line, count );
                    
                    if( count > maxCount ){
                        maxCount = count;
                        maxLine = line;
                    }
                }
            }
            
            if( otherSamePoint > 0 ){
                if( 1 + otherSamePoint > maxCount ){
                    maxCount = 1 + otherSamePoint;
                    maxLine = null;
                }
            }
        }
        
        return maxCount;
    }
    
    public Line makeLine( Point p1, Point p2 ){
        if( p1.x != p2.x ){
            double a = (double)( p2.y - p1.y ) / (double)( p2.x - p1.x );
            double b = (double)p1.y - a * (double)p1.x;
            
            return new Line( a, b );
        }
        else{
            return new Line( (double) p1.x );
        }
    }
    
    public boolean onLine( Point p, Line line){
        if( line.aIsInf ){
            return equal( line.x, (double)p.x );
        }    
        else{
            return equal( line.a * (double)p.x + line.b, (double)p.y );
        }
    }
    

        public boolean equal( double v1, double v2 ){
            double epsilon = 0.01;
            
            return Math.abs( v1 - v2 ) <= epsilon;
        }        


    public boolean samePoint( Point p1, Point p2 ){
        return ( p1.x == p2.x ) && (p1.y == p2.y );
    }
    
    public class Line{
        public double a;
        public double b;
        public boolean aIsInf = false;
        public double x;
        
        public Line( double a, double b){
            this.a = a;
            this.b = b;
            aIsInf = false;
        }
        
        public Line( double x ){
            aIsInf = true;
            this.x = x;
        }
        
        public boolean equals( Object o2 ){
            Line l2 = (Line) o2;
            
            if( aIsInf && l2.aIsInf ){
                return equalHelp( x, l2.x );
            }
            else if( !aIsInf && !l2.aIsInf ){
                return equalHelp( a, l2.a ) && equalHelp( b, l2.b );
            }
            else
                return false;
        }
        
        
        public boolean equalHelp( double v1, double v2 ){
            double epsilon = 0.01;
            
            return Math.abs( v1 - v2 ) <= epsilon;
        } 
        
        public int hashCode(){
            if( aIsInf ){
                return (int) x;
            }
            else{
                return 31 * (int)(1000 * a) + (int)(1000*b) ;
            }
        }
    }
}

/*
Wrong Answer
Input:	[(1,1),(1,1),(2,3)]
Output:	2
Expected:	3

Wrong Answer
Input:	[(40,-23),(9,138),(429,115),(50,-17),(-3,80),(-10,33),(5,-21),(-3,80),(-6,-65),(-18,26),(-6,-65),(5,72),(0,77),(-9,86),(10,-2),(-8,85),(21,130),(18,-6),(-18,26),(-1,-15),(10,-2),(8,69),(-4,63),(0,3),(-4,40),(-7,84),(-8,7),(30,154),(16,-5),(6,90),(18,-6),(5,77),(-4,77),(7,-13),(-1,-45),(16,-5),(-9,86),(-16,11),(-7,84),(1,76),(3,77),(10,67),(1,-37),(-10,-81),(4,-11),(-20,13),(-10,77),(6,-17),(-27,2),(-10,-81),(10,-1),(-9,1),(-8,43),(2,2),(2,-21),(3,82),(8,-1),(10,-1),(-9,1),(-12,42),(16,-5),(-5,-61),(20,-7),(9,-35),(10,6),(12,106),(5,-21),(-5,82),(6,71),(-15,34),(-10,87),(-14,-12),(12,106),(-5,82),(-46,-45),(-4,63),(16,-5),(4,1),(-3,-53),(0,-17),(9,98),(-18,26),(-9,86),(2,77),(-2,-49),(1,76),(-3,-38),(-8,7),(-17,-37),(5,72),(10,-37),(-4,-57),(-3,-53),(3,74),(-3,-11),(-8,7),(1,88),(-12,42),(1,-37),(2,77),(-6,77),(5,72),(-4,-57),(-18,-33),(-12,42),(-9,86),(2,77),(-8,77),(-3,77),(9,-42),(16,41),(-29,-37),(0,-41),(-21,18),(-27,-34),(0,77),(3,74),(-7,-69),(-21,18),(27,146),(-20,13),(21,130),(-6,-65),(14,-4),(0,3),(9,-5),(6,-29),(-2,73),(-1,-15),(1,76),(-4,77),(6,-29)]
Output:	24
Expected:	25
*/


