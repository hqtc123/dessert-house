package com.hqtc.model.dao.impl;

import com.hqtc.model.dao.BaseDao;
import com.hqtc.model.dao.TorderDao;
import com.hqtc.model.entity.Torder;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 * User: hqtc
 * Date: 13-3-5
 * Time: 下午8:23
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class TorderDaoImpl extends BaseDao implements TorderDao {

    @Override
    public void add(Torder torder) {
        super.add(torder);
    }

    @Override
    public void delete(Torder torder) {
        super.delete(torder);
    }

    @Override
    public void update(Torder torder) {
        super.update(torder);
    }
}
