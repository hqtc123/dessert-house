package com.hqtc.interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import org.apache.struts2.ServletActionContext;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: He Qing
 * Date: 13-3-7
 * Time: 上午8:25
 * To change this template use File | Settings | File Templates.
 */
public class CustomerInterceptor extends AbstractInterceptor {
    public CustomerInterceptor() {
        super();    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    public void init() {
        super.init();    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    public void destroy() {
        super.destroy();    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        String actionName = actionInvocation.getInvocationContext().getName();
        if (actionName.equals("login")) {
            return actionInvocation.invoke();
        } else {
            ActionContext ac = actionInvocation.getInvocationContext();
            Map session = (Map)ac.get(ServletActionContext.SESSION);
            if(session==null){
                return "login";
            }else{
                Object customer=session.get("customer");
                if(customer==null){
                    return "login";
                }else{
                    return actionInvocation.invoke();
                }
            }
        }
    }
}
