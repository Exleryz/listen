package com.listen.dao.impl;

import com.listen.dao.SubjectDao;
import com.listen.dao.base.impl.BaseDaoImpl;
import com.listen.domain.Library;
import com.listen.domain.Subject;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * FileName SubjectDaoImpl
 * Created by Exler
 * Time 2018-08-30 13:43
 * Description:
 */

@Repository
public class SubjectDaoImpl extends BaseDaoImpl<Subject> implements SubjectDao {

    /**
     * 获得当前关卡的题库池(所有)
     *
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

    /**
     * 保存题目列表
     *
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
