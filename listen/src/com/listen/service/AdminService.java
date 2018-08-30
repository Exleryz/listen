package com.listen.service;

import com.listen.domain.Library;
import com.listen.domain.LibraryPool;
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

}
