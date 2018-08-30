package com.listen.service;

import com.listen.domain.Library;
import com.listen.domain.Subject;
import com.listen.utils.PageBean;

import java.util.List;

public interface LibraryService {

    /**
     * 保存题目信息及其子题
     *
     * @param library
     * @param subjectList
     */
    void saveLibrary(Library library, List<Subject> subjectList);

    /**
     * 获取题目列表 分页
     *
     * @param currentPage
     * @param pageSize
     * @return
     */
    PageBean getCurrentPageBean(int currentPage, int pageSize);

    /**
     * 根据id删除题目
     *
     * @param id
     * @return
     */
    boolean deleteLibrary(int id);
}
