package com.hqtc.biz.impl;

import com.hqtc.biz.AdminBiz;
import com.hqtc.model.dao.MemberDao;
import com.hqtc.model.dao.StrategyDao;
import com.hqtc.model.entity.Member;
import com.hqtc.model.entity.Strategy;
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
    private MemberDao memberDao;
    private StrategyDao strategyDao;
    //todo

    @Override
    public void addMember(Member member) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void deleteMember(Member member) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void updateMember(Member member) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void addStrategy(Strategy strategy) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void updateStrategy(Strategy strategy) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
