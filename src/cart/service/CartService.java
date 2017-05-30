package cart.service;

import cart.entity.Cart;
import cart.entity.CartItem;
import com.opensymphony.xwork2.ActionContext;
import product.dao.ProductDao;
import product.entity.Product;

/**
 * Created by zhangbaoning on 2017/5/29.
 */
public class CartService {
    ProductDao productDao;
    Cart cart;
    CartItem cartItem;

    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }

    public Cart cartPage(Integer pid, Integer count) {
        //向里面添加的时候，查看里面是否已存在
        Product product = productDao.getById(pid);
        //先判断seesion是否存在cart,没有的话新建
        if (ActionContext.getContext().getSession().containsKey("all_item")) {
            cart = (Cart) ActionContext.getContext().getSession().get("cart");
            //判断Map里面是否存在pid，存在的话说明购物车里面已经存在这个货物
            if (cart.getAll_item().containsKey(pid)) {
                //只需给item里面的数量加一就可以了
                cartItem = cart.getAll_item().get(pid);
//                cartItem.setCount(1);
            }
            else {
                cartItem = new CartItem();
            }
        } else {
            cart = new Cart();
            cartItem = new CartItem();

        }
        System.out.println(count);
        cartItem.setProduct(product, count);
        cart.add_item(product.getPid(), cartItem);
        return cart;
    }
}
