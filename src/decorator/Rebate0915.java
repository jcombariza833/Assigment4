package decorator;

import items.PurchasedItems;

public class Rebate0915 implements Rebate {
    @Override
    public boolean applies(PurchasedItems items) {
        return items.containsItem("0915");
    }

    @Override
    public String getLines() {
        return "\n$10 REBATE Item 0915 Samsung S9 Case\n" +
                "Mail ORIGINAL receipt and Proof of Purchase from package to:\n" +
                "BEST BUY / SAMSUNG REBATES\n" +
                "1000 Industry Way\n" +
                "Owings Mills, MD 21117\n\n" +
                "Please allow 3-4 weeks for processing\n";
    }
}
