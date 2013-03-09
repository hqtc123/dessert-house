package com.hqtc.interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import org.apache.struts2.ServletActionContext;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: hqtc
 * Date: 13-3-9
 * Time: 下午9:51
 * To change this template use File | Settings | File Templates.
 */
public class SalerInterceptor extends AbstractInterceptor {
    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        String actionName = actionInvocation.getInvocationContext().getName();
        if (actionName.equals("loginAction")) {
            return actionInvocation.invoke();
        } else {
            ActionContext ac = actionInvocation.getInvocationContext();
            Map session = (Map) ac.get(ServletActionContext.SESSION);
            if (session == null) {
                return "salLogin";
            } else {
                Object saler = session.get("saler");
                if (saler == null) {
                    return "salLogin";
                } else {
                    return actionInvocation.invoke();
                }
            }
        }
    }
}
