package pricing;

import java.util.List;
import product.Product;
import product.ProductFactory;
import product.ProductRules;
import purchase.CheckoutItem;

public class TShirt3OrMoreDiscount implements PricingRule {

    private Integer discountedPrice = 1900;

    private Integer eligibleItems(List<CheckoutItem> items) {
        int numberOfShirts = (int) items.stream().map(CheckoutItem::getProduct).filter(ProductRules::isTShirt).count();
        return numberOfShirts >= 3 ? numberOfShirts : 0;
    }

    @Override
    public Integer getDiscount(List<CheckoutItem> items) {
        return eligibleItems(items) * (ProductFactory.getTShirt().getAmount() - discountedPrice);
    }
}
