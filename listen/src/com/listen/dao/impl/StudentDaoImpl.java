package com.listen.dao.impl;

import com.listen.dao.StudentDao;
import com.listen.dao.base.impl.BaseDaoImpl;
import com.listen.domain.Student;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateCallback;

/**
 * FileName StudentDaoImpl
 * Created by Exler
 * Time 2018-08-30 10:51
 * Description:
 */

public class StudentDaoImpl extends BaseDaoImpl<Student> implements StudentDao {

    /**
     * 根据用户账号获取用户
     *
     * @param account
     * @return
     */
    @Override
    public Student getByStudentAccount(final String account) {
        return getHibernateTemplate().execute(new HibernateCallback<Student>() {
            @Override
            public Student doInHibernate(Session session) throws HibernateException {
                String hql = "from Student where account = ?";
                Query query = session.createQuery(hql);
                query.setParameter(0, account);
                return (Student) query.uniqueResult();
            }
        });
    }

    /**
     * 此方法未完成
     *
     * @param id
     * @param grade
     */
    @Override
    @Deprecated
    public void findByStudentIdAndGrade(Integer id, Integer grade) {
        currentSession().createSQLQuery("select count(*) where studentid=");
    }

    /**
     * 根据关数等级 获取 lpId
     *
     * @param checkPoint
     * @param grade
     * @return
     */
    @Override
    public int getCurrentChecklpId(Integer checkPoint, Integer grade) {
        SQLQuery sqlQuery = currentSession().createSQLQuery("select id from LibraryPool where grade=? and checkPoint=?");
        sqlQuery.setParameter(0, grade);
        sqlQuery.setParameter(1, checkPoint);
        Integer id = (Integer) sqlQuery.uniqueResult();
        System.out.println("current lpId =" + id);
        return id;
    }

    /**
     * 获取学生历史闯关分页数据列表
     */
}
