package decorator;

import items.PurchasedItems;

public interface AddOn {
    public boolean applies(PurchasedItems items);
    public String getLines();
}
