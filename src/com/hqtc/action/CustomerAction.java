package com.hqtc.action;

import com.hqtc.biz.CustomerBiz;
import com.hqtc.model.Customer;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: He Qing
 * Date: 13-2-5
 * Time: 下午4:54
 * To change this template use File | Settings | File Templates.
 */
@Component
public class CustomerAction extends ActionSupport implements RequestAware, SessionAware {
    Map<String, Object> request;
    Map<String, Object> session;

    @Autowired
    CustomerBiz customerBiz;
    private Customer customer;
    private String msg;
    private String resultMsg;

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    public Customer getCustomer() {
        return customer;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setCustomerBiz(CustomerBiz customerBiz) {
        this.customerBiz = customerBiz;
    }


    public String register() {
        if (customerBiz.checkAccExist(customer)) {
            this.setMsg("账号名已经存在");
            this.setResultMsg("account exists");
            return ActionSupport.ERROR;
        }
        customerBiz.register(customer);
        session.put("user", customer);
        this.setMsg("注册成功");
        this.setResultMsg("success");
        return ActionSupport.SUCCESS;
    }


    public String login() {
        Customer customer1 = customerBiz.getCustomerByAccPass(customer);
        if (customer1 == null) {
            this.setMsg("登录失败，请检查账户名和密码");
            this.setResultMsg("error");
            return ActionSupport.ERROR;
        }
        session.put("user", customer1);
        this.setMsg("login successfully");
        this.setResultMsg("success");
        return ActionSupport.SUCCESS;
    }

    public String logout() {
        if (session.get("user") != null) {
            session.remove("user");
        }
        this.setMsg("logout successfully");
        this.setResultMsg("success");
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
