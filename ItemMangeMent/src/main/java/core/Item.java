package core;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Item implements Serializable {
    private String code;
    private String desc;
    private double price;
    private LocalDate shipmentDate;

    public Item(String name, String desc, double price, LocalDate shipmentDate) {
        this.code = name;
        this.desc = desc;
        this.price = price;
        this.shipmentDate = shipmentDate;
    }

    public String getCode() {
        return code;
    }

    public void setName(String name) {
        this.code = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDate getShipmentDate() {
        return shipmentDate;
    }

    public void setShipmentDate(LocalDate shipmentDate) {
        this.shipmentDate = shipmentDate;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (!(o instanceof Item item)) return false;
        return Objects.equals(code, item.code);
    }

    @Override
    public String toString() {
        return "Item{" +
                "code='" + code + '\'' +
                ", desc='" + desc + '\'' +
                ", price=" + price +
                ", shipmentDate=" + shipmentDate +
                '}';
    }
}
