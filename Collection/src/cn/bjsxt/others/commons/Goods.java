package cn.bjsxt.others.commons;

/**
 * Created by BenWhite on 2017/6/24.
 */
public class Goods {
    private String name;
    private double price;
    private boolean discount;

    public Goods() {
    }

    public Goods(String name, double price, boolean discount) {
        this.name = name;
        this.price = price;
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isDiscount() {
        return discount;
    }

    public void setDiscount(boolean discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "( 商品:" + this.getName() + ", 价格:" + this.getPrice() + ", 是否打折: " + (this.isDiscount()?"是":"否") + " )";
    }
}
