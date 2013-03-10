package com.hqtc.action;

import com.hqtc.biz.SalerBiz;
import com.hqtc.model.entity.Dessert;
import com.hqtc.model.entity.Shop;
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

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: hqtc
 * Date: 13-3-9
 * Time: 下午5:23
 * To change this template use File | Settings | File Templates.
 */
@Component
@ParentPackage("json-default")
@Namespace("/member")
public class MemberAjaxAction extends ActionSupport implements RequestAware, SessionAware {
    @Autowired
    private SalerBiz salerBiz;

    private String resultMsg;

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    private Dessert dessert;

    public Weeknum getWeeknum() {
        return weeknum;
    }

    public void setWeeknum(Weeknum weeknum) {
        this.weeknum = weeknum;
    }

    private Weeknum weeknum;

    public Dessert getDessert() {
        return dessert;
    }

    public void setDessert(Dessert dessert) {
        this.dessert = dessert;
    }

    Map<String, Object> request;
    Map<String, Object> session;

    @SuppressWarnings("unchecked")
    @Action(value = "addDessert", results = {@Result(name = SUCCESS, type = "json")})
    public String addDessert() {
        salerBiz.addDessert(dessert);
        setResultMsg("添加成功");
        return SUCCESS;
    }

    @SuppressWarnings("unchecked")
    @Action(value = "deleteDessert", results = {@Result(name = SUCCESS, type = "json")})
    public String deleteDessert() {
        Dessert dessert1 = salerBiz.getDessertById(dessert.getId());
        salerBiz.deleteDessert(dessert1);
        setResultMsg("删除成功");
        return SUCCESS;
    }

    @SuppressWarnings("unchecked")
    @Action(value = "updateDessert", results = {@Result(name = SUCCESS, type = "json")})
    public String updateDessert() {
        int id = dessert.getId();
        salerBiz.updateDessert(dessert);
        setResultMsg("修改成功");
        return SUCCESS;
    }

    @SuppressWarnings("unchecked")
    @Action(value = "addWeeknum", results = {@Result(name = SUCCESS, type = "json")})
    public String addWeeknum() {
        Dessert dessert1 = salerBiz.getDessertById(weeknum.getDessertid());
        if (dessert1 == null) {
            setResultMsg("添加失败，没有这个甜品ID。");
            return SUCCESS;
        }
        weeknum.setDessertname(dessert1.getName());
        Shop shop = (Shop) session.get("shop");
        weeknum.setShopid(shop.getId());
        salerBiz.addWeeknum(weeknum);
        setResultMsg("添加成功");
        return SUCCESS;
    }

    @SuppressWarnings("unchecked")
    @Action(value = "deleteWeeknum", results = {@Result(name = SUCCESS, type = "json")})
    public String deleteWeeknum() {
        Weeknum weeknum1 = salerBiz.getWeeknumById(weeknum.getId());
        salerBiz.deleteWeeknum(weeknum1);
        setResultMsg("删除成功");
        return SUCCESS;
    }

    @Override
    public void setRequest(Map<String, Object> stringObjectMap) {
        request = stringObjectMap;
    }

    @Override
    public void setSession(Map<String, Object> stringObjectMap) {
        session = stringObjectMap;
    }
}
