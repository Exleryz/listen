package com.listen.dao;

import com.listen.domain.Student;
import com.listen.domain.SysStudentLibraryPool;

import java.util.List;

public interface StudentDao {
    Student getByStudentAccount(String account);

    void save(Student student);

    boolean findByStudentAccount(String account);

    void updateGrade(Student student);

    void findByStudentIdAndGrade(Integer id, Integer grade);

    Integer countThisCheckId(Student stu, Integer lpId);

    void saveScore(Integer score, Integer count, Integer classify, Integer stuId, Integer lpId);

    void updateStudent(Student student);

    List<SysStudentLibraryPool> getAllCheckList(Student student);

    List<SysStudentLibraryPool> getPageList(Student student, int start, Integer pageSize);

    int getTotalCount(Student stu);

    List<SysStudentLibraryPool> getCurrentCheckPageList(Student stu, int start, Integer pageSize, Integer lpId);

    int getCurrentCheckCount(Student stu, Integer lpId);

    int getCurrentChecklpId(Integer checkPoint, Integer grade);
}
