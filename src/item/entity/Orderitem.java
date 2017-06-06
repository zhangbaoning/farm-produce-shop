package item.entity;

import order.entity.Orders;
import product.entity.Product;

/**
 * Created by zhangbaoning on 2017/5/30.
 */
public class Orderitem {
    private int itemid;
    private Integer count;
    private Double subtotal;
    private Product product; //中间表和商品是多对一
    private Orders orders; //中间表和订单是多对一

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getItemid() {
        return itemid;
    }

    public void setItemid(int itemid) {
        this.itemid = itemid;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Orderitem orderitem = (Orderitem) o;

        if (itemid != orderitem.itemid) return false;
        if (count != null ? !count.equals(orderitem.count) : orderitem.count != null) return false;
        if (subtotal != null ? !subtotal.equals(orderitem.subtotal) : orderitem.subtotal != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = itemid;
        result = 31 * result + (count != null ? count.hashCode() : 0);
        result = 31 * result + (subtotal != null ? subtotal.hashCode() : 0);
        return result;
    }
}
