package receipts;

import items.PurchasedItems;
import items.StoreItem;
import taxComputation.TaxComputationMethod;
import java.util.Date;
import java.util.Iterator;

public class BasicReceipt implements Receipt {
    private PurchasedItems items;
    private Date date;
    private StoreHeader store_header;
    private TaxComputationMethod tc;

    public BasicReceipt(PurchasedItems items, Date date) {
        this.date = date;
        this.items = items;
    }

    public void setStore_header(StoreHeader store_header) {
        this.store_header = store_header;
    }

    public void setTc(TaxComputationMethod tc) {
        this.tc = tc;
    }

    public double totalSale() {
        return items.getTotalCost();
    }

    public double amountDue() {
        return  (tc != null) ? tc.computeTax(items,date) : totalSale();
    }

    @Override
    public void prtReceipt() {
        System.out.println();
        System.out.println(store_header);
        System.out.println("ITEM #");

        Iterator<StoreItem> i = items.getIterator();
        while (i.hasNext()) {
            System.out.println(i.next());
        }
        System.out.println();
        System.out.printf("%-53s %.2f%n","Total Sale",totalSale());

        System.out.println();
        double tax = tc != null ? tc.getSalesTax(date) : 0;
        System.out.printf("%-53s %.2f%n",
                store_header.getState_code() + " Sales Tax " + tax*100 + "%",
                items.getTotalCost()*tax);

        System.out.println();
        System.out.printf("%-53s %.2f%n","TOTAL SALE", amountDue());
        System.out.println();
    }
}
