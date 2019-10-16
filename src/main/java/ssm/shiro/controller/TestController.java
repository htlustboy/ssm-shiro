package ssm.shiro.controller;/**
 * Created by taohu on 2019/10/16.
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author taohu@maxxipoint.com
 * @prpgram ssm-shiro
 * @description 测试
 * @create 2019/10/16 09:45:38
 */
@RestController
@RequestMapping("/test")
public class TestController {

    private static Logger logger = LoggerFactory.getLogger(TestController.class);

    /**
     * 测试springMVC是否正常
     * @return
     */
    @RequestMapping("/doTest")
    public String test(){
        return "if you see this message,that mean you started mvc application successful~~~";
    }

}
