package ssm.shiro.config;/**
 * Created by taohu on 2019/10/16.
 */

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import ssm.shiro.service.UserService;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @author taohu@maxxipoint.com
 * @prpgram ssm-shiro
 * @description shiro realm
 * @create 2019/10/16 15:27:50
 */
public class CustomerRealm extends AuthorizingRealm {

    private static Logger logger = LoggerFactory.getLogger(CustomerRealm.class);

    @Resource
    UserService userService;

    /**
     * 权限认证
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        Set<String> permissionsSet = new HashSet<>();
        //从数据库或者缓存查询权限放入set中
        info.setStringPermissions(permissionsSet);
        return info;
    }

    /**
     * 登陆验证
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        logger.info("登陆验证开始~~~:{ s% }", new Date());
        String username = (String) authenticationToken.getPrincipal();
        String password = new String((char[]) authenticationToken.getCredentials());
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            throw new AccountException("用户名或密码不能为空！");
        }
        //根据用户名从数据库中查询密码
        String dbPassword = userService.findPasswordByUserName(username);
        return new SimpleAuthenticationInfo(username,dbPassword, ByteSource.Util.bytes(username),getName());
    }
}
