package com.hqtc.action;

import com.hqtc.biz.CustomerBiz;
import com.hqtc.model.entity.*;
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
import java.util.Map;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: He Qing
 * Date: 13-3-9
 * Time: 下午10:38
 * To change this template use File | Settings | File Templates.
 */
@Component
@ParentPackage("json-default")
@Namespace("/customer")
public class CustomerAjaxAction extends ActionSupport implements RequestAware, SessionAware {
    @Autowired
    private CustomerBiz customerBiz;
    private Customer customer;
    private Card card;
    private String resultMsg;
    private Weeknum weeknum;
    private float moneySum;
    private Torder torder;
    private int shopid;

    public int getShopid() {
        return shopid;
    }

    public void setShopid(int shopid) {
        this.shopid = shopid;
    }

    public Torder getTorder() {
        return torder;
    }

    public void setTorder(Torder torder) {
        this.torder = torder;
    }

    public float getMoneySum() {
        return moneySum;
    }

    public void setMoneySum(float moneySum) {
        this.moneySum = moneySum;
    }

    public Weeknum getWeeknum() {
        return weeknum;
    }

    public void setWeeknum(Weeknum weeknum) {
        this.weeknum = weeknum;
    }

    public Orderitem getOrderitem() {
        return orderitem;
    }

    public void setOrderitem(Orderitem orderitem) {
        this.orderitem = orderitem;
    }

    private Orderitem orderitem;

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

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    private int rechargeMoney;

    public float getRechargeMoney() {
        return rechargeMoney;
    }

    public void setRechargeMoney(int rechargeMoney) {
        this.rechargeMoney = rechargeMoney;
    }

    Map<String, Object> request;
    Map<String, Object> session;

    @Action(value = "recharge", results = {@Result(name = SUCCESS, type = "json")})
    public String recharge() {
        customer = (Customer) session.get("customer");
        card = customerBiz.getCardByCustomerId(customer);
        customerBiz.recharge(card, rechargeMoney);
        setResultMsg("充值成功");
        if (card.getState() == 0 && card.getMoney() >= 100) {
            customerBiz.activeCard(card);
        }
        return SUCCESS;
    }

    @SuppressWarnings("unchecked")
    @Action(value = "addItem", results = {@Result(name = SUCCESS, type = "json")})
    public String addItem() {
        if (session.get("items") == null) {
            session.put("items", new ArrayList<Orderitem>());
        }
        ArrayList<Orderitem> items = (ArrayList<Orderitem>) session.get("items");
        items.add(orderitem);
        session.put("items", items);

        Weeknum weeknum1 = customerBiz.getWeeknumById(weeknum.getId());
        weeknum1.setNum(weeknum.getNum());
        if (session.get("weeks") == null) {
            session.put("weeks", new ArrayList<Weeknum>());
        }
        ArrayList<Weeknum> weeks = (ArrayList<Weeknum>) session.get("weeks");
        weeks.add(weeknum1);
        session.put("weeks", weeks);
        setResultMsg("已经加入购物车");
        session.put("shopid", shopid);
        return SUCCESS;
    }

    @SuppressWarnings("unchecked")
    @Action(value = "payAction", results = {@Result(name = SUCCESS, type = "json")})
    public String payAction() {
        customer = (Customer) session.get("customer");
        card = customerBiz.getCardByCustomerId(customer);
        if (card.getState() == 0) {
            setResultMsg("会员卡未激活");
            return SUCCESS;
        }
        if (card.getMoney() < moneySum) {
            setResultMsg("余额不足");
            return SUCCESS;
        }
        float newMoney = card.getMoney() - moneySum;
        card.setMoney(newMoney);
        customerBiz.updateCard(card);
        torder.setCustomerid(customer.getId());
        torder.setDate(new java.sql.Date(new Date().getTime()));
        torder.setSalerid(0);
        torder.setShopid((Integer) (session.get("shopid")));
        customerBiz.makeOrder(torder);
        ArrayList<Orderitem> items = (ArrayList<Orderitem>) session.get("items");
        for (int i = 0; i < items.size(); i++) {
            items.get(i).setTorder(torder);
            customerBiz.saveOrderitem(items.get(i));
        }
        session.remove("items");
        ArrayList<Weeknum> weeks = (ArrayList<Weeknum>) session.get("weeks");
        for (int i = 0; i < weeks.size(); i++) {
            customerBiz.updateWeeknum(weeks.get(i));
        }
        session.remove("weeks");
        setResultMsg("付款成功");
        return SUCCESS;
    }

    @SuppressWarnings("unchecked")
    @Action(value = "cancelPay", results = {@Result(name = SUCCESS, type = "json")})
    public String cancelPay() {
        if (session.get("items") != null)
            session.remove("items");
        if (session.get("weeks") != null)
            session.remove("weeks");
        setResultMsg("取消成功");
        return SUCCESS;
    }

    @SuppressWarnings("unchecked")
    @Action(value = "changeInfo", results = {@Result(name = SUCCESS, type = "json")})
    public String changeInfo() {
        Customer customer1 = (Customer) session.get("customer");
        customer1.setAge(customer.getAge());
        customer1.setAddress(customer.getAddress());
        customerBiz.update(customer1);
        setResultMsg("修改成功");
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
