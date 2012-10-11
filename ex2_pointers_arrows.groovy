// Stack is where simple types and complex pointer types are stored statically.
// Heap is where complex (boxed) types are stored dynamically.

class Point { 
    int x;
    int y; 
}

void increment(Point point, int n) {
    n = n + 1;                
    point.x = point.x + 1;    
    point = null;             
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


/*    Stack:
  - Point class definition
  - 