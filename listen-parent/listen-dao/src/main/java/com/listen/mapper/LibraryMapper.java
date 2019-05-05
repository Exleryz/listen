package com.listen.mapper;

import com.listen.pojo.Library;
import com.listen.pojo.vo.QueryLibraryVo;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

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

    /**
     * 查询符合条件的题目
     *
     * @param map
     * @return
     */
    List<Library> selectLibraryList(Map map);

    /**
     * 插入library setId
     *
     * @param library
     * @return
     */
    Integer insertLibrary(Library library);

}
