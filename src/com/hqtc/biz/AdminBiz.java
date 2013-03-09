package com.hqtc.biz;

import com.hqtc.model.entity.Member;
import com.hqtc.model.entity.Strategy;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: hqtc
 * Date: 13-3-7
 * Time: 下午3:52
 * To change this template use File | Settings | File Templates.
 */
public interface AdminBiz {
    public void addMember(Member member);

    public void deleteMember(Member member);

    public void updateMember(Member member);

    public void addStrategy(Strategy strategy);

    public void deleteStrategy(Strategy strategy);

    public Member getAdminByAccPass(Member member);

    public Member getMemberByAcc(Member member);

    public List getAllMembers();

    public List getAllStrategies();

    public Member getMemberById(int id);

    public Strategy getStrategyById(int id);

    public Strategy getStrategyByScore(Strategy strategy);
}
