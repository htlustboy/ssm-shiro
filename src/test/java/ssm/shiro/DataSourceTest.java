package ssm.shiro;/**
 * Created by taohu on 2019/10/16.
 */

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * @author taohu@maxxipoint.com
 * @prpgram ssm-shiro
 * @description 测试用例
 * @create 2019/10/16 10:21:54
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DataSourceTest {

    @Resource
    Environment environment;

    @Resource
    ApplicationContext applicationContext;

    @Test
    public void dataSourceTest() {
        DataSource dataSource = applicationContext.getBean(DataSource.class);
        System.out.println("=======>>>>>>>>:" + dataSource);
    }
}
