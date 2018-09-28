package com.listen.mapper;

import com.listen.pojo.SysLibraryLibraryPool;
import com.listen.pojo.vo.SysLibraryLibraryPoolVo;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author Exler
 */
public interface SysLibraryLibraryPoolMapper extends Mapper<SysLibraryLibraryPool> {

    /**
     * 根据题库池id 查找所有的大题id
     *
     * @param lpId
     * @return
     */
    List<SysLibraryLibraryPoolVo> selectLibIdsByLpId(@Param("lpId") Integer lpId);
}
