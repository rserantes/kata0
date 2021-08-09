package rules;

import java.util.List;
import model.Product;
import model.ProductFactory;

public class TShirt3OrMoreDiscount implements PricingRule {

    private Integer discountedPrice = 1900;

    @Override
    public Integer eligibleItems(List<Product> products) {
        int numberOfShirts = (int) products.stream().filter(ProductRules::isTShirt).count();
        return numberOfShirts >= 3 ? numberOfShirts : 0;
    }

    @Override
    public Integer getDiscount(List<Product> products) {
        return eligibleItems(products) * (ProductFactory.getTShirt().getAmount() - discountedPrice);
    }
}
