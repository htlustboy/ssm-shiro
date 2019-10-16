package ssm.shiro.controller;/**
 * Created by taohu on 2019/10/16.
 */

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ssm.shiro.service.UserService;

import javax.annotation.Resource;

/**
 * @author taohu@maxxipoint.com
 * @prpgram ssm-shiro
 * @description 登陆入口
 * @create 2019/10/16 16:18:49
 */
@RestController
@RequestMapping("/login")
public class LoginController {

    private static Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Resource
    UserService userService;

    /**
     * 首页
     *
     * @return
     */
    @RequestMapping("/index")
    public Object index() {
        return "请登录后再操作！";
    }

    /**
     * 登陆操作
     *
     * @param username
     * @param password
     * @return
     */
    @RequestMapping("/login")
    public Object login(@RequestParam("username") String username, @RequestParam("password") String password) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            subject.login(token);
        } catch (UnknownAccountException uae) {
            return "未知账户";
        } catch (IncorrectCredentialsException ice) {
            return "密码不正确";
        } catch (LockedAccountException lae) {
            return "账户已锁定";
        } catch (ExcessiveAttemptsException eae) {
            return "用户名或密码错误次数过多";
        } catch (AuthenticationException ae) {
            return "用户名或密码不正确！";
        }
        if (subject.isAuthenticated()) {
            return "登录成功";
        } else {
            token.clear();
            return "登录失败";
        }
    }

    /**
     * 注销
     *
     * @return
     */
    @RequestMapping("/logout")
    public Object logout() {
        Subject subject = SecurityUtils.getSubject();
        if (subject != null) {
            subject.logout();
        }
        return "注销成功！";
    }

    /**
     * 权限不足
     *
     * @return
     */
    @RequestMapping("/notRole")
    public Object notRole() {
        return "访问失败:没有权限！";
    }
}
