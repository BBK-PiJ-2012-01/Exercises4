class Integer2 {
    private int value
    
    Integer2() {}
    Integer2(int new_value) { setValue(new_value) }
    
    double getValue() { 
        return value 
    }
    
    void setValue(double new_value) { 
        value = new_value 
    }
    
    boolean isOdd() {
        return value % 2
    }
    
    boolean isEven() {
        return !isOdd()
    }
    
    void prettyPrint() {
        IOGeneric.printResult("Value is " + value)
    }
    
    String toString() {
        return value
    }
}
    
// The following is copied from exercise 7:

Integer2 i2 = new Integer2();
print "Enter a number: ";
String str = System.console().readLine(); 
int i = Integer.parseInt(str); 
i2.setValue(i);
print "The number you entered is "

if (i2.isEven()) {
    println "even.";
} else if (i2.isOdd()) {
        println "odd.";
} else {
    println "undefined!! Your code is buggy!"; 
}

int parsedInt = Integer.parseInt(i2.toString()); 
if (parsedInt == i2.getValue()) {
    println("Your toString() method seems to work fine."); 
}