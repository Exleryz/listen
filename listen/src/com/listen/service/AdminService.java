package com.listen.service;

import com.listen.domain.Library;
import com.listen.domain.LibraryPool;
import com.listen.domain.vo.QuerySysStudentLibraryPoolVo;
import com.listen.utils.PageBean;
import net.sf.json.JSONObject;

public interface AdminService {

    /**
     * 获得当前关卡的设置信息
     *
     * @param currentCheck
     * @param currentGrade
     * @return Json
     */
    JSONObject getCurrentCheckScoreSet(int currentCheck, int currentGrade);

    /**
     * 获得当前关卡的设置信息 用于回显数据
     *
     * @param currentCheck
     * @param currentGrade
     * @return
     */
    LibraryPool getSetByGAndC(int currentCheck, int currentGrade);

    /**
     * 获得单题数据 回显
     *
     * @param id
     * @return
     */
    Library getLibraryDetails(Integer id);

    /**
     * 条件查询 根据vo中的参数拼装sql语句 分页
     * @param currentPage
     * @param pageSize
     * @param vo
     * @return
     */
    PageBean getQueryRecords(int currentPage, int pageSize, QuerySysStudentLibraryPoolVo vo);
}
