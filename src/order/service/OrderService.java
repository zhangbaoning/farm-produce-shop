package order.service;

import cart.entity.Cart;
import cart.entity.CartItem;
import item.dao.ItemDao;
import item.entity.Orderitem;
import order.dao.OrderDao;
import order.entity.Orders;
import org.hibernate.criterion.Order;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import product.entity.Product;
import user.entity.User;
import utils.PageBean;

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


    /**
     * 提交订单 只保存购物车数据到数据库
     *
     * @param cart 购物车
     * @param user 购买车
     */
    public void commitOrder(Cart cart, User user) {
        //将cart里面的商品添加到订单里面
        //订单添加用户
        //新建一个订单
        Orderitem orderitem = new Orderitem();
        Orders orders = new Orders();
        orders.setOrdertime(new Timestamp(new Date().getTime()));
        orders.setUser(user);
        orders.setAddr(user.getAddr());
        orders.setPhone(user.getPhone());
        orders.setName(user.getName());
        orders.setState(0); //提交订单未付款
        orders.setTotal(cart.getCart_total());
        Collection collection = cart.getCollection();
        Iterator<CartItem> it = collection.iterator();
        while (it.hasNext()) {
            //迭代将购物车的数据存在数据库中
            CartItem cartItem = it.next();
            Product product = cartItem.getProduct();
            orderitem.setCount(cartItem.getCount());//设置数量
            orderitem.setSubtotal(cartItem.getItem_total());//设置总价
            orderitem.setProduct(product);
            orderitem.setOrders(orders);
            System.out.println(orders);
            itemDao.itemSave(orderitem);
        }
    }

    /**
     * @param page 分页当前的页数
     * @return 包含分页信息
     */
    public PageBean adminGetListByPage(int page) {
        PageBean pageBean = new PageBean();
        int total = orderDao.getTotalCount();
        pageBean.setTotalCount(total); //所有的记录数
        int totalPage = (int) Math.ceil(total * 1.0 / pageBean.getLimit());
        pageBean.setTotalPage(totalPage); //总页数
        pageBean.setPage(page); //当前页数
        int start = (page - 1) * pageBean.getLimit();
        List list = orderDao.adminGetListByPage(pageBean, start);
        pageBean.setList(list);     //通过数据库查出来的总记录数
        return pageBean;
    }

    OrderDao orderDao;

    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    public void save(Orders orders) {
        orderDao.save(orders);
    }

    /**
     * 通过订单ID查询到所买的商品
     * @param oid 需要查询的订单ID
     * @return　商品集合
     */
    public List adminOrderListById(Integer oid) {
        return orderDao.getProductByOid(oid);

    }
}
