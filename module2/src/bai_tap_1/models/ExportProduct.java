package bai_tap_1.models;

import java.util.List;

public class ExportProduct extends Product{
    private int exportPrice;
    private String exportNation;

    public ExportProduct(String id, String code, String name, int price, int quantity, String manufacture, int exportPrice, String exportNation) {
        super(id, code, name, price, quantity, manufacture);
        this.exportPrice = exportPrice;
        this.exportNation = exportNation;
    }

    public ExportProduct(String id, List<String> data) {
        super(id, data.get(0), data.get(1), Integer.parseInt(data.get(2)), Integer.parseInt(data.get(3)), data.get(4));
        exportPrice = Integer.parseInt(data.get(5));
        exportNation = data.get(6);
    }

    public int getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(int exportPrice) {
        this.exportPrice = exportPrice;
    }

    public String getExportNation() {
        return exportNation;
    }

    public void setExportNation(String exportNation) {
        this.exportNation = exportNation;
    }

    public static String getInfo(){
        return "CODE,NAME,PRICE,QUANTITY,MANUFACTURE,EXPORT_PRICE,EXPORT_NATION";
    }

    @Override
    public String toString() {
        return super.toString() + "ExportProduct{" +
                "exportPrice=" + exportPrice +
                ", exportNation='" + exportNation + '\'' +
                '}';
    }
}
