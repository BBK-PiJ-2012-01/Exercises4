class BaseConverter {
    int decimal_value = 0
    
    static def available_chs = ('0'..'9' as List) + ('a'..'z' as List) 
    static int max_base = available_chs.size()
    
    BaseConverter(String str, int base) { setValue(str, base) }
    
    BaseConverter(int new_decimal_value) { setValue(new_decimal_value) }
    
    BaseConverter() {}
    
    void setValue(int new_decimal_value) {
        decimal_value = new_decimal_value
    }
    
    void setValue(String str, int base) {
        checkValidity(str, base)
        str = str.toLowerCase().reverse()
        char[] reversed_chars = str.getChars()
        
        for (i in 0..reversed_chars.size()-1) {
            decimal_value += valueOf(str[i], base) * base ** i
        }
    }
    
    int valueOf(String ch, int base) {
        if (base < 1)
            throw new BadInput("Base must be at least 1")
        return available_chs.indexOf(ch)
    }
    
    char charOf(int value) {
        return available_chs[value]
    }
    
    String toBase(int new_base) {
        if (new_base < 1)
            throw new BadInput("Base must be at least 1")
            
        if (new_base == 1)
            return "1"*decimal_value
        else if (new_base == 10)
            return decimal_value
        
        int value_left = decimal_value

        String str = ""
        int remainder
        
        while (value_left != 0) {
            remainder = value_left % new_base
            str += charOf(remainder)
            value_left = value_left / new_base
        }
        
        return str.reverse()
    }

    void checkValidity(String str, int base) {
        if (base < 1)
            throw new BadInput("Base must be at least 1")
        for (ch in str) {
            if (!(ch in available_chs[0..base-1]))
                // String can only contain digits or letters,
                // and only those allowed in the base.
                throw new BadInput("Character " + ch + " not in " + available_chs[0..base-1])
        }
    }           
}
         
/*
print "Enter base of number: "
int base = IOGeneric.getInteger()

print "Enter number: "
String str = System.console().readLine()

BaseConverter bc = new BaseConverter(str, base)

while(true) {
    println "-"*20
    print "Enter new base: "
    str = System.console().readLine()
    if (str.length() == 0)
        break
    println "Number is now: " + bc.toBase(str as int)
}
*/