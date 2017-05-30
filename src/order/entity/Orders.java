package order.entity;

import java.sql.Timestamp;

/**
 * Created by zhangbaoning on 2017/5/30.
 */
public class Orders {
    private int oid;
    private Double total;
    private Timestamp ordertime;
    private Integer state;
    private String name;
    private String phone;
    private String addr;

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Timestamp getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(Timestamp ordertime) {
        this.ordertime = ordertime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Orders orders = (Orders) o;

        if (oid != orders.oid) return false;
        if (total != null ? !total.equals(orders.total) : orders.total != null) return false;
        if (ordertime != null ? !ordertime.equals(orders.ordertime) : orders.ordertime != null) return false;
        if (state != null ? !state.equals(orders.state) : orders.state != null) return false;
        if (name != null ? !name.equals(orders.name) : orders.name != null) return false;
        if (phone != null ? !phone.equals(orders.phone) : orders.phone != null) return false;
        if (addr != null ? !addr.equals(orders.addr) : orders.addr != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = oid;
        result = 31 * result + (total != null ? total.hashCode() : 0);
        result = 31 * result + (ordertime != null ? ordertime.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (addr != null ? addr.hashCode() : 0);
        return result;
    }
}
