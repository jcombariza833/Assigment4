package items;

public class StoreItem {
    private String itemCode;
    private String itemDescription;
    private double itemPrice;

    public StoreItem(String itemCode, String itemDescription, double itemPrice) {
        this.itemCode = itemCode;
        this.itemDescription = itemDescription;
        this.itemPrice = itemPrice;
    }

    public String getItemCode() {
        return itemCode;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    @Override
    public String toString() {
        return String.format("%s %-48s %.2f",itemCode,itemDescription,itemPrice);
    }
}
