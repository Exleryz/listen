package com.listen.service;

import com.listen.domain.Student;
import com.listen.domain.SysStudentLibraryPool;
import net.sf.json.JSON;
import net.sf.json.JSONObject;

import java.util.List;

public interface StudentService {

    void saveStudent(Student student);

    Student findStudentById(Student student);

    void findStudentByAccount(String account);

    JSON initGradetest();

    void initGradeCode(Student s, float score);

    void openNewCheckPoint(Student s, String checkcount);

    String getCurrentCheckPool(Integer grade, Integer checkId);

    void saveScore(Integer grade, Integer checkId, Integer score, Student student);

    // 分页业务方法
    JSONObject getPageBean(Student student, Integer currentPage, Integer pageSize);

    JSONObject getCurrentPageBean(Student stu, Integer currentPage, Integer checkPoint, int i2);
}
