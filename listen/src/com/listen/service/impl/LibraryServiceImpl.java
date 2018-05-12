package com.listen.service.impl;

import com.listen.dao.LibraryDao;
import com.listen.dao.SubjectDao;
import com.listen.domain.Library;
import com.listen.domain.Subject;
import com.listen.service.LibraryService;

import java.util.List;

public class LibraryServiceImpl implements LibraryService {

    private LibraryDao libraryDao;
    private SubjectDao subjectDao;

    @Override
    public void saveLibrary(Library library, List<Subject> subjectList) {
        // 保存题目
        Library l = libraryDao.saveLibrary(library);
        // 保存子题
        subjectDao.saveSubjectList(subjectList, l);
    }



    public LibraryDao getLibraryDao() {
        return libraryDao;
    }

    public void setLibraryDao(LibraryDao libraryDao) {
        this.libraryDao = libraryDao;
    }

    public SubjectDao getSubjectDao() {
        return subjectDao;
    }

    public void setSubjectDao(SubjectDao subjectDao) {
        this.subjectDao = subjectDao;
    }
}
