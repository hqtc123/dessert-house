package com.hqtc.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.*;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * User: He Qing
 * Date: 13-3-8
 * Time: 上午11:04
 * To change this template use File | Settings | File Templates.
 */
@Component
@ParentPackage("struts-default")
@Namespace("/customer")
@ResultPath("/customer")
public class CustomerHrefAction extends ActionSupport {
    @Action(value = "toLogin", results = {@Result(type = "redirect", name = "success", location = "/customer/login.jsp")})
    public String toLogin() {
        return ActionSupport.SUCCESS;
    }

    @Action(value = "toRegister", results = {@Result(type = "redirect", name = "success", location = "/customer/login.jsp")})
    public String toRegister() {
        return ActionSupport.SUCCESS;
    }
}
