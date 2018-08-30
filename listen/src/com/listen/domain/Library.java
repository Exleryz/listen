package com.listen.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * FileName Library
 * Created by Exler
 * Time 2018-08-30 9:51
 * Description: 大题类
 */
public class Library {

    public Library() {
    }

    public Library(Integer id, String title, Student teacher) {
        this.id = id;
        this.title = title;
        this.teacher = teacher;
    }

    /**
     * 大题id
     */
    private Integer id;

    /**
     * 大题音频文件存放位置
     */
    private String src;

    /**
     * 大题名称
     */
    private String title;

    /**
     * 大题的子题数
     */
    private Integer sonCount;

    /**
     * 上传题目的教师id
     */
    private Student teacher;

    /**
     * 题库池与大题的对应关系 sysLibraryLibraryPool
     */
    private Set<LibraryPool> libraryPoolSet = new HashSet<>();

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

    public Set<LibraryPool> getLibraryPoolSet() {
        return libraryPoolSet;
    }

    public void setLibraryPoolSet(Set<LibraryPool> libraryPoolSet) {
        this.libraryPoolSet = libraryPoolSet;
    }

    @Override
    public String toString() {
        return "Library{" +
                "id=" + id +
                ", src='" + src + '\'' +
                ", title='" + title + '\'' +
                ", sonCount=" + sonCount +
                ", teacher=" + teacher +
                '}';
//        输出libraryPoolSet 会造成栈溢出报错
    }
}
