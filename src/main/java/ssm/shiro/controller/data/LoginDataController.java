package ssm.shiro.controller.data;/**
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
 * @author lustboy
 * @prpgram ssm-shiro
 * @description 登陆入口
 * @create 2019/10/16 16:18:49
 */
@RestController
@RequestMapping("/login")
public class LoginDataController {


}
