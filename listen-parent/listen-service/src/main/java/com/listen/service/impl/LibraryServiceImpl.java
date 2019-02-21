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
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public ListenResult queryLibraryList(Library library, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Map<String, Object> query = new HashMap<>(3);
        if (!StringUtils.isEmpty(library.getTitle())) {
            query.put("title", library.getTitle());
        }
        if (null != library.getClassDic()) {
            query.put("classDic", library.getClassDic());
        }
        if (null != library.getDifficulty()) {
            query.put("difficulty", library.getDifficulty());
        }
        if (null != library.getSonCount()) {
            query.put("sonCount", library.getSonCount());
        }
        List<Library> libraries = libraryMapper.selectLibraryList(query);
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

    @Override
    public ListenResult updateLibrary(QueryLibraryVo vo) {
        libraryMapper.updateByPrimaryKeySelective(vo);
        if (null != vo.getSubjects()) {
            for (Subject subject : vo.getSubjects()) {
                subjectMapper.updateByPrimaryKeySelective(subject);
            }
        }
        return ListenResult.success(null);
    }

}
