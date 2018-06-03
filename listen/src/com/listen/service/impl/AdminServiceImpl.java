package com.listen.service.impl;

import com.listen.dao.LibraryDao;
import com.listen.dao.LibraryPoolDao;
import com.listen.domain.Library;
import com.listen.domain.LibraryPool;
import com.listen.service.AdminService;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;


public class AdminServiceImpl implements AdminService {

    private LibraryPoolDao libraryPoolDao;
    private LibraryDao libraryDao;

    /**
     * 获得当前关卡的设置信息
     *
     * @param currentCheck
     * @param currentGrade
     * @return Json
     */
    @Override
    public JSONObject getCurrentCheckScoreSet(int currentCheck, int currentGrade) {
        LibraryPool lp = libraryPoolDao.getByGradeAndCheckId(currentGrade, currentCheck);
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.setExcludes(new String[]{"teacher", "libraryPoolSet"});
        JSONObject jsonObject = JSONObject.fromObject(lp, jsonConfig);
        return jsonObject;
    }

    /**
     * 获得当前关卡的设置信息 用于回显数据
     *
     * @param currentCheck
     * @param currentGrade
     * @return
     */
    @Override
    public LibraryPool getSetByGAndC(int currentCheck, int currentGrade) {
        LibraryPool lp = libraryPoolDao.getByGradeAndCheckId(currentGrade, currentCheck);
        return lp;
    }

    /**
     * 获得单题数据 回显
     *
     * @param id
     * @return
     */
    @Override
    public Library getLibraryDetails(Integer id) {
        System.out.println(id);
        Library l = libraryDao.getById(id);
        return l;
    }


    public LibraryDao getLibraryDao() {
        return libraryDao;
    }

    public void setLibraryDao(LibraryDao libraryDao) {
        this.libraryDao = libraryDao;
    }

    public LibraryPoolDao getLibraryPoolDao() {
        return libraryPoolDao;
    }

    public void setLibraryPoolDao(LibraryPoolDao libraryPoolDao) {
        this.libraryPoolDao = libraryPoolDao;
    }
}
