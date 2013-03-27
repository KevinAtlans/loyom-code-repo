/**
 * 
 */
package com.luna.console.design.flyweight.pkg;

/**
 * @author xukai
 * 
 */
public class FlavorOrder extends Order {

    public String flavor;

    // 获取咖啡口味
    public FlavorOrder(String flavor) {

        this.flavor = flavor;
    }

    /**
     * {@inheritDoc}
     * 
     * @see com.luna.console.design.flyweight.pkg.Order#sell()
     */
    @Override
    public void sell() {

        System.out.println("卖出一份" + flavor + "的咖啡。");
    }

}
