package com.listen.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.listen.common.utils.ListenResult;
import com.listen.mapper.LibraryMapper;
import com.listen.mapper.SubjectMapper;
import com.listen.pojo.Library;
import com.listen.pojo.Subject;
import com.listen.pojo.vo.QueryLibraryVo;
import com.listen.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author Exler
 */

@Service
public class LibraryServiceImpl implements LibraryService {

    @Autowired
    private LibraryMapper libraryMapper;
    @Autowired
    private SubjectMapper subjectMapper;

    @Override
    public ListenResult getLibrary(Integer libId) {
        QueryLibraryVo vo = libraryMapper.selectLibraryVo(libId);
        return ListenResult.success(vo);
    }

    @Override
    public ListenResult queryLibraryList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum == null ? 1 : pageNum, pageSize == null ? 8 : pageSize);
        List<Library> libraries = libraryMapper.selectAll();
        PageInfo pageInfo = new PageInfo(libraries);
        return ListenResult.success(pageInfo);
    }

    @Override
    public ListenResult deleteLibrary(Library library) {
        // 删除小题
        Example example = new Example(Subject.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("libId", library.getId());
        subjectMapper.deleteByExample(example);
        // 删除题目
        libraryMapper.delete(library);
        return ListenResult.success(null);
    }
}
