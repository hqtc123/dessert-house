package com.hqtc.action;

import com.hqtc.biz.ManagerBiz;
import com.hqtc.biz.SalerBiz;
import com.hqtc.model.entity.Dessert;
import com.hqtc.model.entity.Member;
import com.hqtc.model.entity.Shop;
import com.hqtc.model.entity.Weeknum;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.*;
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
@ParentPackage("myinterceptor")
@Namespace("/member")
public class MemberAction extends ActionSupport implements RequestAware, SessionAware {
    @Autowired
    private SalerBiz salerBiz;
    @Autowired
    private ManagerBiz managerBiz;

    private Member member;
    private Weeknum weeknum;

    public Weeknum getWeeknum() {
        return weeknum;
    }

    public void setWeeknum(Weeknum weeknum) {
        this.weeknum = weeknum;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    List<Dessert> desserts = new ArrayList<Dessert>();

    public List<Weeknum> getWeeknums1() {
        return weeknums1;
    }

    public void setWeeknums1(List<Weeknum> weeknums1) {
        this.weeknums1 = weeknums1;
    }

    List<Weeknum> weeknums1 = new ArrayList<Weeknum>();
    List<Weeknum> weeknums2 = new ArrayList<Weeknum>();
    List<Weeknum> weeknums3 = new ArrayList<Weeknum>();
    List<Weeknum> weeknums4 = new ArrayList<Weeknum>();

    public List<Weeknum> getWeeknums5() {
        return weeknums5;
    }

    public void setWeeknums5(List<Weeknum> weeknums5) {
        this.weeknums5 = weeknums5;
    }

    public List<Weeknum> getWeeknums2() {
        return weeknums2;
    }

    public void setWeeknums2(List<Weeknum> weeknums2) {
        this.weeknums2 = weeknums2;
    }

    public List<Weeknum> getWeeknums3() {
        return weeknums3;
    }

    public void setWeeknums3(List<Weeknum> weeknums3) {
        this.weeknums3 = weeknums3;
    }

    public List<Weeknum> getWeeknums4() {
        return weeknums4;
    }

    public void setWeeknums4(List<Weeknum> weeknums4) {
        this.weeknums4 = weeknums4;
    }

    List<Weeknum> weeknums5 = new ArrayList<Weeknum>();

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
            session.put("shop", member1.getShop());
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
    @Action(interceptorRefs = {@InterceptorRef("mySalStack")}, value = "viewDesserts", results = {@Result(name = SUCCESS, location = "/member/saler.jsp")})
    public String viewDesserts() {
        if (session.get("saler") == null) {
            return INPUT;
        }
        int shopid = ((Member) session.get("saler")).getShop().getId();
        desserts = salerBiz.getAllDesserts();
        Weeknum weeknum1 = new Weeknum();

        weeknum1.setShopid(shopid);
        weeknum1.setWeekday(1);
        weeknums1 = salerBiz.getWeekNumByShopDay(weeknum1);
        weeknum1.setWeekday(2);
        weeknums2 = salerBiz.getWeekNumByShopDay(weeknum1);
        weeknum1.setWeekday(3);
        weeknums3 = salerBiz.getWeekNumByShopDay(weeknum1);
        weeknum1.setWeekday(4);
        weeknums4 = salerBiz.getWeekNumByShopDay(weeknum1);
        weeknum1.setWeekday(5);
        weeknums5 = salerBiz.getWeekNumByShopDay(weeknum1);
        return SUCCESS;
    }

    @SuppressWarnings("unchecked")
    @Action(value = "logoutAction", results = {@Result(name = "success", type = "redirect", location = "/index.jsp")})
    public String logout() {
        if (session.get("saler") != null)
            session.remove("admin");
        if (session.get("manager") != null)
            session.remove("manager");
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
