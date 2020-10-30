package taxComputation;

import items.PurchasedItems;

import java.util.Date;

public abstract class TaxComputationMethod {
    public abstract double computeTax(PurchasedItems items, Date date);
    abstract boolean taxHoliday(Date date);
    public abstract double getSalesTax(Date date);
}
