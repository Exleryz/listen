package com.listen.common.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.listen.pojo.Library;

import java.util.List;

/**
 * @author Exler
 */
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class LibraryVo extends Library {
    private List<GradeSubject> subjects;

    public List<GradeSubject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<GradeSubject> subjects) {
        this.subjects = subjects;
    }
}
