package com.listen.dao;

import com.listen.dao.base.BaseDao;
import com.listen.domain.Vocabulary;

import java.util.List;

public interface VocabularyDao extends BaseDao<Vocabulary> {
    List<Vocabulary> getVocs(Integer grade, Integer count);
}
