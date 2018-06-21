package com.listen.dao.impl;

import com.listen.dao.LibraryPoolDao;
import com.listen.domain.LibraryPool;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.test.context.jdbc.Sql;

import java.math.BigInteger;
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
        SQLQuery sqlQuery = currentSession().createSQLQuery("select libid from SysLibraryLibraryPool where lpid = ?");
        sqlQuery.setParameter(0, lpId);
        List<Integer> list = sqlQuery.list();
        System.out.println(list);
        return list;
    }

    @Override
    public LibraryPool getLpIdByGradeAndCheckId(Integer grade, Integer checkId) {
        Query query = currentSession().createSQLQuery("select * from LibraryPool where grade = ? and checkPoint = ?").addEntity(LibraryPool.class);
        query.setParameter(0, grade);
        query.setParameter(1, checkId);
        LibraryPool lp = (LibraryPool) query.uniqueResult();
//        lp.setLibrarieSet(null);
//        System.out.println(lp + "1111111111111111111111111111111");
        return lp;
    }

    @Override
    public LibraryPool getByGradeAndCheckId(int currentGrade, int currentCheck) {
        List<LibraryPool> libraryPools = (List<LibraryPool>) getHibernateTemplate().find("from LibraryPool where grade=? and checkPoint=?", currentGrade, currentCheck);
        System.out.println(libraryPools.get(0));
        if (libraryPools.get(0) != null) {
            return libraryPools.get(0);
        }
        return null;
    }

    @Override
    public void updateLP(LibraryPool libraryPool) {
        getHibernateTemplate().update(libraryPool);
    }

    @Override
    public Integer findLpIdAndLibId(int lpId, int libId) {
        SQLQuery sqlQuery = currentSession().createSQLQuery("select count(*) from SysLibraryLibraryPool where lpid = ? and libid = ?");
        sqlQuery.setParameter(0, lpId);
        sqlQuery.setParameter(1, libId);
        BigInteger count = (BigInteger) sqlQuery.uniqueResult();
        return count.intValue();
    }

    @Override
    public void saveLib(int lpId ,int libId) {
        SQLQuery sqlQuery = currentSession().createSQLQuery("insert into SysLibraryLibraryPool(libid, lpid) values(?,?)");
        sqlQuery.setParameter(0, libId);
        sqlQuery.setParameter(1, lpId);
        sqlQuery.uniqueResult();
    }

    /**
     * 删除 syslibrarylibrarypool 表中 关卡lpid 关联的题目 libid
     * @param lpId
     * @param libId
     */
    @Override
    public void deleteLib(int lpId, int libId) {
        SQLQuery sqlQuery = currentSession().createSQLQuery("delete from SysLibraryLibraryPool where lpId = ? and libid = ?");
        sqlQuery.setParameter(0, lpId);
        sqlQuery.setParameter(1, libId);
        sqlQuery.uniqueResult();
    }
}
