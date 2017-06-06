package order.service;

import cart.entity.Cart;
import cart.entity.CartItem;
import item.dao.ItemDao;
import item.entity.Orderitem;
import order.entity.Orders;
import org.hibernate.criterion.Order;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import product.entity.Product;
import user.entity.User;

import java.sql.Timestamp;
import java.util.*;

/**
 * Created by zhangbaoning on 2017/5/31.
 */
public class OrderService {
    ItemDao itemDao;

    public void setItemDao(ItemDao itemDao) {
        this.itemDao = itemDao;
    }



    public void commitOrder(Cart cart, User user) {
        //将cart里面的商品添加到订单里面
        //订单添加用户
        //新建一个订单
        Orderitem orderitem = new Orderitem();
        Orders orders = new Orders();
        orders.setOrdertime(new Timestamp(new Date().getTime()));
        orders.setUser(user);
        Collection collection = cart.getCollection();
        Iterator<CartItem> it = collection.iterator();
        while (it.hasNext()) {
            CartItem cartItem = it.next();
            Product product =cartItem.getProduct();
            orderitem.setCount(cartItem.getCount());//设置数量
            orderitem.setSubtotal(cartItem.getItem_total());//设置总价
            orderitem.setProduct(product);
            orderitem.setOrders(orders);
            itemDao.itemSave(orderitem);
        }
    }

}
