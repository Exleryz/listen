package com.listen.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Exler
 * 题库池id 与之关联的所有大题目
 */
@Table(name = "SysLibraryLibraryPool")
public class SysLibraryLibraryPool {

    @Id
    @Column(name = "libId")
    private Integer libId;

    @Id
    @Column(name = "lpId")
    private Integer lpId;

    public Integer getLibId() {
        return libId;
    }

    public void setLibId(Integer libId) {
        this.libId = libId;
    }

    public Integer getLpId() {
        return lpId;
    }

    public void setLpId(Integer lpId) {
        this.lpId = lpId;
    }

    @Override
    public String toString() {
        return "SysLibraryLibraryPool{" +
                "libId=" + libId +
                ", lpId=" + lpId +
                '}';
    }
}
