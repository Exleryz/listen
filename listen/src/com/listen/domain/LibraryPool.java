package com.listen.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * FileName LibraryPool
 * Created by Exler
 * Time 2018-08-30 10:07
 * Description: 题库池类
 */

public class LibraryPool {

    /**
     * 题库池id
     */
    private Integer id;

    /**
     * 题库池所属等级
     */
    private Integer grade;

    /**
     * 题库池所属关卡
     */
    private Integer checkPoint;

    /**
     * 题库池通过规定分数
     */
    private Double score;

    /**
     * 题库池题目数量
     */
    private Integer subjectCount;

    /**
     * 题库池中的题目
     */
    private Set<Library> librarieSet = new HashSet<>();

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

    public Set<Library> getLibrarieSet() {
        return librarieSet;
    }

    public void setLibrarieSet(Set<Library> librarieSet) {
        this.librarieSet = librarieSet;
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
