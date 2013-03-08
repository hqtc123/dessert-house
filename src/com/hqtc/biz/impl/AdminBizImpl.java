package com.hqtc.biz.impl;

import com.hqtc.biz.AdminBiz;
import com.hqtc.model.dao.MemberDao;
import com.hqtc.model.dao.StrategyDao;
import com.hqtc.model.entity.Member;
import com.hqtc.model.entity.Strategy;
import com.hqtc.util.MyMD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: hqtc
 * Date: 13-3-7
 * Time: 下午4:14
 * To change this template use File | Settings | File Templates.
 */
@Service
public class AdminBizImpl implements AdminBiz {
    @Autowired
    private MemberDao memberDao;
    @Autowired
    private StrategyDao strategyDao;

    @Override
    public void addMember(Member member) {
        memberDao.save(member);
    }

    @Override
    public void deleteMember(Member member) {
        memberDao.delete(member);
    }

    @Override
    public void updateMember(Member member) {
        memberDao.update(member);
    }

    @Override
    public void addStrategy(Strategy strategy) {
        strategyDao.save(strategy);
    }

    @Override
    public void updateStrategy(Strategy strategy) {
        strategyDao.update(strategy);
    }

    @Override
    public Member getAdminByAccPass(Member member) {
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
