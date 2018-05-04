package com.listen.dao;

import com.listen.domain.Subject;

import java.util.List;

public interface SubjectDao {
    List<Subject> findSubUseLibId(List<Integer> libIdList);
}
