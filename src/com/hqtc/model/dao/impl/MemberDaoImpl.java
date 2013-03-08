package com.hqtc.model.dao.impl;

import com.hqtc.model.dao.BaseDao;
import com.hqtc.model.dao.MemberDao;
import com.hqtc.model.entity.Member;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: hqtc
 * Date: 13-3-5
 * Time: 下午7:42
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class MemberDaoImpl extends BaseDao implements MemberDao{
    @Override
    public void delete(Member member) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void update(Member member) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List accPassSearch(Member member) {
        List list = null;
        Session session = getSession();
        Criteria criteria = session.createCriteria(Member.class);
        try {
            if (member != null) {
                criteria.add(Restrictions.like("account", member.getAccount(), MatchMode.EXACT));
                criteria.add(Restrictions.like("password", member.getPassword(), MatchMode.EXACT));
                criteria.add(Restrictions.eq("position",0));
                list = criteria.list();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void add(Member member) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
