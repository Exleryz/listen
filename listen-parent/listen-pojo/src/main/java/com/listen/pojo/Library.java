package com.listen.pojo;

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
public class Library {

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
    @Column(name = "userId")
    private Integer userId;

    /**
     * 大题的子题数
     */
    @Column(name = "sonCount")
    private Integer sonCount;

    /**
     * 题目难度 1 2 3
     */
    @Column(name = "difficulty")
    private Integer difficulty;

    @Column(name = "classDic")
    private Integer classDic;

    /**
     * 逻辑删除标志 0 删除 1使用
     *
     * @return
     */
    @Column(name = "flag")
    private Integer flag;

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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getSonCount() {
        return sonCount;
    }

    public void setSonCount(Integer sonCount) {
        this.sonCount = sonCount;
    }

    public Integer getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Integer difficulty) {
        this.difficulty = difficulty;
    }

    public Integer getClassDic() {
        return classDic;
    }

    public void setClassDic(Integer classDic) {
        this.classDic = classDic;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "Library{" +
                "id=" + id +
                ", src='" + src + '\'' +
                ", title='" + title + '\'' +
                ", userId=" + userId +
                ", sonCount=" + sonCount +
                '}';
    }
}
