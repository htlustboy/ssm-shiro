package ssm.shiro.controller.view;/**
 * Created by taohu on 2019/10/17.
 */

import lombok.extern.log4j.Log4j2;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
public class LoginController extends BaseController{

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
     * @return
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Object login(RedirectAttributesModelMap model) {
        String username = this.getRequest().getParameter("username");
        String password = this.getRequest().getParameter("password");
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
            this.getRequest().getSession().setAttribute("user",subject);
            return "list";
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
