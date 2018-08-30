package com.listen.dao.impl;


import com.listen.dao.LibraryPoolDao;
import com.listen.dao.base.impl.BaseDaoImpl;
import com.listen.domain.LibraryPool;
import org.hibernate.Query;
import org.hibernate.SQLQuery;

import java.math.BigInteger;
import java.util.List;

/**
 * FileName LibraryPoolDaoImpl
 * Created by Exler
 * Time 2018-08-30 13:42
 * Description:
 */

public class LibraryPoolDaoImpl extends BaseDaoImpl<LibraryPool> implements LibraryPoolDao {

    /**
     * 根据等级 关卡获取lp对象
     *
     * @param grade
     * @param checkId
     * @return
     */
    @Override
    public LibraryPool getLpByGradeAndCheck(Integer grade, Integer checkId) {
        Query query = currentSession().createSQLQuery("select * from LibraryPool where grade = ? and checkPoint = ?").addEntity(LibraryPool.class);
        query.setParameter(0, grade);
        query.setParameter(1, checkId);
        LibraryPool lp = (LibraryPool) query.uniqueResult();
        if (lp != null) {
            return lp;
        }
        return null;
    }

    /**
     * syslibrarylibrarypool
     * 根据题库池 lpid查找题库池中所有题目id libid
     *
     * @param lpId
     * @return
     */
    @Override
    public List<Integer> findLibIdUseLpId(Integer lpId) {
        SQLQuery sqlQuery = currentSession().createSQLQuery("select libid from SysLibraryLibraryPool where lpid = ?");
        sqlQuery.setParameter(0, lpId);
        List<Integer> list = sqlQuery.list();
        System.out.println(list);
        return list;
    }


    /**
     * syslibrarylibrarypool
     * 当前关卡题库池中题目数量
     *
     * @param lpId
     * @param libId
     * @return
     */
    @Override
    public Integer findLibCount(int lpId, int libId) {
        SQLQuery sqlQuery = currentSession().createSQLQuery("select count(*) from SysLibraryLibraryPool where lpid = ? and libid = ?");
        sqlQuery.setParameter(0, lpId);
        sqlQuery.setParameter(1, libId);
        BigInteger count = (BigInteger) sqlQuery.uniqueResult();
        return count.intValue();
    }

    /**
     * syslibrarylibrarypool
     * 题库池中添加题目
     *
     * @param lpId
     * @param libId
     */
    @Override
    public void saveLib(int lpId, int libId) {
        SQLQuery sqlQuery = currentSession().createSQLQuery("insert into SysLibraryLibraryPool(libid, lpid) values(?,?)");
        sqlQuery.setParameter(0, libId);
        sqlQuery.setParameter(1, lpId);
        sqlQuery.executeUpdate();
    }

    /**
     * syslibrarylibrarypool
     * 删除题库池中的题目
     * 删除 syslibrarylibrarypool 表中 关卡lpid 关联的题目id libid
     *
     * @param lpId
     * @param libId
     */
    @Override
    public void deleteLib(int lpId, int libId) {
        SQLQuery sqlQuery = currentSession().createSQLQuery("delete from SysLibraryLibraryPool where lpId = ? and libid = ?");
        sqlQuery.setParameter(0, lpId);
        sqlQuery.setParameter(1, libId);
        sqlQuery.executeUpdate();
    }
}
