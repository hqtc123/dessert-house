package com.hqtc.action;

import com.hqtc.biz.CustomerBiz;
import com.hqtc.model.entity.*;
import com.hqtc.util.SuperItem;
import com.hqtc.util.SuperWeeknum;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.*;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * `
 * Created with IntelliJ IDEA.
 * User: He Qing
 * Date: 13-2-5
 * Time: 下午4:54
 * To change this template use File | Settings | File Templates.
 */
@Component
@ParentPackage("myinterceptor")
@Namespace("/customer")
public class CustomerAction extends ActionSupport implements RequestAware, SessionAware {
    Map<String, Object> request;
    Map<String, Object> session;

    @Autowired
    private CustomerBiz customerBiz;
    private Customer customer;
    private String resultMsg;
    private String rePassword;
    private Card card;
    private Torder torder;
    private float moneySum;

    public float getMoneySum() {
        return moneySum;
    }

    public void setMoneySum(float moneySum) {
        this.moneySum = moneySum;
    }

    public Torder getTorder() {
        return torder;
    }

    public void setTorder(Torder torder) {
        this.torder = torder;
    }

    private Torder order;
    private List<Orderitem> orderitems = new ArrayList<Orderitem>();

    public List<Orderitem> getOrderitems() {
        return orderitems;
    }

    public void setOrderitems(List<Orderitem> orderitems) {
        this.orderitems = orderitems;
    }

    public Torder getOrder() {
        return order;
    }

    public void setOrder(Torder order) {
        this.order = order;
    }

    private List<SuperWeeknum> super1 = new ArrayList<SuperWeeknum>();
    private List<SuperWeeknum> super2 = new ArrayList<SuperWeeknum>();

    private List<SuperItem> superItems = new ArrayList<SuperItem>();

    public List<SuperWeeknum> getSuper1() {
        return super1;
    }

    public void setSuper1(List<SuperWeeknum> super1) {
        this.super1 = super1;
    }

    public List<SuperWeeknum> getSuper2() {
        return super2;
    }

    public void setSuper2(List<SuperWeeknum> super2) {
        this.super2 = super2;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public String getRePassword() {
        return rePassword;
    }

    public void setRePassword(String rePassword) {
        this.rePassword = rePassword;
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

    public List<SuperItem> getSuperItems() {
        return superItems;
    }

    public void setSuperItems(List<SuperItem> superItems) {
        this.superItems = superItems;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setCustomerBiz(CustomerBiz customerBiz) {
        this.customerBiz = customerBiz;
    }

    @Action(value = "registerAction", results = {@Result(type = "redirect", name = "success", location = "/customer/customerIndex.action"),
            @Result(name = "input", location = "/customer/register.jsp")})
    public String register() {
        if (customerBiz.checkAccExist(customer)) {
            setResultMsg("error");
            addFieldError("customer.account", "账号已经被占用");
            return ActionSupport.INPUT;
        }
        if (!rePassword.trim().equals(customer.getPassword())) {
            setResultMsg("error");
            addFieldError("customer.account", "两次密码输入不一致");
            return ActionSupport.INPUT;
        }
        customerBiz.register(customer);
        session.put("customer", customer);
        Card card1 = new Card();
        card1.setCustomerid(customer.getId());
        card1.setState(0);
        card1.setMoney(0);
        customerBiz.saveCard(card1);
        setResultMsg("success");
        return ActionSupport.SUCCESS;
    }

    @Action(value = "loginAction", results = {@Result(type = "redirect", name = "success", location = "/customer/customerIndex.action"),
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

    @Action(interceptorRefs = {@InterceptorRef("myCusStack")}, value = "logoutAction", results = {@Result(type = "redirect", name = "success", location = "/index.jsp")})
    public String logout() {
        if (session.get("customer") != null) {
            session.remove("customer");
        }
        if (session.get("items") != null) {
            session.remove("items");
        }
        if (session.get("weeks") != null) {
            session.remove("weeks");
        }
        setResultMsg("success");
        return ActionSupport.SUCCESS;
    }

    @Action(interceptorRefs = {@InterceptorRef("myCusStack")}, value = "getInfoAction", results = {@Result(name = "success", location = "/customer/info.jsp")})
    public String getInfo() {
        customer = (Customer) session.get("customer");
        card = customerBiz.getCardByCustomerId(customer);
        return ActionSupport.SUCCESS;
    }

    @SuppressWarnings("unchecked")
    @Action(interceptorRefs = {@InterceptorRef("myCusStack")}, value = "customerIndex", results = {@Result(name = "success", location = "/customer/main.jsp")})
    public String customerIndex() {
        Calendar cal = Calendar.getInstance();
//        int weekday = cal.get(Calendar.DAY_OF_WEEK) - 1;  //todo
        int weekday = 1;
        ArrayList<Weeknum> list1 = (ArrayList) customerBiz.findWeekDesserts(1, weekday);
        ArrayList<Weeknum> list2 = (ArrayList) customerBiz.findWeekDesserts(2, weekday);
        for (int i = 0; i < list1.size(); i++) {
            super1.add(new SuperWeeknum(list1.get(i), customerBiz.getDessertByWeekNum(list1.get(i)).getPrice()));
        }
        for (int i = 0; i < list2.size(); i++) {
            super2.add(new SuperWeeknum(list2.get(i), customerBiz.getDessertByWeekNum(list2.get(i)).getPrice()));
        }
        return SUCCESS;
    }

    @SuppressWarnings("unchecked")
    @Action(interceptorRefs = {@InterceptorRef("myCusStack")}, value = "viewCart", results = {@Result(name = "success", location = "/customer/cart.jsp")})
    public String viewCart() {
        if (session.get("items") != null) {
            orderitems = (List<Orderitem>) session.get("items");
            for (int i = 0; i < orderitems.size(); i++) {
                superItems.add(new SuperItem(customerBiz.getDessertById(orderitems.get(i).getDessertid()),
                        orderitems.get(i)));
            }
            moneySum = 0;
            for (int i = 0; i < superItems.size(); i++) {
                moneySum += superItems.get(i).getDessert().getPrice() * superItems.get(i).getOrderitem().getNum();
            }
            return SUCCESS;
        } else {
            setResultMsg("购物车中没有甜品");
            return SUCCESS;
        }
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
