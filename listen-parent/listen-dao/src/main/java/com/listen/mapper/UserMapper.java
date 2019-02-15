package com.listen.mapper;

import com.listen.pojo.SysLibraryLibraryPool;
import com.listen.pojo.User;
import com.listen.pojo.vo.QuerySULP;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @author Exler
 */
public interface UserMapper extends Mapper<User> {

    List<QuerySULP> queryHistory(Map<String,Object> query);

}
