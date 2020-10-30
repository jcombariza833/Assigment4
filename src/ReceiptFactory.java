import decorator.*;
import items.PurchasedItems;
import receipts.BasicReceipt;
import receipts.Receipt;
import receipts.StoreHeader;
import taxComputation.CA_TaxComputation;
import taxComputation.MA_TaxComputation;
import taxComputation.MD_TaxComputation;
import taxComputation.TaxComputationMethod;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;

public class ReceiptFactory {
    private StoreHeader storeHeader;
    private TaxComputationMethod taxComputationMethod;
    private AddOn[] addOns;

    public ReceiptFactory() {
        this.addOns = populateAddOns();
        this.storeHeader = readConfigFile("src/Config");
        this.taxComputationMethod = assignTaxMethod(storeHeader);
    }

    public Receipt getReceipt(PurchasedItems purchasedItems, Date date){
        Receipt receiptResult;

        BasicReceipt receipt = new BasicReceipt(purchasedItems,date);
        receipt.setStore_header(storeHeader);
        receipt.setTc(taxComputationMethod);

        receiptResult = receipt;

        for (AddOn addOn: addOns ) {
            if(addOn.applies(purchasedItems)) {
                if(addOn instanceof SecondaryHeading) {
                    receiptResult = new PreDecorator(receiptResult,addOn);
                } else {
                    receiptResult = new PostDecorator(receiptResult,addOn);
                }
            }
        }

        return receiptResult;
    }

    private AddOn[] populateAddOns() {
        return new AddOn[]{
                new HolidayGreeting(),
                new Coupon100Get10Percent(),
                new Rebate1406(),
                new Rebate0915()
        };
    }

    private StoreHeader readConfigFile(String path) {
        StoreHeader header = null;

        try {
            List<String> allLines = Files.readAllLines(Paths.get(path));
            header = new StoreHeader(
                    allLines.get(0),
                    allLines.get(1),
                    allLines.get(2),
                    allLines.get(3),
                    allLines.get(4));


        } catch (IOException e) {
            e.printStackTrace();
        }

        return header;
    }

    private TaxComputationMethod assignTaxMethod(StoreHeader storeHeader) {
        switch (storeHeader.getState_code()) {
            case "MD":
                return new MD_TaxComputation();
            case "CA":
                return new CA_TaxComputation();
            case "MA":
                return new MA_TaxComputation();
            default:
                return null;
        }
    }
}
