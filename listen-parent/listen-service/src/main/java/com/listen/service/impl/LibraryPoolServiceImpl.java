package com.listen.service.impl;

import com.listen.common.utils.ListenResult;
import com.listen.common.utils.MakeSubject;
import com.listen.common.vo.LibraryVo;
import com.listen.mapper.LibraryMapper;
import com.listen.mapper.LibraryPoolMapper;
import com.listen.mapper.SubjectMapper;
import com.listen.mapper.SysLibraryLibraryPoolMapper;
import com.listen.pojo.Library;
import com.listen.pojo.LibraryPool;
import com.listen.pojo.Subject;
import com.listen.pojo.vo.SysLibraryLibraryPoolVo;
import com.listen.service.LibraryPoolService;
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
    public ListenResult getCurrentGradeSubjects(Integer grade, Integer checkId) {
        // get LibraryPool currentCheck id

        LibraryPool lp = libraryPoolMapper.selectLpByGradeAndCheck(grade, checkId);
        // 根据获取题库池中的题目
        List<SysLibraryLibraryPoolVo> vosList = sysLibraryLibraryPoolMapper.selectLibIdsByLpId(lp.getId());
        //获取开始时间
        long startTime = System.currentTimeMillis();
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
        long chooseTime = System.currentTimeMillis();
        System.out.println("chooseTime:\t" + (chooseTime - startTime));
        // 使用题库id 获得Library
        List<Library> libraries = new ArrayList<>();
        Map<Integer, List<Subject>> subjectsMap = new HashMap<>();
        for (Integer libId : libsList) {
            Library library = libraryMapper.selectByPrimaryKey(libId);
            libraries.add(library);
            // 根据大题id 获取所有小题
            Example example = new Example(Subject.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("libId", libId);
            example.orderBy("sort");
            List<Subject> subjects = subjectMapper.selectByExample(example);
            subjectsMap.put(libId, subjects);
        }
        // 获取题目计算时间
        long getTime = System.currentTimeMillis();
        System.out.println("getTime:\t" + (getTime - chooseTime));
        List<LibraryVo> libraryVos = MakeSubject.initSubject(libraries, subjectsMap);
        // 试卷生成时间
        long endTime = System.currentTimeMillis();
        System.out.println("endTime:\t" + (endTime - getTime)+"\n");

        return null != libraryVos ? ListenResult.success(libraryVos) : ListenResult.error("服务器错误");
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
