package cart.entity;

import org.apache.commons.collections.map.HashedMap;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Created by zhangbaoning on 2017/5/29.
 */
public class Cart {
    Map<Integer, CartItem> all_item = new HashedMap();
    double cart_total;

    public Map<Integer, CartItem> getAll_item() {
        return all_item;
    }

    public void setAll_item(Map<Integer, CartItem> all_item) {
        this.all_item = all_item;
    }

    public double getCart_total() {
        return cart_total;
    }

    public void setCart_total(double cart_total) {
        this.cart_total = cart_total;
    }

    public void add_item(Integer pid, CartItem cartItem) {
        all_item.put(pid, cartItem);
        cart_total += cartItem.getItem_total();
    }

    public Collection getCollection() {
        return all_item.values();
    }
}
