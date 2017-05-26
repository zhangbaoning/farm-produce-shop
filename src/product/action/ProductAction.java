package product.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import product.entity.Product;
import product.servcie.ProductService;

/**
 * Created by zhangbaoning on 2017/5/26.
 */
public class ProductAction extends ActionSupport implements ModelDriven<Product>{
    Product product = new Product();
    ProductService productService;

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
}
