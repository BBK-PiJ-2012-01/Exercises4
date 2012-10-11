class UnitMatrix { 
    int size;
    
    void setSize(int newSize) {
        // newSize is only visible inside setSize
        // size is also visible because we are inside
        // the UnitMatrix object's scope. 
        // ie. we don't need to use 'this' here.
        this.size = newSize;
    }

    void print() {
        for (int i = 0; i < size; i++) {
        // From here till end of print(), i is visible
            for (int j = 0; j < size; j++) { 
            // From here till end of print, j is visible
            // iff 0 < size.  Otherwise this loop is never entered.
                if (i == j) {
                    println("1 "); 
                } else {
                    println("0 "); 
                }
            }
            println "" 
        }
    } 
}


int dimension = 4;
int bigDimension = 8;
// dimension and bigDimension are only visible in the following lines,
// ie. not inside matrix's methods above.

UnitMatrix matrix = new UnitMatrix(); 
matrix.setSize(dimension); 
matrix.print(); 
matrix.setSize(bigDimension); 
matrix.print();