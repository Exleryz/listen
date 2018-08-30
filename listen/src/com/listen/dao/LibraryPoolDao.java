package com.listen.dao;

import com.listen.dao.base.BaseDao;
import com.listen.domain.LibraryPool;

import java.util.List;

public interface LibraryPoolDao extends BaseDao<LibraryPool> {

    LibraryPool getLpByGradeAndCheck(Integer grade, Integer checkId);

    // --------------中间表syslibrarylibrarypool--------------

    List<Integer> findLibIdUseLpId(Integer lpId);

    Integer findLibCount(int lpId, int libId);

    void saveLib(int lpId, int libId);

    void deleteLib(int lpId, int libId);

}
