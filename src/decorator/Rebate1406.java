package decorator;

import decorator.Rebate;
import items.PurchasedItems;

public class Rebate1406 implements Rebate {
    @Override
    public boolean applies(PurchasedItems items) {
        return items.containsItem("1406");
    }

    @Override
    public String getLines() {
        return  "Mail-in decorator.Rebate for Item #1406\n" +
                "Name:\n" +
                "Address:\n\n" +
                "Mail to: Best Buy Rebates, P.O. Box 1400, Orlando, FL";
    }
}
