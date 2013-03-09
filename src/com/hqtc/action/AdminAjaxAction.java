package com.hqtc.action;

import com.hqtc.biz.AdminBiz;
import com.hqtc.model.entity.Member;
import com.hqtc.model.entity.Strategy;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: hqtc
 * Date: 13-3-9
 * Time: 上午10:26
 * To change this template use File | Settings | File Templates.
 */
@Component
@ParentPackage("json-default")
@Namespace("/admin")
public class AdminAjaxAction extends ActionSupport {
    @Autowired
    private AdminBiz adminBiz;
    private Member member;
    private Strategy strategy;

    public Strategy getStrategy() {
        return strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    private String resultMsg;

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    @SuppressWarnings("unchecked")
    @Action(value = "addMember", results = {@Result(name = SUCCESS, type = "json")})
    public String addMember() {
        if (adminBiz.getMemberByAcc(member) != null) {
            setResultMsg("账户名已经存在！");
            return SUCCESS;
        }
        if (!(member.getPosition().equals("saler") || member.getPosition().equals("manager"))) {
            setResultMsg("职位只能是saler或者是manager");
            return SUCCESS;
        }
        if (!(member.getShop().getId() > 0 && member.getShop().getId() < 4)) {
            setResultMsg("目前只有三家店铺可供选择");

            return SUCCESS;
        }
        adminBiz.addMember(member);
        setResultMsg("添加成功");
        return SUCCESS;
    }

    @SuppressWarnings("unchecked")
    @Action(value = "updateMember", results = {@Result(name = SUCCESS, type = "json")})
    public String updateMember() {
        int id = member.getId();
        Member member1 = adminBiz.getMemberById(id);
        member.setAccount(member1.getAccount());
        member.setPassword(member1.getPassword());
        if (!(member.getPosition().equals("saler") || member.getPosition().equals("manager"))) {
            setResultMsg("职位只能是saler或者是manager");
            return SUCCESS;
        }
        if (!(member.getShop().getId() > 0 && member.getShop().getId() < 4)) {
            setResultMsg("目前只有三家店铺可供选择");

            return SUCCESS;
        }
        adminBiz.updateMember(member);
        setResultMsg("修改成功");
        return SUCCESS;
    }

    @SuppressWarnings("unchecked")
    @Action(value = "deleteMember", results = {@Result(name = SUCCESS, type = "json")})
    public String deleteMember() {
        int id = member.getId();
        Member member1 = adminBiz.getMemberById(id);
        adminBiz.deleteMember(member1);
        setResultMsg("删除成功");
        return SUCCESS;
    }

    @SuppressWarnings("unchecked")
    @Action(value = "deleteStrategy", results = {@Result(name = SUCCESS, type = "json")})
    public String deleteStrategy() {
        int id = strategy.getId();
        Strategy strategy1 = adminBiz.getStrategyById(id);
        adminBiz.deleteStrategy(strategy1);
        setResultMsg("删除成功");
        return SUCCESS;
    }

    @SuppressWarnings("unchecked")
    @Action(value = "addStrategy", results = {@Result(name = SUCCESS, type = "json")})
    public String addStrategy() {
        if (adminBiz.getStrategyByScore(strategy) != null) {
            setResultMsg("此积分数目已经制定了策略！");
            return SUCCESS;
        }
        if (strategy.getDiscount() > 1) {
            setResultMsg("折扣不得大于1.");
            return SUCCESS;
        }
        adminBiz.addStrategy(strategy);
        setResultMsg("添加成功");
        return SUCCESS;
    }
}
