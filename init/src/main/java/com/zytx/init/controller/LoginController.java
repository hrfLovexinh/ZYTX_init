package com.zytx.init.controller;

import com.zytx.init.domain.ElevatorInfo;
import com.zytx.init.domain.User;
import com.zytx.init.service.ElevatorService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class LoginController {

    private Logger logger = LoggerFactory.getLogger(LoginController.class);


    @Autowired
    private ElevatorService elevatorService;

    @ResponseBody
    @RequestMapping(value="/userlogin")
    public String userLogin(Model model, User user, HttpServletResponse response){
        if(user==null){return "login";}
        String account=user.getUsername();
        String password=user.getPassword();
        UsernamePasswordToken token = new UsernamePasswordToken(account,password,false);
        Subject currentUser = SecurityUtils.getSubject();
        try {
            currentUser.login(token);
            //此步将 调用realm的认证方法
        } catch(IncorrectCredentialsException e){
            //这最好把 所有的 异常类型都背会
            return "failer";
        } catch (AuthenticationException e) {
            return "failer";
        }
        return "success";
    }


}
