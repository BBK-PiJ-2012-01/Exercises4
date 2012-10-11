class IOMortgage extends IOGeneric {
    static Mortgage getMortgage() {
        print "Enter the total amount borrowed: "
        double total_amount = getDouble()
        if (total_amount <= 0)
            throw new BadInput("Total amount borrowed must be > 0")
        
        print "Enter the interest rate per annum as a percentage: "
        double rate = getDouble()
        if (rate <= 0)
            throw new BadInput("Interest rate must be > 0")
        
        print "Enter the duration of the mortgage in years: "
        double duration = getDouble()
        if (duration <= 0)
            throw new BadInput("Duration must be > 0")
        
        return new Mortgage(total_amount, rate, duration)
    }
    
    static void printMortgage(Mortgage m) {
        printResult("Total amount to be paid = " + m.getTotalCost())
        printResult("Annual cost = " + m.getAnnualCost())
        double interest = m.getInterestCost()
        printResult("Number of years to pay back interest = " + m.getDurationToPayOff(interest))
    }
}

class Mortgage {
    double total_amount, rate, duration
    
    Mortgage(double new_total, double new_rate, double new_duration) {
        total_amount = new_total
        rate = new_rate
        duration = new_duration
    }
    
    double getTotalCost() {
        return total_amount * (1 + rate/100)
    }
    
    double getInterestCost() {
        return getTotalCost() - total_amount
    }
    
    double getAnnualCost() {
        return getTotalCost() / duration
    }
    
    double getDurationToPayOff(double amount) {
        if (amount < 0 || amount > total_amount)
            throw new BadInput("Invalid amount: " + amount)
        return duration * amount / total_amount
    }   
}

Mortgage m = IOMortgage.getMortgage()
IOMortgage.printMortgage(m)