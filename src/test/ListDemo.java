package test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @ClassName ListDemo
 * @Description TODO
 * @Author faro_z
 * @Date 2022/4/28 3:41 下午
 * @Version 1.0
 **/
public class ListDemo {
    private static String[] productNames = {"华为", "OPPO", "小米"};
    private static Random random = new Random();
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            products.add(new Product(productNames[random.nextInt(3)], random.nextInt(100)));
        }
        StringBuilder builder = new StringBuilder();
        // 筛选所有 OPPO
        builder.append("所有 OPPO 产品信息如下：")
                .append("\n")
                .append(products.stream()
                        .filter(elem -> "OPPO".equals(elem.name))
                        .collect(Collectors.toList()));
        System.out.println(builder.toString());
    }
}

class Product {
    public String name;
    public int price;

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
