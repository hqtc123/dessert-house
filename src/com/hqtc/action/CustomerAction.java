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
@ParentPackage("struts-default")
@Namespace("/customer")
public class CustomerAction extends ActionSupport implements RequestAware, SessionAware {
    Map<String, Object> request;
    Map<String, Object> session;

    @Autowired
    CustomerBiz customerBiz;
    private Customer customer;
    private String resultMsg;
    private String rePassword;


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

    @Action(value = "registerAction", results = {@Result(type = "redirect", name = "success", location = "/customer/index.jsp"),
            @Result(name = "input", location = "/customer/register.jsp")})
    public String register() {
        if (customerBiz.checkAccExist(customer)) {
            setResultMsg("error");
            addFieldError("customer.account", "账号已经被占用");
            return ActionSupport.INPUT;
        }
        if(!rePassword.trim().equals(customer.getPassword()))   {
            setResultMsg("error");
            addFieldError("customer.account", "两次密码输入不一致");
            return ActionSupport.INPUT;
        }
        customerBiz.register(customer);
        session.put("customer", customer);
        setResultMsg("success");
        return ActionSupport.SUCCESS;
    }

    @Action(value = "loginAction", results = {@Result(type = "redirect", name = "success", location = "/customer/index.jsp"),
            @Result(name = "input", location = "/customer/login.jsp")})
    public String login() {
        Customer customer1 = customerBiz.getCustomerByAccPass(customer);
        if (customer1 == null) {
            setResultMsg("error");
            addFieldError("customer.account", "登录失败、请检查您的账号和密码");
            return ActionSupport.INPUT;
        }
        session.put("customer", customer1);
        setResultMsg("success");
        return ActionSupport.SUCCESS;
    }

    @Action(value = "logoutAction", results = {@Result(type = "redirect", name = "success", location = "/customer/index.jsp")})
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
