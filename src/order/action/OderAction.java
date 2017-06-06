package order.action;

import cart.entity.Cart;
import com.opensymphony.xwork2.ActionContext;
import order.service.OrderService;
import user.entity.User;

/**
 * Created by zhangbaoning on 2017/5/30.
 */
public class OderAction {
    OrderService orderService;

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
}
