package com.listen.service.impl;

import com.listen.dao.LibraryDao;
import com.listen.dao.LibraryPoolDao;
import com.listen.domain.Library;
import com.listen.domain.LibraryPool;
import com.listen.service.CheckService;
import org.omg.PortableServer.LIFESPAN_POLICY_ID;

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
     * @param libIds
     */
    @Override
    public void saveLibToLibPool(int lpId, Integer[] libIds) {
        // 若效率不行 删除 //
        // 是否要检查题目是否存在
        for (int i = 0; i < libIds.length; i++) {
            //Library library = libraryDao.getById(libIds[i]);
            //
            Integer count = libraryPoolDao.findLpIdAndLibId(lpId, libIds[i]);
            if (count == 1) {
                // 此题在当前关卡中已存在
            } else if (count == 0) {
                //if (null != library) {    //
                libraryPoolDao.saveLib(lpId, libIds[i]);
                //} else {    //
                // 此题不存在
                //}    //
            }
        }
    }


    /**
     * 从题库池中删除题目
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
     * 根据lpId 获得 LP对象
     *
     * @param lpId
     */
    @Override
    public LibraryPool getLPByLPId(Integer lpId) {
        LibraryPool lp = libraryPoolDao.findLPByLPId(lpId);
        return lp;
    }

    /**
     * 设置关卡的题库池
     *
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
