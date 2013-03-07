package com.hqtc.biz.impl;

import com.hqtc.biz.AdminBiz;
import com.hqtc.model.dao.MemberDao;
import com.hqtc.model.dao.StrategyDao;
import com.hqtc.model.entity.Member;
import com.hqtc.model.entity.Strategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        memberDao.add(member);
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
        strategyDao.add(strategy);
    }

    @Override
    public void updateStrategy(Strategy strategy) {
        strategyDao.update(strategy);
    }
}
