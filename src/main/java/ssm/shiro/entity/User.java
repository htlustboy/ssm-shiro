package ssm.shiro.entity;/**
 * Created by taohu on 2019/10/16.
 */

/**
 * @author taohu@maxxipoint.com
 * @prpgram ssm-shiro
 * @description 用户
 * @create 2019/10/16 09:49:24
 */
public class User {

    private String id;
    private String username;
    private Integer age;
    private String password;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
