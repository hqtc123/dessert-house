package com.hqtc.action;

import com.hqtc.biz.AdminBiz;
import com.hqtc.biz.CustomerBiz;
import com.hqtc.model.entity.Customer;
import com.hqtc.model.entity.Member;
import com.hqtc.model.entity.Strategy;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
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
    private AdminBiz adminBiz;
    Member member;

    List<Member> members = new ArrayList<Member>();

    public List<Strategy> getStrategies() {
        return strategies;
    }

    public void setStrategies(List<Strategy> strategies) {
        this.strategies = strategies;
    }

    List<Strategy> strategies = new ArrayList<Strategy>();

    public List<Member> getMembers() {
        return members;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    Map<String, Object> request;
    Map<String, Object> session;

    @SuppressWarnings("unchecked")
    @Action(value = "loginAction", results = {@Result(name = "success", type = "redirect", location = "/admin/viewMemAndStr.action"),
            @Result(name = "input", type = "redirect", location = "/customer/login.jsp")})
    public String login() {
        Member admin = adminBiz.getAdminByAccPass(member);
        if (admin == null) {
            addFieldError("member.account", "登录失败、请检查您的账号和密码");
            return ActionSupport.INPUT;
        }
        if (!admin.getPosition().equals("admin")) {
            addFieldError("member.account", "登录失败、您不具有管理员权限");
            return ActionSupport.INPUT;
        }
        session.put("admin", admin);
        return ActionSupport.SUCCESS;
    }

    @SuppressWarnings("unchecked")
    @Action(value = "viewMemAndStr", results = {@Result(name = SUCCESS, location = "/admin/main.jsp")})
    public String viewMemAndStr() {
        members = adminBiz.getAllMembers();
        members.remove(0);
        strategies = adminBiz.getAllStrategies();
        return SUCCESS;
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
