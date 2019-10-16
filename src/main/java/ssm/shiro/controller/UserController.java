package ssm.shiro.controller;/**
 * Created by taohu on 2019/10/16.
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import ssm.shiro.entity.User;
import ssm.shiro.service.UserService;
import ssm.shiro.util.BaseUtil;

import javax.annotation.Resource;

/**
 * @author taohu@maxxipoint.com
 * @prpgram ssm-shiro
 * @description 用户请求入口
 * @create 2019/10/16 09:54:58
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Resource
    UserService userService;

    /**
     * 查询用户
     *
     * @return
     */
    @RequestMapping("/findUser")
    public Object findUser(@RequestParam("id") String id) {
        logger.debug("开始调用userController~~~finUser接口~~~~~~");
        if (StringUtils.isEmpty(id)) {
            return "id不能为null！";
        }
        return userService.getUserById(id);
    }

    /**
     * 新增用户
     *
     * @param user
     * @return
     */
    @RequestMapping("/addUser")
    public Object addUser(@RequestParam(value = "user", required = false) User user) {
        if (user == null) {
            user = initUser();
        }
        Integer result = userService.addUser(user);
        if (result == -1) {
            return "新增用户失败，该用户已经存在！";
        } else if (result == 1) {
            return "新增成功！";
        } else {
            return "error:系统错误！";
        }
    }

    /**
     * 根据id删除记录
     * @param id
     * @return
     */
    @RequestMapping("/deleteUserById")
    public Object deleteUser(@RequestParam("id") String id){
        Integer result = userService.deleteUserById(id);
        if(result==1){
            return "删除成功！";
        }
        return "删除失败！";
    }

    private User initUser() {
        User user = new User();
        user.setId(BaseUtil.uuid());
        user.setUsername("lustboy");
        user.setAge(21);
        user.setPassword("2e19f9ce2ae54332961ba3a000c275b3");
        return user;
    }
}
