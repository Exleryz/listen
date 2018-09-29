package com.listen.service;

import com.listen.common.utils.ListenResult;
import com.listen.pojo.LibraryPool;
import com.listen.pojo.SysLibraryLibraryPool;

/**
 * @author Exler
 */
public interface LibraryPoolService {

    /**
     * 获取当前关卡 的题目(直接生成试卷)
     *
     * @param grade
     * @param checkPoint
     * @return
     */
    ListenResult getCurrentGradeSubjects(Integer grade, Integer checkPoint);

    /**
     * 根据等级关卡 查询 题库池 设置信息(分页)
     *
     * @param libraryPool
     * @return
     */
    ListenResult selectPoolByGradeAndCheckPoint(LibraryPool libraryPool);

    /**
     * 更新题库池信息
     *
     * @param libraryPool
     * @return
     */
    ListenResult updateLibraryPool(LibraryPool libraryPool);

    /**
     * 为题库池添加题目
     *
     * @param sysLibraryLibraryPool
     * @param libIds
     * @return
     */
    ListenResult insertLibraryToLibraryPool(SysLibraryLibraryPool sysLibraryLibraryPool, Integer[] libIds);

    /**
     * 从题库池中删除题目
     *
     * @param sysLibraryLibraryPool
     * @param libIds
     * @return
     */
    ListenResult deleteLibraryInPool(SysLibraryLibraryPool sysLibraryLibraryPool, Integer[] libIds);

    /**
     * 根据题库池id 获取题目列表
     *
     * @param lpId
     * @param pageNum
     * @param pageSize
     * @return
     */
    ListenResult queryLibraryListByPool(Integer lpId, Integer pageNum, Integer pageSize);
}