package admin.entity;

/**
 * Created by zhangbaoning on 2017/6/3.
 */
public class Adminuser {
    private int uid;
    private String username;
    private String password;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Adminuser adminuser = (Adminuser) o;

        if (uid != adminuser.uid) return false;
        if (username != null ? !username.equals(adminuser.username) : adminuser.username != null) return false;
        if (password != null ? !password.equals(adminuser.password) : adminuser.password != null) return false;

        return true;
    }

    @Override
    public String toString() {
        return "Adminuser{" +
                "uid=" + uid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        int result = uid;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }
}
