package pricing;

import java.util.List;
import product.ProductFactory;
import product.ProductRules;
import purchase.CheckoutItem;

public class VoucherTwoForOne implements PricingRule {

    private Integer eligibleItems(List<CheckoutItem> items) {
        return (int)items.stream().map(CheckoutItem::getProduct).filter(ProductRules::isVoucher).count() / 2;
    }

    @Override
    public Integer getDiscount(List<CheckoutItem> items) {
        return eligibleItems(items) * ProductFactory.getVoucher().getAmount();
    }

    @Override
    public List<CheckoutItem> apply(List<CheckoutItem> items) {
        return null;
    }
}
