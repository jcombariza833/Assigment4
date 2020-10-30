import items.PurchasedItems;
import items.StoreItem;
import receipts.Receipt;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class SystemInterface {
    private  StoreItem[] storeItems;
    private  Date receiptDate;
    private  PurchasedItems items;
    private  ReceiptFactory factory;

    public SystemInterface() {
        storeItems = getStoreItems();
        int year = Calendar.getInstance().get(Calendar.YEAR);
        //receiptDate = new GregorianCalendar(year, 8, 3).getTime();
        receiptDate = new Date();
        items = new PurchasedItems();
        factory = new ReceiptFactory();
    }

    public String[] startNewReceipt(){
        String[] items = new String[getStoredItemsSize()];
        for (int i = 0; i < storeItems.length; i++) {
            items[i] = String.format("%d - %15s %n",(i + 1),storeItems[i]);
        }
        return items;
    }

    public void addItem(int index) {
        int fixedIndex = index - 1;
        items.addItem(storeItems[fixedIndex]);
    }

    public Receipt getReceipt() {
        return factory != null ? factory.getReceipt(items,receiptDate) : null;
    }

    public int getStoredItemsSize() {
        return storeItems.length;
    }

    static StoreItem[] getStoreItems() {
        StoreItem item1 = new StoreItem(
                "4028",
                "Samsung S9 (unlocked) Midnight Black 64 GB",
                719.99);

        StoreItem item2 = new StoreItem(
                "0915",
                "Samsung S9 Case (black)",
                39.99);

        StoreItem item3 = new StoreItem(
                "2428",
                "Anker External Battery (20,000 mAh)",
                49.99);

        StoreItem item4 = new StoreItem(
                "1406",
                "Iphone X case",
                36.99);

        return new StoreItem[] {item1,item2,item3,item4};
    }
}
