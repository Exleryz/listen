package com.listen.service;

import com.listen.common.utils.ListenResult;

/**
 * @author Exler
 */
public interface LibraryService {

    /**
     * 根据题库池id 获取题目列表
     *
     * @param lpId
     * @param pageNum
     * @param pageSize
     * @return
     */
    ListenResult queryLibraryList(Integer lpId, Integer pageNum, Integer pageSize);

    /**
     * 根据id 查询题目
     *
     * @param libId
     * @return
     */
    ListenResult getLibrary(Integer libId);
}
