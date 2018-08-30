package com.listen.dao.impl;

import com.listen.dao.VocabularyDao;
import com.listen.dao.base.impl.BaseDaoImpl;
import com.listen.domain.Vocabulary;
import org.hibernate.SQLQuery;

import java.util.List;

/**
 * FileName VocabularyDaoImpl
 * Created by Exler
 * Time 2018-08-30 13:45
 * Description:
 */

public class VocabularyDaoImpl extends BaseDaoImpl<Vocabulary> implements VocabularyDao {

    @Override
    public List<Vocabulary> getVocs(Integer grade, Integer count) {
        String sql = "select * from Vocabulary where grade = ? order by rand() limit 0,?";
        SQLQuery query = currentSession().createSQLQuery(sql).addEntity(Vocabulary.class);
        query.setParameter(0, grade);
        query.setParameter(1, count);
        List list = query.list();
        return list;
    }

}
