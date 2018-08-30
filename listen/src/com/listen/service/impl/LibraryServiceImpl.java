package com.listen.service.impl;

import com.listen.dao.LibraryDao;
import com.listen.dao.SubjectDao;
import com.listen.domain.Library;
import com.listen.domain.Subject;
import com.listen.service.LibraryService;
import com.listen.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * FileName LibraryServiceImpl
 * Created by Exler
 * Time 2018-08-30 14:18
 * Description:
 */

@Service
@Transactional
public class LibraryServiceImpl implements LibraryService {
    @Autowired
    private LibraryDao libraryDao;
    @Autowired
    private SubjectDao subjectDao;

    @Override
    public void saveLibrary(Library library, List<Subject> subjectList) {
        // 保存题目
        libraryDao.save(library);
        // 保存子题
        subjectDao.saveSubjectList(subjectList, library);
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

}
