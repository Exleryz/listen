package com.listen.dao;

import com.listen.domain.Vocabulary;

import java.util.List;

public interface VocabularyDao {
    List<Vocabulary> getVocs(Integer grade, Integer count);
}
