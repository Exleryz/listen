package com.listen.mapper;

import com.listen.pojo.Library;
import com.listen.pojo.LibraryPool;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @author Exler
 */
public interface LibraryPoolMapper extends Mapper<LibraryPool> {

    /**
     * 根据 等级关卡获取 题库池对象
     *
     * @param grade
     * @param checkPoint
     * @return
     */
    LibraryPool selectLpByGradeAndCheck(@Param("grade") Integer grade, @Param("checkPoint") Integer checkPoint);

    /**
     * 根据条件查询 题库池中的题目
     */
    List<Library> selectLPLibrary(Map map);
}
