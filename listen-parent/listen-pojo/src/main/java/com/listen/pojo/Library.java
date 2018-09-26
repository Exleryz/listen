package com.listen.pojo;

import com.github.pagehelper.PageInfo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * FileName Library
 *
 * @author Exler
 * Time 2018-08-30 9:51
 * Description: 大题类
 */

@Table(name = "Library")
public class Library extends PageInfo<Library> {

    /**
     * 大题id
     */
    @Id
    @Column(name = "id")
    private Integer id;

    /**
     * 大题音频文件存放位置
     */
    @Column(name = "src")
    private String src;

    /**
     * 大题名称
     */
    @Column(name = "title")
    private String title;

    /**
     * 上传题目的教师id
     */
    @Column(name = "teacherId")
    private Integer teacherId;

    /**
     * 大题的子题数
     */
    @Column(name = "sonCount")
    private Integer sonCount;

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

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
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
                ", teacherId=" + teacherId +
                ", sonCount=" + sonCount +
                '}';
    }
}
