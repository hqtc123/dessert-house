package com.hqtc.action;

import com.hqtc.biz.AdminBiz;
import com.hqtc.model.entity.Member;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: hqtc
 * Date: 13-3-8
 * Time: 下午8:56
 * To change this template use File | Settings | File Templates.
 */
@Component
@Namespace("/admin")
@ParentPackage("struts-default")
public class AdminAction extends ActionSupport implements RequestAware, SessionAware {
    @Autowired
    AdminBiz adminBiz;
    Member member;

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    Map<String, Object> request;
    Map<String, Object> session;

    @Action(value = "loginAction", results = {@Result(type = "redirect", name = "success", location = "/admin/main.jsp"),
            @Result(name = "input", location = "/customer/login.jsp")})
    public String login() {
        Member admin = adminBiz.getAdminByAccPass(member);
        if (admin == null) {
            addFieldError("customer.account", "登录失败、请检查您的账号和密码");
            return ActionSupport.INPUT;
        }
        session.put("admin", admin);
        return ActionSupport.SUCCESS;
    }

    @Override
    public void setRequest(Map<String, Object> stringObjectMap) {
        this.request = stringObjectMap;
    }

    @Override
    public void setSession(Map<String, Object> stringObjectMap) {
        this.session = stringObjectMap;
    }
}
