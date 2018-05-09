package com.listen.dao.impl;

import com.listen.dao.VocabularyDao;
import com.listen.domain.Vocabulary;
import org.hibernate.SQLQuery;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

public class VocabularyDaoImpl extends HibernateDaoSupport implements VocabularyDao {

    @Override
    public List<Vocabulary> getVocs(Integer grade, Integer count) {
        String sql = "select * from Vocabulary where grade = ? order by rand() limit 0,?";
        SQLQuery query = currentSession().createSQLQuery(sql).addEntity(Vocabulary.class);
        query.setParameter(0, grade);
        query.setParameter(1, count);
        List list = query.list();
//        List<Vocabulary> list = (List<Vocabulary>) getHibernateTemplate().find("from Vocabulary where grade = ? order by rand()", grade);
        return list;
    }

}
