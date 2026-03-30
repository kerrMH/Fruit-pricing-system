
/**
 * 超市：实现题目要求的4种计价逻辑
 */
public class Supermarket {
    private final Fruit apple = new Fruit("苹果", 8.0);
    private final Fruit strawberry = new Fruit("草莓", 13.0);
    private final Fruit mango = new Fruit("芒果", 20.0);
    private final ShoppingCart cart = new ShoppingCart();

    // ====================== 题目1 ======================
    public double calcA(int appleQty, int strawberryQty) {
        cart.clear();
        cart.add(apple, appleQty);
        cart.add(strawberry, strawberryQty);
        return cart.calcTotal();
    }

    // ====================== 题目2 ======================
    public double calcB(int appleQty, int strawberryQty, int mangoQty) {
        cart.clear();
        resetAllDiscount();
        cart.add(apple, appleQty);
        cart.add(strawberry, strawberryQty);
        cart.add(mango, mangoQty);
        return cart.calcTotal();
    }

    // ====================== 题目3 ======================
    public double calcC(int appleQty, int strawberryQty, int mangoQty) {
        cart.clear();
        strawberry.setDiscount(0.8);
        cart.add(apple, appleQty);
        cart.add(strawberry, strawberryQty);
        cart.add(mango, mangoQty);
        double total = cart.calcTotal();
        resetAllDiscount();
        return total;
    }

    // ====================== 题目4 ======================
    public double calcD(int appleQty, int strawberryQty, int mangoQty) {
        cart.clear();
        strawberry.setDiscount(0.8);
        cart.add(apple, appleQty);
        cart.add(strawberry, strawberryQty);
        cart.add(mango, mangoQty);
        double total = cart.calcTotalWithDiscount();
        resetAllDiscount();
        return total;
    }

    // 重置折扣
    private void resetAllDiscount() {
        apple.setDiscount(1.0);
        strawberry.setDiscount(1.0);
        mango.setDiscount(1.0);
    }

    // Getter
    public Fruit getApple() { return apple; }
    public Fruit getStrawberry() { return strawberry; }
    public Fruit getMango() { return mango; }
}