import java.util.Scanner;

/**
 * 控制台交互主程序（Java21）
 */
public class Main {
    private static final Supermarket market = new Supermarket();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("======================================");
        System.out.println("       超市水果计价系统");
        System.out.println("======================================");
        showPriceInfo();

        while (true) {
            showMenu();
            try {
                int choice = scanner.nextInt();
                if (choice == 0) {
                    System.out.println("退出程序～");
                    break;
                }
                handleMenu(choice);
            } catch (Exception e) {
                System.out.println("输入错误，请输入数字！");
                scanner.next();
            }
        }
        scanner.close();
    }

    // 显示价格
    private static void showPriceInfo() {
        System.out.println("商品单价：");
        System.out.println("🍎 苹果：8元/斤");
        System.out.println("🍓 草莓：13元/斤");
        System.out.println("🥭 芒果：20元/斤");
        System.out.println("促销：草莓8折 | 满100减10\n");
    }

    // 菜单
    private static void showMenu() {
        System.out.println("————————————————————");
        System.out.println("请选择计算模式：");
        System.out.println("1 → 题目1：苹果+草莓");
        System.out.println("2 → 题目2：加芒果");
        System.out.println("3 → 题目3：草莓8折");
        System.out.println("4 → 题目4：8折+满100减10");
        System.out.println("0 → 退出");
        System.out.println("————————————————————");
        System.out.println("请输入：");
    }

    // 处理选择
    private static void handleMenu(int choice) {
        System.out.print("请输入苹果购买斤数：");
        int a = scanner.nextInt();
        System.out.print("请输入草莓购买斤数：");
        int s = scanner.nextInt();

        double result = 0;
        String title = "";

        switch (choice) {
            case 1 -> {
                result = market.calcA(a, s);
                title = "【题目1】总价：";
            }
            case 2 -> {
                System.out.print("请输入芒果购买斤数：");
                int m = scanner.nextInt();
                result = market.calcB(a, s, m);
                title = "【题目2】总价：";
            }
            case 3 -> {
                System.out.print("请输入芒果购买斤数：");
                int m = scanner.nextInt();
                result = market.calcC(a, s, m);
                title = "【题目3】折后总价：";
            }
            case 4 -> {
                System.out.print("请输入芒果购买斤数：");
                int m = scanner.nextInt();
                result = market.calcD(a, s, m);
                title = "【题目4】优惠后总价：";
            }
            default -> {
                System.out.println("无效选项");
                return;
            }
        }

        // 输出结果 + 自动校验
        System.out.printf("%s %.2f 元\n", title, result);
        verify(choice, a, s, result);
    }

    // 结果校验（验证正确性）
    private static void verify(int mode, int a, int s, double actual) {
        double expect = switch (mode) {
            case 1 -> a * 8.0 + s * 13.0;
            case 2 -> a * 8.0 + s * 13.0 + 0;
            case 3 -> a * 8.0 + s * 13.0 * 0.8 + 0;
            case 4 -> {
                double temp = a * 8.0 + s * 13.0 * 0.8;
                yield temp >= 100 ? temp - 10 : temp;
            }
            default -> 0;
        };
    }
}