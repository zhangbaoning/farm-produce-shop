package cart.action;

import cart.entity.Cart;
import cart.service.CartService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by zhangbaoning on 2017/5/29.
 */
public class CartAction extends ActionSupport {
    Integer pid;
    Integer count;//件数

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    CartService cartService;

    public void setCartService(CartService cartService) {
        this.cartService = cartService;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }
    public String cartPage(){
        return "cartPage";

    }
    public String addCart() throws Exception {
        //将得到的Pid出入service层，查找出这个商品
        Cart cart = cartService.cartPage(pid,count);
        ActionContext.getContext().getSession().put("all_item",cart.getCollection());
        ActionContext.getContext().getSession().put("cart",cart);
        return "cartPage";
    }
    public String clear(){
        Cart cart = (Cart) ActionContext.getContext().getSession().get("cart");
        cart.getAll_item().clear();
        //总价置零
        cart.setCart_total(0);
        return "cartPage";
    }
}
