package ssm.shiro.util;/**
 * Created by taohu on 2019/10/16.
 */

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

import java.util.List;
import java.util.UUID;

/**
 * @author taohu@maxxipoint.com
 * @prpgram ssm-shiro
 * @description 通用工具类
 * @create 2019/10/16 16:33:19
 */
public class BaseUtil {

    /**
     * md5普通加密
     *
     * @param str
     * @return
     */
    public static String md5(String str) {
        return new SimpleHash("MD5", str).toHex();
    }

    /**
     * md5加盐加密
     *
     * @param str
     * @param salt
     * @return
     */
    public static String md5(String str, String salt) {
        return new SimpleHash("MD5", str, ByteSource.Util.bytes(salt), 1).toHex();
    }

    /**
     * 生成uuid
     *
     * @return
     */
    public static String uuid() {
        return UUID.randomUUID().toString();
    }

    /**
     * 列表截取
     * @return
     */
    public static List<?> subList(int start,Integer end ,List<?> list){
        if(end>list.size()){
            return list.subList(start,list.size());
        }
        return list.subList(start,end);
    }

    public static void main(String[] args) {
        System.out.println(md5("123456","aaaaa"));
    }
}
