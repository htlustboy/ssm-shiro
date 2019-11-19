package ssm.shiro.controller.view;/**
 * Created by taohu on 2019/10/17.
 */

import lombok.extern.log4j.Log4j2;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;
import ssm.shiro.controller.BaseController;

/**
 * @author taohu@maxxipoint.com
 * @prpgram ssm-shiro
 * @description
 * @create 2019/10/17 10:20:00
 */
@Log4j2
@Controller
@RequestMapping("/login")
public class LoginController{

    /**
     * 首页
     *
     * @return
     */
    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    /**
     * 登陆操作
     *
     * @param username
     * @param password
     * @return
     */
    @RequestMapping("/login")
    public Object login(@RequestParam("username") String username, @RequestParam("password") String password, RedirectAttributesModelMap model) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            subject.login(token);
        } catch (UnknownAccountException uae) {
            model.addFlashAttribute("errorMessage","未知账户");
        } catch (IncorrectCredentialsException ice) {
            model.addFlashAttribute("errorMessage","密码不正确");
        } catch (LockedAccountException lae) {
            model.addFlashAttribute("errorMessage","账户已锁定");
        } catch (ExcessiveAttemptsException eae) {
            model.addFlashAttribute("errorMessage","用户名或密码错误次数过多");
        } catch (AuthenticationException ae) {
            model.addFlashAttribute("errorMessage","用户名或密码不正确！");
        }
        if (subject.isAuthenticated()) {
            model.addFlashAttribute("errorMessage","登陆成功");
        } else {
            token.clear();
            if(model.getFlashAttributes().get("errorMessage")==null){
                model.addFlashAttribute("errorMessage","登陆失败");
            }
            model.addFlashAttribute("username",username);
            model.addFlashAttribute("password",password);
        }
        return "redirect:index";
    }

    /**
     * 注销
     *
     * @return
     */
    @RequestMapping("/logout")
    public Object logout(RedirectAttributesModelMap model) {
        Subject subject = SecurityUtils.getSubject();
        if (subject != null) {
            subject.logout();
        }
        model.addFlashAttribute("errorMessage","注销成功");
        return "index";
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
