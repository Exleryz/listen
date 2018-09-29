package com.listen.controller;

import com.listen.common.utils.ListenResult;
import com.listen.pojo.Library;
import com.listen.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Exler
 */

@Controller
@RequestMapping("/library")
public class LibraryController {

    @Autowired
    private LibraryService libraryService;

    @RequestMapping("/queryList")
    @ResponseBody
    public ListenResult queryList(Integer lpId, Integer pageNum, Integer pageSize) {
        if (null == lpId) {
            return ListenResult.error("获取题目列表错误");
        }
        return libraryService.queryLibraryList(lpId, pageNum, pageSize);
    }

    /**
     * 单题详情查看
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("/queryLibrary")
    @ResponseBody
    public ListenResult getLibraryDetails(Integer libId) {
        if (null == libId) {
            return ListenResult.error("查询失败");
        }
        return libraryService.getLibrary(libId);
    }
}
