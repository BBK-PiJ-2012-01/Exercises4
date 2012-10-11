// Stack is where simple types and complex pointer types are stored statically.
// Heap is where complex (boxed) types are stored dynamically.

class Point {  // Code (class definition of Point)
    /*
     * On creating a new object of Point, the object
     * is stored in the heap.  Instance variables
     * are stored in the object space ie. in the heap.
     *
     * Even instance variables of references (pointers)
     * to objects go in the object's space (in the heap).
     *
     * eg. 
     Point p
     * p is a pointer stored in 'this' space in the heap.
    */
    int x;    // Heap (Instance variables x, y)
    int y; 
}

void increment(Point point, int n) { // Heap (member method of file class)
                                     // Stack (local variables point and n)
                                     // Code (method definition)
        /*
         * On creating a new object (of this file, which in Groovy
         * is sort-of like a class
        */
    n = n + 1;                       // Stack (local variable)
    
    point.x = point.x + 1;           // 'point' is a copy of the pointer
                                     // passed to the method.  It is stored
                                     // in the stack because its a local
                                     // variable.
                                     // The object 'point' refers to is
                                     // in the heap, and 'x' is stored
                                     // in the point object's space,
                                     // which is in the heap.
                                     
    point = null;                    // 'point' now points nowhere, but
                                     // it's still where it was (in the stack)
    println " At the end of the method...";
    println " The integer is " + n; 
    println " The point is " + point;
}
// Program execution starts here

// In java proper, the following would be in FileName.main,
// so variables defined below are local variables,
// so stored in the stack.
Point myPoint = new Point();         // myPoint is a pointer to the 
                                     // newly-created Point object.
                                     // The pointer is stored in stack,
                                     // and the object is stored in heap.

myPoint.x = 0;                       // 'x' is an integer stored in the
                                     // heap space allocated to the object
                                     // pointed to by myPoint.
myPoint.y = 0;

int myInt = 0;                       // myInt is a local variable so is
                                     // in the stack.  It's not boxed,
                                     // being primitive, so there's no
                                     // pointiness.
println "The integer is now " + myInt;
println "The point is now " + myPoint.x + "," + myPoint.y; 
println "Calling method increment(Point, int)..." 

increment(myPoint, myInt);           // the pointer to the increment function
                                     // is added to the 'call stack' (in the stack)

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
  - Point (class definition)
  - x, y 
*/