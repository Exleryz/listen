package com.listen.service.impl;

import com.listen.dao.LibraryDao;
import com.listen.dao.LibraryPoolDao;
import com.listen.domain.Library;
import com.listen.domain.LibraryPool;
import com.listen.service.CheckService;

public class CheckServiceImpl implements CheckService {

    private LibraryPoolDao libraryPoolDao;
    private LibraryDao libraryDao;

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
     * 把lib添加进Libpool 为关卡添加题目
     *
     * @param lpId
     * @param libId
     */
    @Override
    public void saveLibToLibPool(int lpId, int libId) {
        // 是否要检查题目是否存在
        Library library = libraryDao.getById(libId);
        Integer count = libraryPoolDao.findLpIdAndLibId(lpId, libId);
        if (count == 1) {
            // 此题在当前关卡中已存在
        }
        if (count == 0) {
            if (null != library) {
                libraryPoolDao.saveLib(lpId, libId);
            } else {
                // 此题不存在
            }
        }
    }

    /**
     * 从Libpool中删除题目lib
     *
     * @param lpId
     * @param libId
     */
    @Override
    public void deleteLibByLibPool(int lpId, int libId) {
        // 检查题目是否存在
        Library library = libraryDao.getById(libId);
        Integer count = libraryPoolDao.findLpIdAndLibId(lpId, libId);
        if (count == 0) {
            // 此题在当前关卡中不存在
        }
        if (count == 1) {
            if (null != library) {
                libraryPoolDao.deleteLib(lpId, libId);
            } else {
                // 此题不存在
            }
        }
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

    public LibraryDao getLibraryDao() {
        return libraryDao;
    }

    public void setLibraryDao(LibraryDao libraryDao) {
        this.libraryDao = libraryDao;
    }
}
