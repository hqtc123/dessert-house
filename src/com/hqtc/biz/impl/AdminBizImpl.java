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
        String oldPass = member.getPassword();
        String newPass = MyMD5.encryption(oldPass);
        member.setPassword(newPass);
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
    public void deleteStrategy(Strategy strategy) {
        strategyDao.delete(strategy);
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

    @Override
    public Member getMemberByAcc(Member member) {
        List list = memberDao.accSearch(member);
        if (list.size() > 0) {
            return (Member) list.get(0);
        }
        return null;
    }

    @Override
    public List getAllMembers() {
        return memberDao.getAll();
    }

    @Override
    public List getAllStrategies() {
        return strategyDao.getAll();
    }

    @Override
    public Member getMemberById(int id) {
        return memberDao.findById(id);
    }

    @Override
    public Strategy getStrategyById(int id) {
        return strategyDao.findById(id);
    }

    @Override
    public Strategy getStrategyByScore(Strategy strategy) {
        List list = strategyDao.getStrategyByScore(strategy);
        if (list.size() > 0)
            return (Strategy) list.get(0);
        return null;
    }
}
