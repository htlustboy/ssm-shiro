package ssm.shiro;/**
 * Created by taohu on 2019/10/17.
 */

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author lustboy
 * @prpgram ssm-shiro
 * @description 日志测试
 * @create 2019/10/17 09:44:01
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class LogTest {

    private static Logger logger = LoggerFactory.getLogger(LogTest.class);

    @Test
    public void logTest(){
        logger.debug("debug log");
        logger.info("info log");
        logger.warn("warn log");
        logger.error("error log");
    }
}
