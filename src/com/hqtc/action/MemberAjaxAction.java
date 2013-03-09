package com.hqtc.action;

import com.hqtc.biz.SalerBiz;
import com.hqtc.model.entity.Dessert;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
public class MemberAjaxAction extends ActionSupport {
    @Autowired
    private SalerBiz salerBiz;

    private String resultMsg;

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    Dessert dessert;

    public Dessert getDessert() {
        return dessert;
    }

    public void setDessert(Dessert dessert) {
        this.dessert = dessert;
    }


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


}
