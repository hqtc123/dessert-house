package com.hqtc.biz;

import com.hqtc.model.entity.Member;

/**
 * Created with IntelliJ IDEA.
 * User: hqtc
 * Date: 13-3-9
 * Time: 下午8:32
 * To change this template use File | Settings | File Templates.
 */
public interface MemberBiz {
    public Member getMemberByAccPass(Member member);
}
