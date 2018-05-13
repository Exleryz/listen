package com.listen.dao;

import com.listen.domain.Library;
import com.listen.domain.Subject;

import java.util.List;

public interface SubjectDao {
    List<Subject> findSubUseLibId(List<Integer> libIdList);

    void saveSubjectList(List<Subject> subjectList, Library l);

}
