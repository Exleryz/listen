package com.listen.service;

import com.listen.domain.Student;
import com.listen.domain.SysStudentLibraryPool;
import com.listen.utils.PageBean;
import net.sf.json.JSON;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

public interface StudentService {

    void saveStudent(Student student);

    Student findStudentById(Student student);

    void findStudentByAccount(String account);

    JSON initGradetest();

    void initGradeCode(Student s,Integer score);

    void openNewCheckPoint(Student s, String checkcount);

    String getCurrentCheckPool(Integer grade, Integer checkId);

    void saveScore(Integer grade, Integer checkId, Integer score, Student student);

    List<SysStudentLibraryPool> getlist(Student stu);

    // 分页业务方法
    PageBean getPageBean(Student student, Integer currentPage, Integer pageSize);
}
