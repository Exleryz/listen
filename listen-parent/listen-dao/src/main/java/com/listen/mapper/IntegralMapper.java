package com.listen.mapper;

import com.listen.pojo.Integral;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author Exler
 */
public interface IntegralMapper extends Mapper<Integral> {

    Integer getUserSumIntegral(@Param("userId") Integer userId);
}
