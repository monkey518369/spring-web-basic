package com.monkey.controller.system;

import com.monkey.entity.system.account.Account;
import com.monkey.util.common.AjaxRes;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/")
public class LoginController {

    private static final Logger log = LoggerFactory.getLogger(LoginController.class.getName());

    @RequestMapping("index")
    public String index(HttpServletRequest request){

        log.info("siAsyncSupported:{}",request.isAsyncSupported());
        /*AsyncContext context = request.startAsync();*/

        return "index";
    }

    @RequestMapping(value = "login",method = RequestMethod.POST)
    @ResponseBody
    public AjaxRes login(Account account){

        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(account.getLoginName(),account.getPassword());

        subject.login(token);

        Session session = subject.getSession();

        session.setAttribute("name","monkey");

        session.stop();

        subject.hasRole("ca");

        return null;
    }

}
