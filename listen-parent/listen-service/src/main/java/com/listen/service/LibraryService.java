package com.listen.service;

import com.listen.common.utils.ListenResult;
import com.listen.pojo.Library;

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
    ListenResult queryLibraryListByPool(Integer lpId, Integer pageNum, Integer pageSize);

    /**
     * 根据id 查询题目
     *
     * @param libId
     * @return
     */
    ListenResult getLibrary(Integer libId);

    /**
     * 分页查询 题目
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    ListenResult queryLibraryList(Integer pageNum, Integer pageSize);

    /**
     * 删除题目
     *
     * @param library
     * @return
     */
    ListenResult deleteLibrary(Library library);
}
