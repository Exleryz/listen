package com.listen.dao.impl;

import com.listen.dao.StudentDao;
import com.listen.domain.Student;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

public class StudentDaoImpl extends HibernateDaoSupport implements StudentDao {

    @Override
    public Student getByStudentAccount(final String account) {
        return getHibernateTemplate().execute(new HibernateCallback<Student>() {
            @Override
            public Student doInHibernate(Session session) throws HibernateException {
                String hql = "from Student where account = ?";
                Query query = session.createQuery(hql);
//                System.out.println(account);
                query.setParameter(0, account);
                return (Student) query.uniqueResult();
            }
        });
    }

    @Override
    public void save(Student student) {
//        init
        student.setGrade(0);
        student.setClassify(0);
        getHibernateTemplate().save(student);
    }

    /**
     * 根据学生账号(学号) 查找学生
     *
     * @param account
     * @return
     */
    @Override
    public boolean findByStudentAccount(String account) {
        List<Student> list = (List<Student>) getHibernateTemplate().find("from Student where account = ?", account);
        if (list.size() > 0) {
            return true;
        }
        return false;
    }

    @Override
    public void updateGrade(Student student) {
        SQLQuery sqlQuery = currentSession().createSQLQuery("update Student SET grade=?,currentCheck=? where id=?");
        sqlQuery.setParameter(0, student.getGrade());
        sqlQuery.setParameter(1, student.getCurrentCheck());
        sqlQuery.setParameter(2, student.getId());
        sqlQuery.executeUpdate();
    }

    @Override
    public void findByStudentIdAndGrade(Integer id, Integer grade) {
        currentSession().createSQLQuery("select count(*) where studentid=");
    }

    @Override
    public void saveScore(Integer grade, String checkId, Integer integer, Integer score, String account) {
        currentSession().createSQLQuery("insert ");
    }

    @Override
    public Integer countThisCheckId(String account, Integer lpId) {
        SQLQuery sqlQuery = currentSession().createSQLQuery("select count(id) from SysStudentLibraryPool where lpId=?");
        sqlQuery.setParameter(0, lpId);
        BigInteger count = (BigInteger) sqlQuery.uniqueResult();
        System.out.println(count);
        return count.intValue();
    }

    @Override
    public void saveScore(Integer score, Integer count, Integer classify, Integer stuId, Integer lpId) {
        SQLQuery sqlQuery = currentSession().createSQLQuery("insert into sysstudentlibrarypool (score, time, count, classify, stuId, lpId) values (?, ?, ?, ?, ?, ?)");
        sqlQuery.setParameter(0, score);
        sqlQuery.setParameter(1, "1");
        sqlQuery.setParameter(2, count);
        sqlQuery.setParameter(3, 1);
        sqlQuery.setParameter(4, stuId);
        sqlQuery.setParameter(5, lpId);
        int i = sqlQuery.executeUpdate();
        // return 1 success
    }

    @Override
    public void updateStudent(Student student) {
        getHibernateTemplate().update(student);
    }
}
