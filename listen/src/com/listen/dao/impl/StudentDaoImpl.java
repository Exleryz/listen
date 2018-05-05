package com.listen.dao.impl;

import com.listen.dao.StudentDao;
import com.listen.domain.Student;
import com.listen.domain.SysStudentLibraryPool;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

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

    /**
     * 初始化保存学生
     *
     * @param student
     */
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

    /**
     * 更新学生 等级 关数
     *
     * @param student
     */
    @Override
    public void updateGrade(Student student) {
        SQLQuery sqlQuery = currentSession().createSQLQuery("update Student SET grade=?,currentCheck=? where id=?");
        sqlQuery.setParameter(0, student.getGrade());
        sqlQuery.setParameter(1, student.getCurrentCheck());
        sqlQuery.setParameter(2, student.getId());
        sqlQuery.executeUpdate();
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
     * 计算当前学生 当前关卡已做次数
     *
     * @param stu
     * @param lpId
     * @return
     */
    @Override
    public Integer countThisCheckId(Student stu, Integer lpId) {
        SQLQuery sqlQuery = currentSession().createSQLQuery("select count(id) from SysStudentLibraryPool where lpId=? and stuId=?");
        sqlQuery.setParameter(0, lpId);
        sqlQuery.setParameter(1, stu.getId());
        BigInteger count = (BigInteger) sqlQuery.uniqueResult();
        if (count != null) {
            return count.intValue();
        } else {
            return null;
        }

    }

    /**
     * 保存分数
     *
     * @param score
     * @param count
     * @param classify
     * @param stuId
     * @param lpId
     */
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

    /**
     * 更新闯关状态
     *
     * @param student
     */
    @Override
    public void updateStudent(Student student) {
        getHibernateTemplate().update(student);
    }

    /**
     * 获取学生历史闯关所有数据列表
     *
     * @param student
     * @return
     */
    @Override
    public List<SysStudentLibraryPool> getAllCheckList(Student student) {
        List<SysStudentLibraryPool> list = (List<SysStudentLibraryPool>) getHibernateTemplate().find("from SysStudentLibraryPool where stu = ?", student);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        return list;
    }


    @Override
    public List<SysStudentLibraryPool> getPageList(Student student, int start, Integer pageSize) {
        SQLQuery sqlQuery = currentSession().createSQLQuery("select * from sysstudentlibrarypool where stuId = ?").addEntity(SysStudentLibraryPool.class);
        sqlQuery.setParameter(0, student.getId());
        sqlQuery.setFirstResult(start);
        sqlQuery.setMaxResults(pageSize);
        System.out.println("start" + start);
        System.out.println("pageSize" + pageSize);
        List<SysStudentLibraryPool> list = sqlQuery.list();
        System.out.println("listsize:" + list.size());
        for (SysStudentLibraryPool sslp : list) {
            System.out.println(sslp);
        }
        return list;
    }

    /**
     * 获取学生历史做题总数量
     *
     * @param stu
     * @return
     */
    @Override
    public int getTotalCount(Student stu) {
        SQLQuery sqlQuery = currentSession().createSQLQuery("select count(id) from SysStudentLibraryPool where stuId=?");
        sqlQuery.setParameter(0, stu.getId());
        BigInteger count = (BigInteger) sqlQuery.uniqueResult();
        System.out.println("totalcount:--------" + count);
        return count.intValue();
    }

    /**
     * 获取学生历史闯关分页数据列表
     */


}
