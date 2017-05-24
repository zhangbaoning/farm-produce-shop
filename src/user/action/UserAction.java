package user.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import user.entity.User;
import user.service.UserService;
import utils.MailUtils;
import utils.UUIDUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by zhangbaoning on 2017/5/23.
 */

public class UserAction extends ActionSupport implements ModelDriven<User> {
    UserService userService;
    User user = new User();

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
        User exist =userService.findByUsername(user.getUsername());
        response.setContentType("text/html;charset=utf-8");
        if (exist==null){
            response.getWriter().println("<font color='green'>用户名可用</font>");
        }else {
            response.getWriter().println("<font color='red'>用户名不可用</font>");
        }
        return NONE;
    }
    public String register(){
        user.setCode(UUIDUtils.getUUID());
        user.setState(0); //初始没激活
        userService.register(user);
        MailUtils.sendMail(user.getEmail(),user.getCode());
        return "msg";
    }
    public String active(){
        return NONE;
    }
}

