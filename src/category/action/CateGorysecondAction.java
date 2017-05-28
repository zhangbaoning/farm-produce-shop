package category.action;

import category.service.CategorysercondService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import utils.PageBean;

/**
 * Created by zhangbaoning on 2017/5/26.
 */
public class CateGorysecondAction extends ActionSupport {
    int csid;
    int page =1; //默认第一页

    public int getCsid() {
        return csid;
    }

    public void setCsid(int csid) {
        this.csid = csid;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    CategorysercondService categorysercondService;

    public void setCategorysercondService(CategorysercondService categorysercondService) {
        this.categorysercondService = categorysercondService;
    }

    public String getProductByCs(){
        PageBean pageBean  = categorysercondService.getProductByCs(csid,page);
        ActionContext.getContext().getValueStack().set("pageBean",pageBean);
        ActionContext.getContext().getValueStack().set("csid",csid);
        return "menueDetails";
    }
}
