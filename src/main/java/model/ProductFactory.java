package model;

public class ProductFactory {

    public static Product getVoucher() {
        return new Product("Gift Card", 500);
    }

    public static Product getTShirt() {
        return new Product("Summer T-Shirt", 2000);
    }

    public static Product getPants() {
        return new Product("Summer Pants", 750);
    }

}
