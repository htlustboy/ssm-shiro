package ssm.shiro.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import ssm.shiro.entity.User;
import ssm.shiro.pager.Pager;

import java.util.List;

/**
 * Created by taohu on 2019/10/16.
 */
@Repository
public interface UserMapper {

    String findPasswordByUsername(String username);

    List<User> getUserList(Pager pager);
}
