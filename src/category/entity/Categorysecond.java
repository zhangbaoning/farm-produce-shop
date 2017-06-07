package category.entity;

import product.entity.Product;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by zhangbaoning on 2017/5/25.
 */
public class Categorysecond implements Serializable {
    @Override
    public String toString() {
        return "Categorysecond{" +
                "csid=" + csid +
                ", csname='" + csname + '\'' +
                ", productSet=" + productSet +
                ", category=" + category +
                '}';
    }

    private int csid;
    private String csname;
    Set<Product> productSet = new HashSet<Product>();

    public Set<Product> getProductSet() {
        return productSet;
    }

    public void setProductSet(Set<Product> productSet) {
        this.productSet = productSet;
    }

    public int getCsid() {
        return csid;
    }

    public void setCsid(int csid) {
        this.csid = csid;
    }

    public String getCsname() {
        return csname;
    }

    public void setCsname(String csname) {
        this.csname = csname;
    }
    private Category category;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Categorysecond that = (Categorysecond) o;

        if (csid != that.csid) return false;
        if (csname != null ? !csname.equals(that.csname) : that.csname != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = csid;
        result = 31 * result + (csname != null ? csname.hashCode() : 0);
        return result;
    }
}
