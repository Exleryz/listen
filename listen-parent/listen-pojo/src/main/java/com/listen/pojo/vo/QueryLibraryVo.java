package com.listen.pojo.vo;

import com.listen.pojo.Library;
import com.listen.pojo.Subject;

import java.util.List;

/**
 * @author Exler
 */
public class QueryLibraryVo extends Library {

    private List<Subject> subjects;

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }
}
