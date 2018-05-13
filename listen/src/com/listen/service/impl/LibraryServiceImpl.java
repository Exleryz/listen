package com.listen.service.impl;

import com.listen.dao.LibraryDao;
import com.listen.dao.SubjectDao;
import com.listen.domain.Library;
import com.listen.domain.Subject;
import com.listen.service.LibraryService;
import com.listen.utils.PageBean;

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

    @Override
    public PageBean getCurrentPageBean(int currentPage, int pageSize) {
        int totalCount = libraryDao.getTotalCount();
        PageBean pb = new PageBean(currentPage, totalCount, pageSize);
        List<Library> libraries = libraryDao.getList(pb.getStart(), pageSize);
        pb.setList(libraries);
        return pb;
    }

    /**
     * 删除对应id的题目
     *
     * @param id
     */
    @Override
    public boolean deleteLibrary(int id) {
        return libraryDao.deleteLibraryById(id);
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
