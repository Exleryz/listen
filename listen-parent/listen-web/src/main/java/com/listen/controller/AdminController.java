package com.listen.controller;

import com.listen.common.utils.ListenResult;
import com.listen.pojo.LibraryPool;
import com.listen.pojo.SysLibraryLibraryPool;
import com.listen.pojo.vo.QuerySULP;
import com.listen.pojo.vo.QuerySysStudentLibraryPoolVo;
import com.listen.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Exler
 */

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    AdminService adminService;

    @RequestMapping("/hello")
    public ListenResult hello() {
        return ListenResult.success(null);
    }

    /**
     * 学生历史做题数据查询
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("/queryHistory")
    public ListenResult queryHistory(QuerySysStudentLibraryPoolVo vo,
                                     @RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        List<QuerySULP> vos = adminService.queryHistory(vo, pageNum, pageSize);
        return ListenResult.success(vos);
    }

}
