package main.java;

import java.math.BigDecimal;

public class ReportRecord {
    String subcategory;
    BigDecimal price;
    int quantity;

    public ReportRecord(String subcategory, BigDecimal price, int quantity){
        this.subcategory = subcategory;
        this.price = price;
        this.quantity = quantity;
    }

    public ReportRecord() {
    }

    public String getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(String subcategory) {
        this.subcategory = subcategory;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "ReportRecord{" +
                "subcategory='" + subcategory + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
