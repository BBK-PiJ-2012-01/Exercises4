class Point { 
    int x;
    int y; 
}
// This method increments the int by 1 and // moves the point to the right
void increment(Point point, int n) {
    n = n + 1;                // Local copy of n is incremented.  Not myInt!
    
    point.x = point.x + 1;    // point is boxed, so passed by reference to increment
                              // meaning this increments myPoint.x
    
    point = null;             // point is just a reference to myPoint.  Setting
                              // this to null doesn't affect myPoint.
                              // NB. if all references to myPoint are removed,
                              // the garbage collector might delete the
                              // myPoint boxed object.
    println " At the end of the method...";
    println " The integer is " + n; 
    println " The point is " + point;
}
// Program execution starts here
Point myPoint = new Point();
point.x = 0;
point.y = 0;
int myInt = 0;
println "The integer is now " + myInt;
println "The point is now " + myPoint.x + "," + myPoint.y; 
println "Calling method increment(Point, int)..." 
increment(myPoint, myInt);
println "The integer is now " + myInt;
println "The point is now " + myPoint.x + "," + myPoint.y;


/*
The output is:

The integer is now 0
The point is now 0,0
Calling method increment(Point, int)...
At the end of the method... The integer is 1
The point is null
The integer is now 0 The point is now 1,0
*/