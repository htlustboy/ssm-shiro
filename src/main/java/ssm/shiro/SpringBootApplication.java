package ssm.shiro;/**
 * Created by taohu on 2019/10/16.
 */

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;

import javax.swing.*;

/**
 * @author taohu@maxxipoint.com
 * @prpgram ssm-shiro
 * @description 启动类
 * @create 2019/10/16 09:39:01
 */
@org.springframework.boot.autoconfigure.SpringBootApplication
@MapperScan("ssm.shiro.mapper")
public class SpringBootApplication {

    private static Logger logger = LoggerFactory.getLogger(SpringBootApplication.class);

    public static void main(String[] args){
        logger.info("running ssm-shiro application ...");

        SpringApplication.run(SpringBootApplication.class,args);

        logger.info("started ssm-shiro application successful ...");
    }
}
