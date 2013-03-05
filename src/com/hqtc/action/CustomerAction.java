package com.hqtc.action;

import com.hqtc.biz.CustomerBiz;
import com.hqtc.model.entity.Customer;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.*;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * `
 * Created with IntelliJ IDEA.
 * User: He Qing
 * Date: 13-2-5
 * Time: 下午4:54
 * To change this template use File | Settings | File Templates.
 */
@Component
@ParentPackage("json-default")
@Namespace("/user")
public class CustomerAction extends ActionSupport implements RequestAware, SessionAware {
    Map<String, Object> request;
    Map<String, Object> session;

    @Autowired
    CustomerBiz customerBiz;
    private Customer customer;
    private String msg;
    private String resultMsg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setCustomerBiz(CustomerBiz customerBiz) {
        this.customerBiz = customerBiz;
    }

    @Action(value = "ajaxRegister",results = {@Result(type = "json")})
    public String register() {
        if (customerBiz.checkAccExist(customer)) {
            return ActionSupport.ERROR;
        }
        customerBiz.register(customer);
        session.put("customer", customer);
        setResultMsg("success");
        return ActionSupport.SUCCESS;
    }

    @Action(value = "ajaxLogin",results = {@Result(type = "json"),@Result(name = "error",location = "/login.jsp")})
    public String login() {
        Customer customer1 = customerBiz.getCustomerByAccPass(customer);
        if (customer1 == null) {
            setResultMsg("error");
            setMsg("抱歉，账号或者密码错误");
            return ActionSupport.ERROR;
        }
        session.put("customer", customer1);
        setResultMsg("success");
        return ActionSupport.SUCCESS;
    }

    @Action(value = "ajaxLogout",results = {@Result(type = "json")})
    public String logout() {
        if (session.get("customer") != null) {
            session.remove("customer");
        }
        setResultMsg("success");
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
