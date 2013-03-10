package com.hqtc.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

/**
 * Created with IntelliJ IDEA.
 * User: He Qing
 * Date: 13-3-8
 * Time: 上午11:46
 * To change this template use File | Settings | File Templates.
 */
@Controller
@ParentPackage("struts-default")
@Namespace("/")
public class IndexAction extends ActionSupport {
    @Action(value = "toCustomer", results = {@Result(name = SUCCESS, type = "redirect", location = "/customer/login.jsp")})
    public String toCustomer() {
        return ActionSupport.SUCCESS;
    }

    @Action(value = "toMember", results = {@Result(name = SUCCESS, type = "redirect", location = "/member/login.jsp")})
    public String toMember() {
        return ActionSupport.SUCCESS;
    }
    @Action(value = "toAdmin", results = {@Result(name = SUCCESS, type = "redirect", location = "/admin/login.jsp")})
    public String toAdmin() {
        return ActionSupport.SUCCESS;
    }
}
