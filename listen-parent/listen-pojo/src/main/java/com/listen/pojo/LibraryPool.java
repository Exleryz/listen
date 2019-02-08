package com.listen.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * FileName LibraryPool
 *
 * @author Exler
 * Time 2018-08-30 10:07
 * Description: 题库池类
 */

@Table(name = "LibraryPool")
public class LibraryPool {

    /**
     * 题库池id
     */
    @Id
    @Column(name = "id")
    private Integer id;

    /**
     * 题库池所属等级
     */
    @Column(name = "grade")
    private Integer grade;

    /**
     * 题库池所属关卡
     */
    @Column(name = "checkPoint")
    private Integer checkPoint;

    /**
     * 题库池通过规定分数(正确比)
     */
    @Column(name = "score")
    private Double score;

    /**
     * 题库池题目数量
     */
    @Column(name = "libraryCount")
    private Integer libraryCount;

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

    public Integer getLibraryCount() {
        return libraryCount;
    }

    public void setLibraryCount(Integer libraryCount) {
        this.libraryCount = libraryCount;
    }

    @Override
    public String toString() {
        return "LibraryPool{" +
                "id=" + id +
                ", grade=" + grade +
                ", checkPoint=" + checkPoint +
                ", score=" + score +
                ", libraryCount=" + libraryCount +
                '}';
    }
}
