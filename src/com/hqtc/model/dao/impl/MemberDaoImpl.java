package com.hqtc.model.dao.impl;

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
public class MemberDaoImpl extends BaseDaoImpl<Member> implements MemberDao {
    @Override
    public List accPassSearch(Member member) {
        List list = null;
        Session session = getSession();
        Criteria criteria = session.createCriteria(Member.class);
        try {
            if (member != null) {
                criteria.add(Restrictions.like("account", member.getAccount(), MatchMode.EXACT));
                criteria.add(Restrictions.like("password", member.getPassword(), MatchMode.EXACT));
                list = criteria.list();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List accSearch(Member member) {
        List list = null;
        Session session = getSession();
        Criteria criteria = session.createCriteria(Member.class);
        try {
            if (member != null) {
                criteria.add(Restrictions.like("account", member.getAccount(), MatchMode.EXACT));
                list = criteria.list();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
