print "Enter number to convert: "
String str = System.console().readLine()

BaseConverter bc = new BaseConverter()

if (str.startsWith("0x")) {
    if (str.length() < 3)
        throw new BadInput("Not enough digits")
    bc.setValue(str[2..str.length()-1], 16)
    IOGeneric.printResult("That was hex, here it is in decimal: " + bc.toBase(10))
} else {
    if (str.length() < 1)
        throw new BadInput("Not enough digits")
    bc.setValue(str, 10)
    IOGeneric.printResult("That was decimal, here it is in hex: " + bc.toBase(16))
}