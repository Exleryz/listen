package com.listen.pojo;

import com.github.pagehelper.PageInfo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Exler
 */
@Table(name = "syslibrarylibrarypool")
public class SysLibraryLibrarypool extends PageInfo<SysLibraryLibrarypool> {

    @Id
    @Column(name = "libid")
    private Integer libId;

    @Column(name = "lpid")
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
}
