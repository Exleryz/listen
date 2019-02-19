package com.listen.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.listen.common.utils.ListenResult;
import com.listen.common.utils.MakeSubject;
import com.listen.common.vo.LibraryVo;
import com.listen.mapper.LibraryMapper;
import com.listen.mapper.LibraryPoolMapper;
import com.listen.mapper.SubjectMapper;
import com.listen.mapper.SysLibraryLibraryPoolMapper;
import com.listen.pojo.Library;
import com.listen.pojo.LibraryPool;
import com.listen.pojo.SysLibraryLibraryPool;
import com.listen.pojo.vo.QueryLibraryVo;
import com.listen.pojo.vo.SysLibraryLibraryPoolVo;
import com.listen.service.LibraryPoolService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.*;

/**
 * @author Exler
 */
@Service
public class LibraryPoolServiceImpl implements LibraryPoolService {

    @Autowired
    private LibraryPoolMapper libraryPoolMapper;
    @Autowired
    private SysLibraryLibraryPoolMapper sysLibraryLibraryPoolMapper;
    @Autowired
    private LibraryMapper libraryMapper;
    @Autowired
    private SubjectMapper subjectMapper;

    @Override
    public ListenResult getCurrentGradeSubjects(Integer grade, Integer userId, Integer checkPoint) {
        // get LibraryPool currentCheck id
        LibraryPool lp = libraryPoolMapper.selectLpByGradeAndCheck(grade, checkPoint);
        // 根据获取题库池中的题目
        List<SysLibraryLibraryPoolVo> vosList = sysLibraryLibraryPoolMapper.selectLibIdsByLpId(lp.getId());
        //获取开始时间
//        long startTime = System.currentTimeMillis();
        // 用于存放生成试卷的题目id
        List<Integer> libsList = new ArrayList<>(5);
        if (vosList.size() < 5) {
            return ListenResult.error("管理员未指定该等级的题库");
        } else if (vosList.size() == 5) {
            for (SysLibraryLibraryPoolVo vo : vosList) {
                libsList.add(vo.getLibId());
            }
        } else {
            // 取得5题
        }
        //获取选择题目计算时间
//        long chooseTime = System.currentTimeMillis();
//        System.out.println("chooseTime:\t" + (chooseTime - startTime));
        // 使用题库id 获得Library
        List<QueryLibraryVo> voList = new ArrayList<>();
        for (Integer libId : libsList) {
            QueryLibraryVo vo = libraryMapper.selectLibraryVo(libId);
            voList.add(vo);
        }
        // 获取题目计算时间
//        long getTime = System.currentTimeMillis();
//        System.out.println("getTime:\t" + (getTime - chooseTime));
        List<LibraryVo> libraryVos = MakeSubject.initSubject(voList, userId, checkPoint);
        // 试卷生成时间
//        long endTime = System.currentTimeMillis();
//        System.out.println("endTime:\t" + (endTime - getTime) + "\n");

        return null != libraryVos ? ListenResult.success(libraryVos) : ListenResult.error("服务器错误");
    }

    @Override
    public ListenResult selectPoolByGradeAndCheckPoint(LibraryPool libraryPool) {
        LibraryPool lp = libraryPoolMapper.selectLpByGradeAndCheck(libraryPool.getGrade(), libraryPool.getCheckPoint());
        return ListenResult.success(lp);
    }

    @Override
    public ListenResult updateLibraryPool(LibraryPool libraryPool) {
        libraryPoolMapper.updateByPrimaryKeySelective(libraryPool);
        return ListenResult.success(null);
    }

    @Override
    public ListenResult insertLibraryToLibraryPool(SysLibraryLibraryPool sysLibraryLibraryPool, Integer[] libIds) {
        for (Integer libId : libIds) {
            sysLibraryLibraryPool.setLibId(libId);
            sysLibraryLibraryPoolMapper.insert(sysLibraryLibraryPool);
        }
        return ListenResult.success(null);
    }

    @Override
    public ListenResult deleteLibraryInPool(SysLibraryLibraryPool sysLibraryLibraryPool, Integer[] libIds) {
        for (Integer libId : libIds) {
            sysLibraryLibraryPool.setLibId(libId);
            sysLibraryLibraryPoolMapper.delete(sysLibraryLibraryPool);
        }
        return ListenResult.success(null);
    }

    @Override
    public ListenResult queryLibraryListByPool(Integer lpId, Integer pageNum, Integer pageSize) {
        Example example = new Example(SysLibraryLibraryPool.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("lpId", lpId);
        PageHelper.startPage(pageNum, pageSize);
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

    @Override
    public ListenResult queryLibraryListByLibrary(Library library, Integer lpId, Integer pageNum, Integer pageSize) {
        if (null == lpId) {
            return ListenResult.error("查询条件缺失");
        }
        Map<String, Object> query = new HashMap<>(3);
        query.put("lpId", lpId);
        query.put("classDic", library.getClassDic());
        if (!StringUtils.isEmpty(library.getTitle())) {
            query.put("title", library.getTitle());
        }
        query.put("difficulty", library.getDifficulty());
        query.put("sonCount", library.getSonCount());
        List<Library> libraries = libraryPoolMapper.selectLPLibrary(query);
        PageInfo pageInfo = new PageInfo(libraries);
        return ListenResult.success(pageInfo);
    }


    private void test(LibraryPool lp, List<SysLibraryLibraryPoolVo> vosList) {
        int[] count = new int[]{
                0, 0, 0
        };
        // 统计
        for (SysLibraryLibraryPoolVo vo : vosList) {
            count[vo.getDifficulty() == 1 ? 1 : vo.getDifficulty() == 2 ? 2 : 3]++;
        }
        if (lp.getLibraryCount() == 5) {
//        三种题目分布模式 221 122 113
//        todo 前台推荐题库池按照5的倍数设置
        } else {
            // todo 未实现，好好的你改啥
        }
        Random r = new Random();
        switch (lp.getGrade()) {
            case 1:

                break;
            case 2:
                break;
            case 3:
            default:
        }
    }
}
