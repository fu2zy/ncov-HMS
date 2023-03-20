package com.example.ncov.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.CircleCaptcha;
import cn.hutool.captcha.LineCaptcha;
import com.example.ncov.entity.User;
import com.example.ncov.service.UserService;
import com.example.ncov.vb.DataView;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    @RequestMapping("/toLogin")
    public String toLogin(){
        return "login";
    }

    /**
     * 生成验证码
     * */
    @RequestMapping("/login/getCode")
    //利用HttpServletResponse获得response输出验证码页面，并存放到session
    public void getCode(HttpServletResponse response, HttpSession session) throws IOException {
        //验证码对象,生成高，宽，位数，遮挡条数
//        CircleCaptcha circleCaptcha = CaptchaUtil.createCircleCaptcha(116, 36, 4, 6);
        LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(116,36,4,18);
        //存入session,用于前端与后端比对
        session.setAttribute("code",lineCaptcha.getCode());
        //输出验证码
        ServletOutputStream outputStream = response.getOutputStream();
        //把文件输出流写出
        lineCaptcha.write(outputStream);
        //关闭输出流
        outputStream.close();
    }

    /**
     * 提交username password以及验证码
     * */
    @RequestMapping("/login/login")
    @ResponseBody
    //用DataView返回类型可得到登录消息
    public DataView login(String username,String password,String code,HttpSession session){
        DataView dataView = new DataView();
        //判断验证码
        String sessionCode = (String) session.getAttribute("code");
        if (code!=null && sessionCode.equals(code)){
            //session登录逻辑,创建login方法
//            User user = userService.login(username,password);

            //shiro登录逻辑,用Subject方法
            Subject subject = SecurityUtils.getSubject();
            //使用token登录,从前台取得username, password变量返回到token
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            try {
                subject.login(token);
                //通过getPrincipal取得用户信息返回到user
                User user = (User) subject.getPrincipal();
                if (user!=null){
                    //若登录不为空，转换页面前放入session存放user
                    session.setAttribute("user",user);
                    dataView.setCode(200);
                    dataView.setMsg("登录成功");
                    return dataView;
                }
            }catch (UnknownAccountException e){
                dataView.setCode(100);
                dataView.setMsg("登录失败,帐号错误");
                System.out.println("Wrong Account");
                return dataView;
            }catch (IncorrectCredentialsException e){
                dataView.setCode(100);
                dataView.setMsg("登录失败,密码错误");
                System.out.println("Wrong Password");
                return dataView;
            }
//            catch (AuthenticationException e){
//                dataView.setCode(100);
//                dataView.setMsg("登录失败,验证码错误");
//                return dataView;
//            }

//            //判断登录
//            if (user!=null){
//                //若登录不为空，转换页面前放入session存放user
//                session.setAttribute("user",user);
//                dataView.setCode(200);
//                dataView.setMsg("登录成功");
//                return dataView;
//            }
//            else {
//                dataView.setCode(100);
//                dataView.setMsg("登录失败,用户密码错误");
//                return dataView;
//            }
        }
        dataView.setCode(100);
        dataView.setMsg("登录失败,验证码错误");
        return dataView;
    }
    /**
     * 登出
     * */
    @RequestMapping("/login/logout")
    public String logout(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "login";

    }
}
