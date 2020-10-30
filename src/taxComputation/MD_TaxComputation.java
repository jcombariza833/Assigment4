package taxComputation;

import items.PurchasedItems;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class MD_TaxComputation extends TaxComputationMethod {
    @Override
    public double computeTax(PurchasedItems items, Date date) {
        double taxRate = taxHoliday(date) ? 0 : getSalesTax(date);
        return items.getTotalCost()*(1+ taxRate);
    }

    @Override
    boolean taxHoliday(Date date) {
        int year = Calendar.getInstance().get(Calendar.YEAR);
        Date startDate = new GregorianCalendar(year, 8, 14).getTime();
        Date endDate = new GregorianCalendar(year, 8, 20).getTime();

        return date.after(startDate) && date.before(endDate);
    }

    @Override
    public double getSalesTax(Date date) {
        return taxHoliday(date) ? 0.0 : 0.06;
    }
}
