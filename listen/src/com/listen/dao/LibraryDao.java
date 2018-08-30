package com.listen.dao;

import com.listen.dao.base.BaseDao;
import com.listen.domain.Library;

import java.io.Serializable;
import java.util.List;


public interface LibraryDao extends BaseDao<Library> {

    List<Library> findLibByLibIds(List<Integer> libIdList);

    int getTotalCount();

    /**
     * 分页获取题目列表
     * @param start
     * @param pageSize
     * @return
     */
    List<Library> getList(int start, int pageSize);

    boolean deleteLibraryById(Serializable id);

}
