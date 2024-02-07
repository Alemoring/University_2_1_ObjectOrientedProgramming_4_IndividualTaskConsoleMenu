import java.util.Calendar;

public class Technic extends Product{
    private static short id = 3;
    private String name;
    private Calendar purchaseDate;
    private double price;
    private String address;
    private short quality;
    private String comment = "";
    private int guarantee = -1;

    public Technic(String name, Calendar purchaseDate, double price, String address, short quality, String comment, int guarantee){
        this.name = name;
        this.purchaseDate = purchaseDate;
        this.price = price;
        this.address = address;
        this.quality = quality;
        this.comment = comment;
        this.guarantee = guarantee;
    }
    public Technic(String name, Calendar purchaseDate, double price, String address, short quality, int guarantee){
        this.name = name;
        this.purchaseDate = purchaseDate;
        this.price = price;
        this.address = address;
        this.quality = quality;
        this.guarantee = guarantee;
    }
    public Technic(String name, Calendar purchaseDate, double price, String address, short quality, String comment){
        this.name = name;
        this.purchaseDate = purchaseDate;
        this.price = price;
        this.address = address;
        this.quality = quality;
        this.comment = comment;
    }
    public Technic(String name, Calendar purchaseDate, double price, String address, short quality){
        this.name = name;
        this.purchaseDate = purchaseDate;
        this.price = price;
        this.address = address;
        this.quality = quality;
    }
    public short getId(){
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Calendar getPurchaseDate() {
        return purchaseDate;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public short getQuality() {
        return quality;
    }

    @Override
    public String getComment() {
        return comment;
    }

    public int getGuarantee() {
        return guarantee;
    }
}