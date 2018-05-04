package com.listen.domain;

import java.util.HashSet;
import java.util.Set;

public class Library {
    private Integer id;
    private String src;
    private String title;
    private Integer sonCount;    // 题目有几道子题
    private Student teacher;    // 上传题目教师id
    private Set<LibraryPool> libraryPoolSet = new HashSet<>();

    public Set<LibraryPool> getLibraryPoolSet() {
        return libraryPoolSet;
    }

    public void setLibraryPoolSet(Set<LibraryPool> libraryPoolSet) {
        this.libraryPoolSet = libraryPoolSet;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Student getTeacher() {
        return teacher;
    }

    public void setTeacher(Student teacher) {
        this.teacher = teacher;
    }

    public Integer getSonCount() {
        return sonCount;
    }

    public void setSonCount(Integer sonCount) {
        this.sonCount = sonCount;
    }

    @Override
    public String toString() {
        return "Library{" +
                "id=" + id +
                ", src='" + src + '\'' +
                ", title='" + title + '\'' +
                ", sonCoount=" + sonCount +
                ", teacher=" + teacher +
                '}';
//        输出libraryPoolSet 会造成栈溢出报错
    }
}
