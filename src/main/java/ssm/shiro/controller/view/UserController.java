package ssm.shiro.controller.view;/**
 * Created by taohu on 2019/11/20.
 */

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ssm.shiro.controller.BaseController;
import ssm.shiro.entity.User;
import ssm.shiro.pager.Pager;
import ssm.shiro.service.UserService;
import ssm.shiro.util.BaseUtil;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author taohu@maxxipoint.com
 * @prpgram ssm-shiro
 * @description
 * @create 2019/11/20 10:50:35
 */
@Log4j2
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

    @Resource
    UserService userService;

    @RequestMapping("/list")
    public String list(Model model) {
        String displayName = this.getRequest().getParameter("displayName");
        String pageNo = this.getRequest().getParameter("pageNo");
        if(StringUtils.isEmpty(pageNo)){
            pageNo = "1";
        }
        Pager pager = new Pager(Integer.parseInt(pageNo));
        if(!StringUtils.isEmpty(displayName)){
            pager.getSearchInfo().put("displayName",displayName);
        }
        List<User> userList = userService.getUserList(pager);
        pager.setResult(userList);
        int start = (Integer.parseInt(pageNo) - 1) * pager.getPageSize();
        int end = start+ pager.getPageSize();
        model.addAttribute("pager",pager);
        model.addAttribute("userList", BaseUtil.subList(start,end,userList));
        return "user";
    }
}
