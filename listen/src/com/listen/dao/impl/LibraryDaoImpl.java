package com.listen.dao.impl;

import com.listen.dao.LibraryDao;
import com.listen.domain.Library;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

public class LibraryDaoImpl extends HibernateDaoSupport implements LibraryDao {

    @Override
    public List<Library> findLibByLibIds(List<Integer> libIdList) {
        Query query = currentSession().createQuery("from Library where id in (:findList)");
        query.setParameterList("findList", libIdList);
        List<Library> libraries = query.list();
//        for (Library l : libraries) {
//            System.out.println(l);
//        }
        return libraries;
    }

    /**
     * 获得单题详情
     *
     * @param id
     * @return
     */
    @Override
    public Library getById(Serializable id) {
        Library library = getHibernateTemplate().get(Library.class, id);
        return library;
    }

    /**
     * 保存题目
     */
    @Override
    public Library saveLibrary(Library library) {
        getHibernateTemplate().save(library);
        return library;
    }

    /**
     * 查询题目总数
     *
     * @return
     */
    @Override
    public int getTotalCount() {
        SQLQuery sqlQuery = currentSession().createSQLQuery("select count(id) from library");
        BigInteger count = (BigInteger) sqlQuery.uniqueResult();
        return count.intValue();
    }

    /**
     * 倒序分页查询题目
     * @param start
     * @param pageSize
     * @return
     */
    @Override
    public List<Library> getList(int start, int pageSize) {
        SQLQuery sqlQuery = currentSession().createSQLQuery("select * from library order by id desc").addEntity(Library.class);
        sqlQuery.setFirstResult(start);
        sqlQuery.setMaxResults(pageSize);
        List<Library> list = sqlQuery.list();
        return list;
    }

    /**
     * 删除对应id的题目
     * @param id
     */
    @Override
    public boolean deleteLibraryById(Serializable id) {
        Library l = this.getById(id);
        if (l != null) {
            getHibernateTemplate().delete(l);
            return true;
        }
        return false;
    }
}
