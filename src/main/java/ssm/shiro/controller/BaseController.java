package ssm.shiro.controller;/**
 * Created by taohu on 2019/11/19.
 */

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ssm.shiro.util.BaseUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author taohu@maxxipoint.com
 * @prpgram ssm-shiro
 * @description
 * @create 2019/11/19 17:08:43
 */
@ControllerAdvice
public class BaseController {

    private static final String ERROR_MESSAGE = "errorMessage";

    private static RedirectAttributes redirectAttributes;

    protected static void addErrorMessage(final String message){
        if(StringUtils.isEmpty(message)){
            return ;
        }
        RedirectAttributes redirectAttributes = getRedirectAttributes();
        if(redirectAttributes != null){
            redirectAttributes.addFlashAttribute(ERROR_MESSAGE,message);
        }
    }

    public static RedirectAttributes getRedirectAttributes() {
        return redirectAttributes;
    }

    public static void setRedirectAttributes(RedirectAttributes persistent) {
        redirectAttributes = persistent;
    }
}
