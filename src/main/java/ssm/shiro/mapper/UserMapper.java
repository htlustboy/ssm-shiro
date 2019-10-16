package ssm.shiro.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import ssm.shiro.entity.User;

/**
 * Created by taohu on 2019/10/16.
 */
@Repository
public interface UserMapper {

    Integer addUser(User user);

    User getUserById(@Param("id") String id);

    Integer deleteUserById(String id);

    String findPasswordByUsername(String username);
}
