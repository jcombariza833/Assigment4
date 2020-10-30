package decorator;

import decorator.AddOn;
import decorator.Decorator;
import receipts.Receipt;

public class PreDecorator extends Decorator {

    public PreDecorator(Receipt r, AddOn a) {
        super(r, a);
    }

    @Override
    public void prtReceipt() {
        System.out.println(addOn.getLines());
        callTrailer();
    }
}
