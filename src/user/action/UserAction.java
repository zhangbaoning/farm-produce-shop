package user.action;

import com.google.code.kaptcha.Constants;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;
import user.entity.User;
import user.service.UserService;
import utils.MailUtils;
import utils.UUIDUtils;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by zhangbaoning on 2017/5/23.
 */

public class UserAction extends ActionSupport implements ModelDriven<User> {
    UserService userService;
    User user = new User();
    String captcha;

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public User getModel() {
        return user;
    }


    public String registerPage() {
        return "registerPage";
    }

    public String findByUsername() throws IOException {
        //TODO 查看HttpServletResponse
        HttpServletResponse response = ServletActionContext.getResponse();
        User exist = userService.findByUsername(user.getUsername());
        response.setContentType("text/html;charset=utf-8");
        if (exist == null) {
            response.getWriter().println("<font color='green'>用户名可用</font>");
        } else {
            response.getWriter().println("<font color='red'>用户名不可用</font>");
        }
        return NONE;
    }

    public String register() {
        String kaptcha = (String) ActionContext.getContext().getSession().get(Constants.KAPTCHA_SESSION_KEY);
        if (!kaptcha.equalsIgnoreCase(captcha)) {
            addActionError("验证码错误");
            return INPUT;
        } else {
            user.setCode(UUIDUtils.getUUID());
            user.setState(0); //初始没激活
            userService.register(user);
            MailUtils.sendMail(user.getEmail(), user.getCode());
            return "msg";
        }
    }

    public String active() {
        //用激活链接中的激活码找到用户
        User get_user = userService.findByCode(user.getCode());
        //获得用户对象
        //将激活码设置为空，状态设置为1（激活），并更新对象
        get_user.setState(1);
        get_user.setCode(null);
        userService.update(get_user);
        addActionMessage("激活成功");
        return "msg";
    }

    public String loginPage() {
        User login_user = userService.findBylogin(user.getUsername(), user.getPassword());
        if (login_user != null) {
            HttpSession session = ServletActionContext.getRequest().getSession();
            session.setAttribute("user", login_user);
//            ActionContext.getContext().getSession().put("user",login_user);
            return SUCCESS;
        } else {
            addActionError("登陆错误");
            return "loginPage";
        }

    }

    public String logout() {
        ServletActionContext.getRequest().getSession().invalidate();
        return SUCCESS;
    }

    public String findAll() {
        List list = this.userService.getAll();
        ActionContext.getContext().getSession().put("user_list", list);
        return "user_list";
    }

    /**
     * 后台更新用户
     * @return 返回值要重定向到action
     */
    public String update() {
        this.userService.update(user);
        return "update_success";
    }

    /**
     * 在后台用户编辑
     *
     * @return name of struts2 's
     */
    public String adminEdit() {
        //根据传进来的uid获得对象保存在模型驱动中model中
        user = this.userService.getByUid(user.getUid());
        return "user_edit_page";
    }

    /**
     *
     * @return 删除后和更新的返回界面相同
     */
    public String adminDel(){
        userService.del(user.getUid());
        return "update_success";
    }
}

