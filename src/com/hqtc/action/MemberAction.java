package com.hqtc.action;

import com.hqtc.biz.ManagerBiz;
import com.hqtc.biz.SalerBiz;
import com.hqtc.model.entity.Dessert;
import com.hqtc.model.entity.Member;
import com.hqtc.model.entity.Weeknum;
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
 * Date: 13-3-9
 * Time: 下午5:23
 * To change this template use File | Settings | File Templates.
 */
@Component
@ParentPackage("struts-default")
@Namespace("/member")
public class MemberAction extends ActionSupport implements RequestAware, SessionAware {
    @Autowired
    private SalerBiz salerBiz;
    @Autowired
    private ManagerBiz managerBiz;

    private Member member;

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    List<Dessert> desserts = new ArrayList<Dessert>();

    public List<Weeknum> getWeeknums() {
        return weeknums;
    }

    public void setWeeknums(List<Weeknum> weeknums) {
        this.weeknums = weeknums;
    }

    List<Weeknum> weeknums = new ArrayList<Weeknum>();

    Map<String, Object> request;
    Map<String, Object> session;

    public List<Dessert> getDesserts() {
        return desserts;
    }

    public void setDesserts(List<Dessert> desserts) {
        this.desserts = desserts;
    }

    @SuppressWarnings("unchecked")
    @Action(value = "loginAction", results = {@Result(name = "saler", type = "redirect", location = "/member/viewDesserts.action"),
            @Result(name = "manager", type = "redirect", location = "/member/viewCustomers.action"),
            @Result(name = INPUT, type = "redirect", location = "/member/login.jsp")})
    public String login() {
        Member member1 = salerBiz.getMemberByAccPass(member);
        if (member1 == null) {
            addFieldError("member.account", "登录失败、请检查您的账号和密码");
            return ActionSupport.INPUT;
        }
        if (member1.getPosition().equals("admin")) {
            addFieldError("member.account", "登录失败、您或许应使用系统管理员登录专用页面");
            return ActionSupport.INPUT;
        }
        if (member1.getPosition().equals("saler")) {
            session.put("saler", member1);
            return "saler";
        }
        if (member1.getPosition().equals("manager")) {
            session.put("manager", member1);
            return "manager";
        }
        return ActionSupport.SUCCESS;
    }

    @SuppressWarnings("unchecked")
    @Action(value = "viewDesserts", results = {@Result(name = SUCCESS, location = "/member/saler.jsp")})
    public String viewDesserts() {
        desserts = salerBiz.getAllDesserts();
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
