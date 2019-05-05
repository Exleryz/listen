package com.listen.service;

import com.listen.common.utils.ListenResult;
import com.listen.pojo.Library;
import com.listen.pojo.Subject;
import com.listen.pojo.vo.QueryLibraryVo;

import java.util.List;

/**
 * @author Exler
 */
public interface LibraryService {

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
    ListenResult queryLibraryList(Library library, Integer pageNum, Integer pageSize);

    /**
     * 保存题目及其子题
     *
     * @param library
     * @param subjectList
     * @return
     */
    ListenResult saveLibrary(Library library, List<Subject> subjectList);

    /**
     * 删除题目
     *
     * @param library
     * @return
     */
    ListenResult deleteLibrary(Library library);

    /**
     * 更新题目
     *
     * @param vo
     * @return
     */
    ListenResult updateLibrary(QueryLibraryVo vo);

}
