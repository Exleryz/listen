package com.listen.dao;

import com.listen.domain.LibraryPool;

import java.util.List;

public interface LibraryPoolDao {
    Integer findLibIdUseCurrentCheckId(Integer grade, Integer checkId);

    List<Integer> findLibIdUseLpId(Integer lpId);

    LibraryPool getLpIdByGradeAndCheckId(Integer grade, Integer checkId);
}
