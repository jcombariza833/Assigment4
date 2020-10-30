package decorator;

import decorator.Coupon;
import items.PurchasedItems;

public class Coupon100Get10Percent implements Coupon {
    @Override
    public boolean applies(PurchasedItems items) {
        return items.getTotalCost() > 100.0;
    }

    @Override
    public String getLines() {
        return "\nBEST BUY COUPON    10% off next purchase\nGood until 12/31/2020\n";
    }
}
