package com.listen.dao;

import com.listen.domain.Library;
import com.listen.domain.Vocabulary;

import java.util.List;

public interface LibraryDao {
    List<Library> findLibUseLibId(List<Integer> libIdList);

}
