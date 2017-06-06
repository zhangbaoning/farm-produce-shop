package item.dao;

import cart.entity.CartItem;
import item.entity.Orderitem;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * Created by zhangbaoning on 2017/5/31.
 */
public class ItemDao extends HibernateDaoSupport{
    public void itemSave(Orderitem orderitem){
        this.getHibernateTemplate().save(orderitem);
    }
}
