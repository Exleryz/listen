package com.listen.dao;

import com.listen.domain.Library;
import com.listen.domain.Vocabulary;

import java.util.List;

public interface LibraryDao {

    List<Library> findLibUseLibId(List<Integer> libIdList);

    List<Library> getAll();

    Library getById(Integer id);

    Library saveLibrary(Library library);
}
