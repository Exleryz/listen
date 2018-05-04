package com.listen.dao;

import com.listen.domain.Student;

public interface StudentDao {
    Student getByStudentAccount(String account);

    void save(Student student);

    boolean findByStudentAccount(String account);

    void updateGrade(Student student);

    void findByStudentIdAndGrade(Integer id, Integer grade);

    void saveScore(Integer grade, String checkId, Integer integer, Integer score, String account);

    Integer countThisCheckId(String account, Integer lpId);

    void saveScore(Integer score, Integer count, Integer classify, Integer stuId, Integer lpId);

    void updateStudent(Student student);

}
