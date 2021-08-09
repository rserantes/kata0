package purchase;

import product.Product;

public class CheckoutItem {

    private Product product;

    private Integer price;

    public CheckoutItem(Product product) {
        this.product = product;
        price = product.getAmount();
    }

    public Product getProduct() {
        return product;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

}
