package ssm.shiro.entity;/**
 * Created by taohu on 2019/10/16.
 */

import lombok.Data;
import lombok.ToString;

/**
 * @author lustboy
 * @prpgram ssm-shiro
 * @description 用户
 * @create 2019/10/16 09:49:24
 */
@Data
@ToString
public class User {

    private String id;
    private String username;
    private String password;
    private String displayName;
    private Boolean status;
    private Boolean isAdmin;
    private String memo;
}
