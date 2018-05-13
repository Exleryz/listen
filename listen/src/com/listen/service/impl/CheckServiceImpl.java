package com.listen.service.impl;

import com.listen.dao.LibraryPoolDao;
import com.listen.domain.LibraryPool;
import com.listen.service.CheckService;

public class CheckServiceImpl implements CheckService {

    private LibraryPoolDao libraryPoolDao;

    /**
     * 设置关卡
     *
     * @param libraryPool
     */
    @Override
    public void setLibraryPool(LibraryPool libraryPool) {
        LibraryPool lp = libraryPoolDao.getByGradeAndCheckId(libraryPool.getGrade(), libraryPool.getCheckPoint());
        libraryPool.setId(lp.getId());
        libraryPoolDao.updateLP(libraryPool);
    }

    /**
     * 设置关卡的题库池
     * @return
     */

    public LibraryPoolDao getLibraryPoolDao() {
        return libraryPoolDao;
    }

    public void setLibraryPoolDao(LibraryPoolDao libraryPoolDao) {
        this.libraryPoolDao = libraryPoolDao;
    }
}
