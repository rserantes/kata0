package product;

public class ProductRules {

    public static boolean isVoucher(Product product) {
        return product.getName().equals("Gift Card");
    }

    public static boolean isTShirt(Product product) {
        return product.getName().equals("Summer T-Shirt");
    }

}
