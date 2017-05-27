package utils;

import java.util.List;

/**
 * Created by zhangbaoning on 2017/5/27.
 */
public class PageBean {
    private int page; //当前页数
    private int totalPage; //总页数
    private int totalCount; //总记录数
    private int limit = 12; //每页显示的记录数
    private List list; //每页的数据集合

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "PageBean{" +
                "page=" + page +
                ", totalPage=" + totalPage +
                ", totalCount=" + totalCount +
                ", limit=" + limit +
                ", list=" + list +
                '}';
    }
}
