package com.listen.mapper;

import com.listen.pojo.Library;
import com.listen.pojo.vo.QueryLibraryVo;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author Exler
 */
public interface LibraryMapper extends Mapper<Library> {

    /**
     * 根据题目id 查询小题
     *
     * @param libId
     * @return
     */
    QueryLibraryVo selectLibraryVo(@Param("libId") Integer libId);

}
