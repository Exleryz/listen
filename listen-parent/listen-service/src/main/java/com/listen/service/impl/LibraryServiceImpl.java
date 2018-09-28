package com.listen.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.listen.common.utils.ListenResult;
import com.listen.mapper.LibraryMapper;
import com.listen.mapper.SysLibraryLibraryPoolMapper;
import com.listen.pojo.Library;
import com.listen.pojo.SysLibraryLibraryPool;
import com.listen.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Exler
 */

@Service
public class LibraryServiceImpl implements LibraryService {

    @Autowired
    private LibraryMapper libraryMapper;
    @Autowired
    private SysLibraryLibraryPoolMapper sysLibraryLibraryPoolMapper;

    @Override
    public ListenResult queryLibraryList(Integer lpId, Integer pageNum, Integer pageSize) {
        Example example = new Example(SysLibraryLibraryPool.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("lpId", lpId);
        PageHelper.startPage(pageNum == null ? 1 : pageNum, pageSize == null ? 8 : pageSize);
        List<SysLibraryLibraryPool> list = sysLibraryLibraryPoolMapper.selectByExample(example);
        PageInfo pageInfo = new PageInfo(list);
        List<Library> libraries = new ArrayList<>();
        for (SysLibraryLibraryPool sysLibraryLibraryPool : list) {
            Library library = libraryMapper.selectByPrimaryKey(sysLibraryLibraryPool.getLibId());
            libraries.add(library);
        }
        // 替换list显示题目详情
        pageInfo.setList(libraries);
        return ListenResult.success(pageInfo);
    }
}
