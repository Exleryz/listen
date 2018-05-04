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
}
