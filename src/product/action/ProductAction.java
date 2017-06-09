package product.action;

import category.entity.Categorysecond;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import product.entity.Product;
import product.servcie.ProductService;
import utils.PageBean;
import category.service.CategorysercondService;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by zhangbaoning on 2017/5/26.
 */
public class ProductAction extends ActionSupport implements ModelDriven<Product>{
    Product product = new Product();
    ProductService productService;
    CategorysercondService categorysecondService;
    Categorysecond categorysecond;

    public Categorysecond getCategorysecond() {
        return categorysecond;
    }

    public void setCategorysecond(Categorysecond categorysecond) {
        this.categorysecond = categorysecond;
    }

    public void setCategorysecondService(CategorysercondService categorysecondService) {
        this.categorysecondService = categorysecondService;
    }

    int page=1;   //显示第几页,初始化的时候为1

    public void setPage(int page) {
        this.page = page;
    }

    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    public String getById(){
        product = productService.getById(product.getPid());
        return "getById";
    }

    @Override
    public Product getModel() {
        return product;
    }

    /**
     * 通过分页将商品显示出来
     * @return
     */
    public String adminGetByPage(){
        PageBean pageBean = productService.getByPage(page);
        ActionContext.getContext().getValueStack().set("pageBean",pageBean);
        return "adminGetByPage";
    }

    public String adminDel(){
        productService.del(product.getPid());
        return "adminDel";
    }
    /**
     *
     * @return 商品添加页面
     */
    public String adminAddPage(){
        List list = categorysecondService.getAllCategorysecond();
        System.out.println(list);
        ActionContext.getContext().getValueStack().set("csList",list);
        return "adminAddPage";
    }

    /**
     * 商品添加
     * @return
     */
    private File uploadFile;

    public void setUploadFileFileName(String uploadFileFileName) {
        this.uploadFileFileName = uploadFileFileName;
    }

    private String uploadFileFileName;
    private String uploadFileContentType;



    public void setUploadFileContentType(String uploadFileContentType) {
        this.uploadFileContentType = uploadFileContentType;
    }


    public void setUploadFile(File uploadFile) {
        this.uploadFile = uploadFile;
    }

    public String adminAdd() throws IOException {
        //TODO 不能选择二级分类
        categorysecond =categorysecondService.get(categorysecond.getCsid());
        String path = ServletActionContext.getServletContext().getRealPath("/products");
        File saveFile = new File(path+"//"+uploadFileFileName);
        FileUtils.copyFile(uploadFile,saveFile);
        //模型驱动会传进来包含各种值的对象，只需要给对象添加图片地址
        product.setImage("products//"+uploadFileFileName);
        product.setCategorysecond(categorysecond);
        productService.save(product);
        return "adminAdd";

    }
    /**
     *
     * @return 商品添加页面
     */
    public String adminEditPage(){
        List list = categorysecondService.getAllCategorysecond();
        ActionContext.getContext().getValueStack().set("csList",list);
        product = productService.getById(product.getPid());
        return "adminEditPage";
    }
    public String adminEdit(){
        product.setCategorysecond(categorysecond);
        productService.update(product);
        return "adminEdit";
    }
}
