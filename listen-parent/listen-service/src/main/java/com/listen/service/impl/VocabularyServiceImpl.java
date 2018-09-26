package com.listen.service.impl;

import com.github.pagehelper.PageHelper;
import com.listen.common.utils.ListenResult;
import com.listen.common.utils.MakeSubject;
import com.listen.common.vo.GradeSubject;
import com.listen.mapper.VocabularyMapper;
import com.listen.pojo.Vocabulary;
import com.listen.service.VocabularyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author Exler
 */
@Service
public class VocabularyServiceImpl implements VocabularyService {

    @Autowired
    private VocabularyMapper vocabularyMapper;

    @Override
    public ListenResult initGradetest() {
        List<Vocabulary> list1 = vocabularyMapper.getVocs(1, 20);
        list1.addAll(vocabularyMapper.getVocs(2, 30));
//        list1.addAll(vocabularyDao.getVocs(3, 10));
        List<GradeSubject> gradeSubjects = MakeSubject.initTestJson(list1);
        return ListenResult.success(gradeSubjects);
    }
}
