package com.listen.dao.impl;


import com.listen.dao.SubjectDao;
import com.listen.domain.Library;
import com.listen.domain.Subject;
import org.hibernate.Query;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

public class SubjectDaoImpl extends HibernateDaoSupport implements SubjectDao {

    @Override
    public List<Subject> findSubUseLibId(List<Integer> libIdList) {
        Query query = currentSession().createQuery("from Subject where libraryId in (:findList)");
        query.setParameterList("findList", libIdList);
        List<Subject> subjects = query.list();
        return subjects;
    }
}
