package com.listen.dao;

import com.listen.dao.base.BaseDao;
import com.listen.domain.vo.QuerySysStudentLibraryPoolVo;
import com.listen.domain.Student;
import com.listen.domain.SysStudentLibraryPool;
import com.listen.utils.PageBean;

import java.util.List;

public interface SysStudentLibraryPoolDao extends BaseDao<SysStudentLibraryPool> {

    List<SysStudentLibraryPool> getPageList(Student student, int start, Integer pageSize);

    int getTotalCount(Student stu);

    List<SysStudentLibraryPool> getCurrentCheckPageList(Student stu, int start, Integer pageSize, Integer lpId);

    int getCurrentCheckCount(Student stu, Integer lpId);

    List<SysStudentLibraryPool> getQueryList(PageBean pb, StringBuffer sb, QuerySysStudentLibraryPoolVo vo);

    int getQueryCount(StringBuffer sb, QuerySysStudentLibraryPoolVo vo);
}
