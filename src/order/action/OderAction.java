package order.action;

import cart.entity.Cart;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.sun.mail.imap.protocol.Item;
import item.entity.Orderitem;
import order.entity.Orders;
import order.service.OrderService;
import product.entity.Product;
import user.entity.User;
import utils.PageBean;

import java.util.Iterator;
import java.util.List;

/**
 * Created by zhangbaoning on 2017/5/30.
 */
public class OderAction extends ActionSupport implements ModelDriven<Orders>{
    long time;

    public void setTime(long time) {
        this.time = time;
    }

    OrderService orderService;
    int page = 1; //默认显示第一页
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    public String page() {
        User user = (User) ActionContext.getContext()
                .getSession().get("user");
        if (user!=null){
            //从session拿出在购物车保存的产品
            Cart cart = (Cart) ActionContext.getContext()
                    .getSession().get("cart");

            //将cart传到service层
            orderService.commitOrder(cart,user);
            return "orderPage";
        }else
        {
            return "loginPage";
        }

    }

    /**
     * 后台通过分页跳转全部订单页面
     * @return
     */
    public String adminGetListByPage(){
        PageBean pageBean = orderService.adminGetListByPage(page);
        ActionContext.getContext().getValueStack().set("pageBean",pageBean);
        return "adminListPage";
    }

    /**
     * 订单支付
     * 将订单数据保存
     * @return
     */
    public String payOrder(){
        orderService.save(orders);
     return "payOrder";
    }
    Orders orders = new Orders();
    @Override
    public Orders getModel() {
        return orders;
    }

    /**
     * 在后台订单页面点击显示订单包含的商品
     * @return
     */
    public String adminOrderListById(){
        List<Orderitem> list = orderService.adminOrderListById(orders.getOid());
        ActionContext.getContext().getValueStack().set("product_list",list);
        Iterator<Orderitem> it = list.iterator();
        while (it.hasNext()){
            Orderitem output = it.next();
            System.out.println(output.toString());
        }
        System.out.println(list.toString());
        return "adminOrderListById";
    }
}
