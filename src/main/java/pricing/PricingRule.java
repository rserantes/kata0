package pricing;

import java.util.List;
import purchase.CheckoutItem;

public interface PricingRule {

    Integer getDiscount(List<CheckoutItem> items);

    List<CheckoutItem> apply(List<CheckoutItem> items);

}
