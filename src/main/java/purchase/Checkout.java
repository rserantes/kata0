package purchase;

import java.util.ArrayList;
import java.util.List;
import product.Product;
import pricing.PriceFormatter;
import pricing.PricingRule;

public class Checkout {

    private List<PricingRule> pricingRules;

    private List<CheckoutItem> items = new ArrayList<>();

    private Integer totalAmount = 0;

    private PriceFormatter priceFormatter = new PriceFormatter();

    public Checkout(List<PricingRule> pricingRules) {
        this.pricingRules = pricingRules;
    }

    public void scan(Product product) {
        items.add(new CheckoutItem(product));
        for (PricingRule pricingRule: pricingRules) {
            pricingRule.apply(items);
        }
        totalAmount = sumItemsPrice();
    }

    private Integer sumItemsPrice() {
        return items.stream().map(CheckoutItem::getPrice).reduce(0, Integer::sum);
    }

    public Integer getProductsQuantity() {
        return items.size();
    }

    public String getTotal() {
        return priceFormatter.format(totalAmount);
    }
}
