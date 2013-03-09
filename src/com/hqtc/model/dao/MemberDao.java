package com.hqtc.model.dao;

import com.hqtc.model.entity.Member;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: hqtc
 * Date: 13-3-5
 * Time: 上午10:47
 * To change this template use File | Settings | File Templates.
 */
public interface MemberDao extends BaseDao<Member> {
    public List accPassSearch(Member member);

    public List getAll();

    public List accSearch(Member member);
}
