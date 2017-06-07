package category.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by zhangbaoning on 2017/5/25.
 */
public class Category implements Serializable{
    private int cid;
    private String cname;
    private Set<Categorysecond> categorysecondSet = new HashSet<>();
    public int getCid() {
        return cid;
    }

    public Set<Categorysecond> getCategorysecondSet() {
        return categorysecondSet;
    }

    public void setCategorysecondSet(Set<Categorysecond> categorysecondSet) {
        this.categorysecondSet = categorysecondSet;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Category category = (Category) o;

        if (cid != category.cid) return false;
        if (cname != null ? !cname.equals(category.cname) : category.cname != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = cid;
        result = 31 * result + (cname != null ? cname.hashCode() : 0);
        return result;
    }
}
