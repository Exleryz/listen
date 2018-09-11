package com.listen.dao.impl;

import com.listen.dao.SysStudentLibraryPoolDao;
import com.listen.dao.base.impl.BaseDaoImpl;
import com.listen.domain.vo.QuerySysStudentLibraryPoolVo;
import com.listen.domain.Student;
import com.listen.domain.SysStudentLibraryPool;
import com.listen.utils.PageBean;
import org.hibernate.SQLQuery;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

/**
 * FileName SysStudentLibraryPoolDaoImpl
 * Created by Exler
 * @author Exler
 * Time 2018-08-30 11:46
 * Description: 学生做题记录 中间表
 */

@Repository
public class SysStudentLibraryPoolDaoImpl extends BaseDaoImpl<SysStudentLibraryPool> implements SysStudentLibraryPoolDao {

    /**
     * 分页 获取所有历史记录
     *
     * @param student
     * @param start
     * @param pageSize
     * @return
     */
    @Override
    public List<SysStudentLibraryPool> getPageList(Student student, int start, Integer pageSize) {
        SQLQuery sqlQuery = currentSession().createSQLQuery("select * from SysStudentLibraryPool where stuId = ?").addEntity(SysStudentLibraryPool.class);
        sqlQuery.setParameter(0, student.getId());
        sqlQuery.setFirstResult(start);
        sqlQuery.setMaxResults(pageSize);
        List<SysStudentLibraryPool> list = sqlQuery.list();
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
     * 分页显示 当前关卡做题历史记录
     *
     * @param stu
     * @param start
     * @param pageSize
     * @param lpId
     * @return
     */
    @Override
    public List<SysStudentLibraryPool> getCurrentCheckPageList(Student stu, int start, Integer pageSize, Integer lpId) {
        SQLQuery sqlQuery = currentSession().createSQLQuery("select * from SysStudentLibraryPool where stuId = ? and lpId = ? order by id desc").addEntity(SysStudentLibraryPool.class);
        sqlQuery.setParameter(0, stu.getId());
        sqlQuery.setParameter(1, lpId);
        sqlQuery.setFirstResult(start);
        sqlQuery.setMaxResults(pageSize);
        List<SysStudentLibraryPool> list = sqlQuery.list();
        return list;
    }

    /**
     * 获取当前关卡做题次数
     *
     * @param stu
     * @param lpId
     * @return
     */
    @Override
    public int getCurrentCheckCount(Student stu, Integer lpId) {
        SQLQuery sqlQuery = currentSession().createSQLQuery("select count(id) from SysStudentLibraryPool where stuId=? and lpId=?");
        sqlQuery.setParameter(0, stu.getId());
        sqlQuery.setParameter(1, lpId);
        BigInteger count = (BigInteger) sqlQuery.uniqueResult();
        return count.intValue();
    }

    @Override
    public List<SysStudentLibraryPool> getQueryList(PageBean pb, StringBuffer sb, QuerySysStudentLibraryPoolVo vo) {
        System.out.println(sb);
        int paramCount = 0;
        SQLQuery sqlQuery = currentSession().createSQLQuery(sb.toString()).addEntity(SysStudentLibraryPool.class);
        /**
         * 参数设置 模板
         * sqlQuery.setParameter(paramCount, vo.getCheck());
         * paramCount += 1;
        */
        List<SysStudentLibraryPool> list = sqlQuery.list();
        return list;
    }

}
