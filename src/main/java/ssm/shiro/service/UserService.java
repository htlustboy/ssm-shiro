package ssm.shiro.service;/**
 * Created by taohu on 2019/10/16.
 */

import lombok.extern.log4j.Log4j2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ssm.shiro.entity.User;
import ssm.shiro.mapper.UserMapper;

import javax.annotation.Resource;

/**
 * @author taohu@maxxipoint.com
 * @prpgram ssm-shiro
 * @description
 * @create 2019/10/16 09:52:54
 */
@Service
@Log4j2
public class UserService {

    @Resource
    private UserMapper userMapper;

    /**
     * 根据用户名查询密码
     * @param username
     * @return
     */
    public String findPasswordByUserName(String username) {
        return userMapper.findPasswordByUsername(username);
    }
}
