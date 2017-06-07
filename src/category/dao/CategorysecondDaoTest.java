package category.dao;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import utils.PageBean;

import static org.junit.Assert.*;

/**
 * Created by zhangbaoning on 2017/6/7.
 */
public class CategorysecondDaoTest {
    CategorysecondDao categorysecondDao;
    @Before
    public void setUp() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("/spring.xml");
        categorysecondDao = (CategorysecondDao) context.getBean("categorysecondDao");
    }

    @Test
    public void getCount() throws Exception {
        System.out.println(categorysecondDao.getCount());
    }

    @Test
    public void getAll() throws Exception {
        PageBean pageBean = new PageBean();
        pageBean.setPage(1);
        pageBean.setTotalCount(26);
        System.out.println(categorysecondDao.getAll(pageBean));
    }


}