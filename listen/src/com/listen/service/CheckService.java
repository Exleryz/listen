package com.listen.service;

import com.listen.domain.LibraryPool;

public interface CheckService {

    /**
     * 设置关卡
     *
     * @param libraryPool
     */
    void setLibraryPool(LibraryPool libraryPool);

    /**
     * 把lib添加进Libpool 为关卡添加题目
     *
     * @param lpId
     * @param libIds
     */
    void saveLibToLibPool(int lpId, Integer[] libIds);

    /**
     * 从题库池中删除题目
     *
     * @param lpId
     * @param libId
     */
    void deleteLibByLibPool(int lpId, int libId);

    /**
     * 根据lpId 获得 LP对象
     *
     * @param lpId
     */
    LibraryPool getLPByLPId(Integer lpId);
}
