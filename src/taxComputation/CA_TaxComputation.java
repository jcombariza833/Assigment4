package taxComputation;

import items.PurchasedItems;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class CA_TaxComputation extends TaxComputationMethod {
    @Override
    public double computeTax(PurchasedItems items, Date date) {
        double taxRate = taxHoliday(date) ? 0 : getSalesTax(date);
        return items.getTotalCost()*(1+ taxRate);
    }

    @Override
    boolean taxHoliday(Date date) {
        return false;
    }

    @Override
    public double getSalesTax(Date date) {
        return taxHoliday(date) ? 0.0 : 0.0625;
    }
}
