/**
 * 
 */
package com.luna.console.design.flyweight.pkg;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xukai
 * 
 */
public class FlavorFactory {

    private final Map<String, Order> flavorPool = new HashMap<String, Order>();

    // 静态工厂,负责生成订单对象
    private static FlavorFactory flavorFactory = new FlavorFactory();

    private FlavorFactory() {

    }

    public static FlavorFactory getInstance() {

        return flavorFactory;
    }

    public Order getOrder(String flavor) {

        Order order = null;
        if (flavorPool.containsKey(flavor)) {// 如果此映射包含指定键的映射关系，则返回 true
            order = flavorPool.get(flavor);
        } else {
            order = new FlavorOrder(flavor);
            flavorPool.put(flavor, order);
        }
        return order;
    }

    public int getTotalFlavorsMade() {

        return flavorPool.size();
    }
}
