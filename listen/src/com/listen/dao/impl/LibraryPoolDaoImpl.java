package com.listen.dao.impl;

import com.listen.dao.LibraryPoolDao;
import com.listen.domain.LibraryPool;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

public class LibraryPoolDaoImpl extends HibernateDaoSupport implements LibraryPoolDao {

    @Override
    public Integer findLibIdUseCurrentCheckId(Integer grade, Integer checkId) {
        SQLQuery sqlQuery = currentSession().createSQLQuery("select id from LibraryPool where checkPoint = ? and grade = ?");
        sqlQuery.setParameter(0, checkId);
        sqlQuery.setParameter(1, grade);
        Integer id = (Integer) sqlQuery.uniqueResult();
        System.out.println(id);    // 返回的id(lpid)到sysllp表中根据lp id寻找libid  根据libid从library表中寻找题目
        return id;
    }

    @Override
    public List<Integer> findLibIdUseLpId(Integer lpId) {
        SQLQuery sqlQuery = currentSession().createSQLQuery("select libid from syslibrarylibrarypool where lpid = ?");
        sqlQuery.setParameter(0, lpId);
        List<Integer> list = sqlQuery.list();
        System.out.println(list);
        return list;
    }

    @Override
    public LibraryPool getLpIdByGradeAndCheckId(Integer grade, Integer checkId) {
        Query query = currentSession().createSQLQuery("select * from librarypool where grade = ? and checkPoint = ?").addEntity(LibraryPool.class);
        query.setParameter(0, grade);
        query.setParameter(1, checkId);
        LibraryPool lp = (LibraryPool) query.uniqueResult();
//        lp.setLibrarieSet(null);
        System.out.println(lp + "1111111111111111111111111111111");
        return lp;
    }
}
