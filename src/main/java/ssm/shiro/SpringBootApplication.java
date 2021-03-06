package ssm.shiro;/**
 * Created by taohu on 2019/10/16.
 */

import lombok.extern.log4j.Log4j2;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;

import javax.swing.*;

/**
 * @author lustboy
 * @prpgram ssm-shiro
 * @description 启动类
 * @create 2019/10/16 09:39:01
 */
@org.springframework.boot.autoconfigure.SpringBootApplication
@MapperScan("ssm.shiro.mapper")
@Log4j2
public class SpringBootApplication {


    public static void main(String[] args){
        log.info("running ssm-shiro application ...");

        SpringApplication.run(SpringBootApplication.class,args);

        log.info("started ssm-shiro application successful ...");
    }
}
