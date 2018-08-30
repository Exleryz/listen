package com.listen.dao.impl;

import com.listen.dao.StudentDao;
import com.listen.dao.base.impl.BaseDaoImpl;
import com.listen.domain.Student;
import org.hibernate.SQLQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * FileName StudentDaoImpl
 * Created by Exler
 * Time 2018-08-30 10:51
 * Description:
 */

@Repository
public class StudentDaoImpl extends BaseDaoImpl<Student> implements StudentDao {

    /**
     * 根据用户账号获取用户
     *
     * @param account
     * @return
     */
    @Override
    public Student getByStudentAccount(String account) {
        SQLQuery sqlQuery = currentSession().createSQLQuery("select * from Student where account = ?").addEntity(Student.class);
        sqlQuery.setParameter(0, account);
        List<Student> list = sqlQuery.list();
        if (list != null && list.size() > 0) {
            return list.get(0);
        }
        return null;
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
     * 更新学生 等级 关数
     *
     * @param student
     */
    @Override
    public void updateGradeAndCheck(Student student) {
        SQLQuery sqlQuery = currentSession().createSQLQuery("update Student SET grade=?,currentCheck=? where id=?");
        sqlQuery.setParameter(0, student.getGrade());
        sqlQuery.setParameter(1, student.getCurrentCheck());
        sqlQuery.setParameter(2, student.getId());
        sqlQuery.executeUpdate();
    }

    /**
     * 获取学生历史闯关分页数据列表
     */
}
