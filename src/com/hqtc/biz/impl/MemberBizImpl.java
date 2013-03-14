package com.hqtc.biz.impl;

import com.hqtc.biz.MemberBiz;
import com.hqtc.model.dao.DessertDao;
import com.hqtc.model.dao.MemberDao;
import com.hqtc.model.entity.Member;
import com.hqtc.util.MyMD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: hqtc
 * Date: 13-3-9
 * Time: 下午8:33
 * To change this template use File | Settings | File Templates.
 */
@Service
public abstract class MemberBizImpl implements MemberBiz {
    @Autowired
    private MemberDao memberDao;
    @Autowired
    private DessertDao dessertDao;

    @Override
    public List getAllDesserts() {
        return dessertDao.getAll();
    }

    @Override
    public Member getMemberByAccPass(Member member) {
        String password = member.getPassword();
        String newPass = MyMD5.encryption(password);
        member.setPassword(newPass);
        List list = memberDao.accPassSearch(member);
        if (list.size() > 0) {
            return (Member) list.get(0);
        }
        return null;
    }
}
