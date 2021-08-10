package pricing;

import java.util.List;
import java.util.stream.Collectors;
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
        if (eligibleItems(items) > 0) {

            List<CheckoutItem> vouchers = items.stream()
                    .filter(item -> ProductRules.isVoucher(item.getProduct()))
                    .collect(Collectors.toList());

            for (int i = 1; i < vouchers.size(); i = i+2) {
                vouchers.get(i).setPrice(0);
            }
        }

        return items;
    }
}
