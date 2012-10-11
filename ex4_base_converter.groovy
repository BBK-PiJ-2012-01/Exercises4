class BinaryDecimal {
    BaseConverter bc = new BaseConverter()
    
    int binary2decimal(String str) {
        bc.setValue(str, 2)
        return Integer.parseInt(bc.toBase(10))
    }
    
    String decimal2binary(int value) {
        bc.setValue(value)
        return bc.toBase(2)
    }
}

print "Type '1' for binary2decimal, or '2' for decimal2binary input: "
int choice = IOGeneric.getInteger()
def converter

if (choice == 1)
    converter = { return (new BinaryDecimal()).binary2decimal(it) }
else if (choice == 2)
    converter = { return (new BinaryDecimal()).decimal2binary(Integer.parseInt(it)) }
else
    throw new BadInput("That's not what I asked for...")

print "Now enter the number to convert: "    
String str = System.console().readLine()

IOGeneric.printResult("The converted value is: " + converter(str))