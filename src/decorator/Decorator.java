package decorator;

import receipts.Receipt;

public abstract class Decorator implements Receipt {
    private Receipt trailer;
    protected AddOn addOn;

    public Decorator(Receipt r, AddOn a) {
        trailer = r;
        addOn = a;
    }

    protected void callTrailer() {
        trailer.prtReceipt();
    }

    public abstract void prtReceipt();
}
