package ssm.shiro.service;/**
 * Created by taohu on 2019/10/16.
 */

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
public class UserService {

    private static Logger logger = LoggerFactory.getLogger(UserService.class);

    @Resource
    private UserMapper userMapper;

    /**
     * 查询用户
     *
     * @return
     */
    public User getUserById(String id) {
        return userMapper.getUserById(id);
    }

    /**
     * 新增用户
     *
     * @return
     */
    public Integer addUser(User user) {
        User persistent = getUserById(user.getId());
        if (persistent != null) {
            return -1;
        }
        return userMapper.addUser(user);
    }

    /**
     * 删除用户
     *
     * @param id
     * @return
     */
    public Integer deleteUserById(String id) {
        return userMapper.deleteUserById(id);
    }

    /**
     * 根据用户名查询密码
     * @param username
     * @return
     */
    public String findPasswordByUserName(String username) {
        return userMapper.findPasswordByUsername(username);
    }
}
