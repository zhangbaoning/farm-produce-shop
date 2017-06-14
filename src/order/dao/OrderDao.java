package order.dao;

import order.entity.Orders;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import utils.PageBean;
import utils.PageHibernateCallBack;

import java.util.List;

/**
 * Created by zhangbaoning on 2017/6/9.
 */
public class OrderDao extends HibernateDaoSupport {

    public List adminGetListByPage(PageBean pageBean, int start) {
        String hql = "FROM Orders";
        List list = this.getHibernateTemplate().executeFind(
                new PageHibernateCallBack(hql, pageBean.getLimit(),
                        null, start)
        );
        return list;
    }

    public int getTotalCount() {
        String hql = "SELECT COUNT(orders.oid)FROM Orders orders";
        List<Long> list = this.getHibernateTemplate().find(hql);
        return list.get(0).intValue();
    }
    public void save(Orders orders){
        this.getHibernateTemplate().save(orders);
    }
    public Orders get(Integer oid){
        return this.getHibernateTemplate().get(Orders.class,oid);
        //TODO 改名
    }
    public List getProductByOid(Integer oid){
        String hql = "SELECT i FROM Orderitem i WHERE i.orders.id=?";
        List list = this.getHibernateTemplate().find(hql,oid);
        return list;
    }

    /**
     * 订单数据库的测试方法
     * @param args
     */
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("/spring.xml");
        OrderDao dao = (OrderDao) context.getBean("orderDao");

    }
}
