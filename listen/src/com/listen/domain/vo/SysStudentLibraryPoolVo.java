package com.listen.domain.vo;

import com.listen.domain.SysStudentLibraryPool;

/**
 * @author Exler
 * @FileName SysStudentLibraryPoolVo
 * @time 2018-09-11 11:41
 * @Description:
 */
public class SysStudentLibraryPoolVo extends SysStudentLibraryPool {
    /**
     * 做题用户
     * 用户id
     */
    private String stuId;

    /**
     * 对应题库池
     * 题库池id
     */
    private String lpId;


    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    public String getLpId() {
        return lpId;
    }

    public void setLpId(String lpId) {
        this.lpId = lpId;
    }
}
