package com.listen.dao.impl;


import com.listen.dao.SubjectDao;
import com.listen.domain.Library;
import com.listen.domain.Subject;
import org.hibernate.Query;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

public class SubjectDaoImpl extends HibernateDaoSupport implements SubjectDao {

    /**
     * 获得当前关卡的题库池(所有)
     * @param libIdList
     * @return
     */
    @Override
    public List<Subject> findSubUseLibId(List<Integer> libIdList) {
        Query query = currentSession().createQuery("from Subject where libraryId in (:findList)");
        query.setParameterList("findList", libIdList);
        List<Subject> subjects = query.list();
        return subjects;
    }

    public List<Subject> findSubRanByLibId() {
        return null;
    }

    /**
     * 保存题目列表
     * @param subjectList
     * @param l
     */
    @Override
    public void saveSubjectList(List<Subject> subjectList, Library l) {
        for (int i = 0; i < subjectList.size(); i++) {
            Subject s = subjectList.get(i);
            s.setLibrary(l);
            getHibernateTemplate().save(s);
        }
    }

}
