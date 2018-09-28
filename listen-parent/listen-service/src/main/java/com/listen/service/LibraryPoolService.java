package com.listen.service;

import com.listen.common.utils.ListenResult;
import com.listen.pojo.LibraryPool;

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
}
