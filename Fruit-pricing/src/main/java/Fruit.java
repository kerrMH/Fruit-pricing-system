public class Fruit {
    private final String name;
    private final double price;
    private double discount = 1.0;

    public Fruit(String name, double price) {
        this.name = name;
        this.price = price;
    }

    // 设置折扣
    public void setDiscount(double discount) {
        this.discount = discount;
    }

    // 获取实际单价
    public double getActualPrice() {
        return price * discount;
    }

    // Getter
    public String getName() {
        return name;
    }

    public double getOriginPrice() {
        return price;
    }
}
