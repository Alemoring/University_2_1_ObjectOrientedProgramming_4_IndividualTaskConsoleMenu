package Data;

import java.util.Calendar;

public abstract class Product {
    private short id;
    private String name;
    private Calendar purchaseDate;
    private double price;
    private String address;
    private short quality;
    private String comment;

    public abstract short getId();
    public abstract String getName();
    public abstract Calendar getPurchaseDate();
    public abstract double getPrice();
    public abstract String getAddress();
    public abstract short getQuality();
    public abstract String getComment();
}