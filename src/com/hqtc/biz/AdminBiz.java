package com.hqtc.biz;

import com.hqtc.model.entity.Member;
import com.hqtc.model.entity.Strategy;

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

    public void updateStrategy(Strategy strategy);

    public Member getAdminByAccPass(Member member);
}
