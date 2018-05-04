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

}
