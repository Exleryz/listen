package com.listen.controller;

import com.listen.common.utils.ListenResult;
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


//    /**
//     * 显示关卡的详情信息
//     *
//     * @return
//     * @throws Exception
//     */
//    public String seeDetails() throws Exception {
//        String currentCheck = ServletActionContext.getRequest().getParameter("currentCheck");
//        String currentGrade = ServletActionContext.getRequest().getParameter("currentGrade");
//        LibraryPool libraryPool = adminService.getSetByGAndC(Integer.parseInt(currentCheck), Integer.parseInt(currentGrade));
//        ActionContext.getContext().put("lp", libraryPool);
//        return "toDetails";
//    }


    /**
     * 学生历史做题数据查询
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("/queryHistory")
    public ListenResult queryHistory(QuerySysStudentLibraryPoolVo vo,
                                     @RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        // 传入的查询参数
        // 学生姓名 学号 分数(大于 小于) 时间戳 等级 关数
        // 默认查 测试


        List<QuerySULP> vos = adminService.queryHistory(vo, pageNum, pageSize);

        return ListenResult.success(vos);
    }

}
