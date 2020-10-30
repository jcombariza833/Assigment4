package decorator;

import decorator.SecondaryHeading;
import items.PurchasedItems;

public class HolidayGreeting implements SecondaryHeading {
    @Override
    public boolean applies(PurchasedItems items) {
        return true;
    }

    @Override
    public String getLines() {
        return String.format("%n%45s","* Happy Holidays from Best Buy! *");
    }
}
