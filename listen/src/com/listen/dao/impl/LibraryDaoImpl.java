package com.listen.dao.impl;

import com.listen.dao.LibraryDao;
import com.listen.domain.Library;
import org.hibernate.Query;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

public class LibraryDaoImpl extends HibernateDaoSupport implements LibraryDao {

    @Override
    public List<Library> findLibUseLibId(List<Integer> libIdList) {
        Query query = currentSession().createQuery("from Library where id in (:findList)");
        query.setParameterList("findList", libIdList);
        List<Library> libraries = query.list();
//        for (Library l : libraries) {
//            System.out.println(l);
//        }
        return libraries;
    }

    /**
     * 题目全列表显示 部分属性查询 分页
     *
     * @return
     */
    @Override
    public List<Library> getAll() {
        List<Library> libraries = (List<Library>) getHibernateTemplate().find("select new Library(id,title,teacher) from Library");
        return libraries;
    }

    /**
     * 获得单题详情
     * @param id
     * @return
     */
    @Override
    public Library getById(Integer id) {
        Library library = getHibernateTemplate().get(Library.class, id);
        return library;
    }
}
