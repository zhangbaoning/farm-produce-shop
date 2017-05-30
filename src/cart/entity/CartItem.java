package cart.entity;

import product.entity.Product;

/**
 * Created by zhangbaoning on 2017/5/29.
 */
public class CartItem {
    Product product;
    int count;
    double item_total;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product,Integer count) {
        this.product = product;
        this.count += count;
    }

    public double getItem_total() {
        return product.getShopPrice()*count;
    }

    public void setItem_total(double item_total) {
        this.item_total = item_total;
    }
}
