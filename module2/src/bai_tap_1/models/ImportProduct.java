package bai_tap_1.models;

import java.util.List;

public class ImportProduct extends Product {
    private int importPrice;
    private String importDistrict;
    private int vat;

    public ImportProduct(String id, String code, String name, int price, int quantity, String manufacture, int importPrice, String importDistrict, int vat) {
        super(id, code, name, price, quantity, manufacture);
        this.importPrice = importPrice;
        this.importDistrict = importDistrict;
        this.vat = vat;
    }

    public ImportProduct(String id, List<String> data) {
        super(id, data.get(0), data.get(1), Integer.parseInt(data.get(2)), Integer.parseInt(data.get(3)), data.get(4));
        importPrice = Integer.parseInt(data.get(5));
        importDistrict = data.get(6);
        vat = Integer.parseInt(data.get(7));
    }

    public int getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(int importPrice) {
        this.importPrice = importPrice;
    }

    public String getImportDistrict() {
        return importDistrict;
    }

    public void setImportDistrict(String importDistrict) {
        this.importDistrict = importDistrict;
    }

    public int getVat() {
        return vat;
    }

    public void setVat(int vat) {
        this.vat = vat;
    }

    public static String getInfo(){
        return "CODE,NAME,PRICE,QUANTITY,MANUFACTURE,IMPORT_PRICE,IMPORT_DISTRICT,VAT";
    }

    @Override
    public String toString() {
        return super.toString() + "ImportProduct{" +
                "importPrice=" + importPrice +
                ", importDistrict='" + importDistrict + '\'' +
                ", vat=" + vat +
                '}';
    }
}
