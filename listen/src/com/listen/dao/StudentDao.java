package com.listen.dao;

import com.listen.dao.base.BaseDao;
import com.listen.domain.Student;

public interface StudentDao extends BaseDao<Student> {

    Student getByStudentAccount(String account);

    void findByStudentIdAndGrade(Integer id, Integer grade);

    int getCurrentChecklpId(Integer checkPoint, Integer grade);
}
