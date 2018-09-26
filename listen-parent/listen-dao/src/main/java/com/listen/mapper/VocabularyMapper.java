package com.listen.mapper;

import com.listen.pojo.Vocabulary;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author Exler
 */
public interface VocabularyMapper extends Mapper<Vocabulary> {

    /**
     * 根据词汇等级获取一定数量的词汇
     *
     * @param grade
     * @param num
     * @return
     */
    List<Vocabulary> getVocs(@Param("grade") int grade, @Param("num") int num);
}
