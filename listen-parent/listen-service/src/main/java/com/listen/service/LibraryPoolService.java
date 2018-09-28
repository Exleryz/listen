package com.listen.service;

import com.listen.common.utils.ListenResult;

/**
 * @author Exler
 */
public interface LibraryPoolService {

    /**
     * 获取当前关卡 的题目
     *
     * @param grade
     * @param checkId
     * @return
     */
    ListenResult getCurrentGradeSubjects(Integer grade, Integer checkId);
}
