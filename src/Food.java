import java.util.Calendar;

public class Food extends Product{
    private static short id = 1;
    private String name;
    private Calendar purchaseDate;
    private double price;
    private String address;
    private short quality;
    private String comment = "0";
    private Calendar storageLife;

    public Food(String name, Calendar purchaseDate, double price, String address, short quality, String comment, Calendar storageLife){
        this.name = name;
        this.purchaseDate = purchaseDate;
        this.price = price;
        this.address = address;
        this.quality = quality;
        this.comment = comment;
        this.storageLife = storageLife;
    }
    public Food(String name, Calendar purchaseDate, double price, String address, short quality, String comment){
        Calendar altstorageLife = Calendar.getInstance();
        altstorageLife.set(1950, 1, 1);
        this.name = name;
        this.purchaseDate = purchaseDate;
        this.price = price;
        this.address = address;
        this.quality = quality;
        this.comment = comment;
        this.storageLife = altstorageLife;
    }
    public Food(String name, Calendar purchaseDate, double price, String address, short quality, Calendar storageLife){
        this.name = name;
        this.purchaseDate = purchaseDate;
        this.price = price;
        this.address = address;
        this.quality = quality;
        this.storageLife = storageLife;
    }
    public Food(String name, Calendar purchaseDate, double price, String address, short quality){
        Calendar altstorageLife = Calendar.getInstance();
        altstorageLife.set(1950, 1, 1);
        this.name = name;
        this.purchaseDate = purchaseDate;
        this.price = price;
        this.address = address;
        this.quality = quality;
        this.storageLife = altstorageLife;
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

    public Calendar getStorageLife(){
        return storageLife;
    }
}