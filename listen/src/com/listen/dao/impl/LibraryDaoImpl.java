package com.listen.dao.impl;

import com.listen.dao.LibraryDao;
import com.listen.dao.base.impl.BaseDaoImpl;
import com.listen.domain.Library;
import org.hibernate.Query;
import org.hibernate.SQLQuery;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

/**
 * FileName LibraryDaoImpl
 * Created by Exler
 * Time 2018-08-30 10:33
 * Description: 题目Dao
 */

public class LibraryDaoImpl extends BaseDaoImpl<Library> implements LibraryDao {

    /**
     * 根据题目ids查找题目
     *
     * @param libIdList
     * @return
     */
    @Override
    public List<Library> findLibByLibIds(List<Integer> libIdList) {
        Query query = currentSession().createQuery("from Library where id in (:findList)");
        query.setParameterList("findList", libIdList);
        List<Library> libraries = query.list();
        return libraries;
    }

    /**
     * 查询题目总数
     *
     * @return
     */
    @Override
    public int getTotalCount() {
        SQLQuery sqlQuery = currentSession().createSQLQuery("select count(id) from Library");
        BigInteger count = (BigInteger) sqlQuery.uniqueResult();
        return count.intValue();
    }

    /**
     * 倒序分页查询题目
     *
     * @param start
     * @param pageSize
     * @return
     */
    @Override
    public List<Library> getList(int start, int pageSize) {
        SQLQuery sqlQuery = currentSession().createSQLQuery("select * from Library order by id desc").addEntity(Library.class);
        sqlQuery.setFirstResult(start);
        sqlQuery.setMaxResults(pageSize);
        List<Library> list = sqlQuery.list();
        return list;
    }

    /**
     * 删除对应id的题目
     *
     * @param id
     */
    @Override
    public boolean deleteLibraryById(Serializable id) {
        Library l = this.findById(id);
        if (l != null) {
            this.delete(l);
            return true;
        }
        return false;
    }
}
