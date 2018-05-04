package com.listen.domain;


import java.util.HashSet;
import java.util.Set;

public class LibraryPool {
    private Integer id;
    private Integer grade;
    private Integer checkPoint;
    private Double score;
    private Integer subjectCount;
    private Set<Library> librarieSet = new HashSet<>();

    public Set<Library> getLibrarieSet() {
        return librarieSet;
    }

    public void setLibrarieSet(Set<Library> librarieSet) {
        this.librarieSet = librarieSet;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Integer getCheckPoint() {
        return checkPoint;
    }

    public void setCheckPoint(Integer checkPoint) {
        this.checkPoint = checkPoint;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Integer getSubjectCount() {
        return subjectCount;
    }

    public void setSubjectCount(Integer subjectCount) {
        this.subjectCount = subjectCount;
    }

    @Override
    public String toString() {
        return "LibraryPool{" +
                "id=" + id +
                ", grade=" + grade +
                ", checkPoint=" + checkPoint +
                ", score=" + score +
                ", subjectCount=" + subjectCount +
                ", librarieSet=" + librarieSet +
                '}';
    }
}
