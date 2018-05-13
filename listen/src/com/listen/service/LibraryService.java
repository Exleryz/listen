package com.listen.service;

import com.listen.domain.Library;
import com.listen.domain.Subject;
import com.listen.utils.PageBean;

import java.util.List;

public interface LibraryService {

    void saveLibrary(Library library, List<Subject> subjectList);

    PageBean getCurrentPageBean(int currentPage, int pageSize);

    boolean deleteLibrary(int id);
}
