
import java.util.HashMap;
import java.util.Map;

/**
 * 购物车：负责添加商品、计算总价
 */
public class ShoppingCart {
    private final Map<Fruit, Integer> items = new HashMap<>();

    // 添加商品
    public void add(Fruit fruit, int quantity) {
        if (quantity < 0) throw new IllegalArgumentException("数量不能为负数");
        items.put(fruit, quantity);
    }

    // 计算总价（不含满减）
    public double calcTotal() {
        double total = 0;
        for (Map.Entry<Fruit, Integer> entry : items.entrySet()) {
            total += entry.getKey().getActualPrice() * entry.getValue();
        }
        return total;
    }

    // 计算总价（含满100减10）
    public double calcTotalWithDiscount() {
        double total = calcTotal();
        return total >= 100 ? total - 10 : total;
    }

    public void clear() {
        items.clear();
    }
}