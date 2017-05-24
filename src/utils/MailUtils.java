package utils;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Created by zhangbaoning on 2017/5/24.
 */
public class MailUtils {
    public static void sendMail(String toUser,String code)  {
        //1.获得连接对象
        Properties properties = new Properties(); //Properties 可保存在流中或从流中加载。属性列表中每个键及其对应值都是一个字符串。
        properties.setProperty("mail.host","139.199.22.21");
        Session session = Session.getInstance(properties, new Authenticator() {//通过host地址和验证创建session
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                //将账号，密码进行封装
                return new PasswordAuthentication("admin","zhangbaoning");
            }
        });
        //2.创建邮件
        Message message = new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress("admin@zhangbaoning.cn")); //发送者的账号
            message.setRecipient(Message.RecipientType.TO,new InternetAddress(toUser));//接收人的账号，及发送方式
            message.setSubject("激活码验证");//主题

            message.setContent( //内容
                    "<a href='127.0.0.1:8080/user_active.action?code="+code+"'>http://127.0.0.1:8080/user_active.action?code="+code+"</a>"
                    ,"text/html;charset=utf-8");
            Transport.send(message); //发送
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MailUtils.sendMail("zhangbaoning@vip.qq.com","7758");
    }
}
