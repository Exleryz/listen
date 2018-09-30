package com.listen.mapper;

import com.listen.pojo.Subject;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author Exler
 */
public interface SubjectMapper extends Mapper<Subject> {

    /**
     * 根据大题id查询题目
     *
     * @param libId
     * @return
     */
    List<Subject> selectSubjectsByLibId(@Param("libId") Integer libId);

}
