package com.hqtc.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * User: He Qing
 * Date: 13-3-8
 * Time: 上午11:46
 * To change this template use File | Settings | File Templates.
 */
@Component
@ParentPackage("struts-default")
public class IndexAction extends ActionSupport {
    @Action(value = "toCustomer", results = {@Result(name = "success", type = "redirect", location = "/customer/login.jsp")})
    public String toCustomer() {
        return ActionSupport.SUCCESS;
    }

    @Action(value = "toMember", results = {@Result(name = "success", type = "redirect", location = "/member/login.jsp")})
    public String toMember() {
        return ActionSupport.SUCCESS;
    }
}
