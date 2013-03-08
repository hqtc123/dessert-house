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
public interface MemberDao {
    public void add(Member member);

    public void delete(Member member);

    public void update(Member member);

    public List accPassSearch(Member member);
}
