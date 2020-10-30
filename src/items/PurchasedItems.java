package items;

import items.StoreItem;

import java.util.ArrayList;
import java.util.Iterator;

public class PurchasedItems {
    private ArrayList<StoreItem> items;

    public PurchasedItems() {
        items = new ArrayList();
    }

    public void addItem(StoreItem item) {
        items.add(item);
    }
    public double getTotalCost() {
        double total = 0.0;
        for (StoreItem item: items) {
            total+= item.getItemPrice();
        }
        return total;
    }
    public boolean containsItem(String itemCode) {
        boolean isContained = false;
        for (StoreItem item: items) {
            if(item.getItemCode().equals(itemCode)) {
                isContained = true;
                break;
            }
        }
        return isContained;
    }

    public Iterator<StoreItem> getIterator() {
        return items.iterator();
    }
}
