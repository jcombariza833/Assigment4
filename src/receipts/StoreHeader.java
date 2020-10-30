package receipts;

public class StoreHeader {
    private String street_addr;
    private String zip_code;
    private String state_code;
    private String phone_num;
    private String store_num;

    public StoreHeader(String street_addr, String state_code, String zip_code, String store_num,  String phone_num) {
        this.street_addr = street_addr;
        this.state_code = state_code;
        this.zip_code = zip_code;
        this.store_num = store_num;
        this.phone_num = phone_num;
    }

    public String getStreet_addr() {
        return street_addr;
    }

    public String getZip_code() {
        return zip_code;
    }

    public String getState_code() {
        return state_code;
    }

    public String getPhone_num() {
        return phone_num;
    }

    public String getStore_num() {
        return store_num;
    }

    @Override
    public String toString() {

        return String.format("%-48s %s %n%-48s %s%n",
                "BEST BUY",
                "Store # " + store_num,
                street_addr + ", " + state_code + " " + zip_code,
                phone_num);
    }
}
