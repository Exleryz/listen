package com.listen.controller;

import com.listen.common.utils.ListenResult;
import com.listen.pojo.LibraryPool;
import com.listen.pojo.User;
import com.listen.service.LibraryPoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Exler
 */

@Controller
@RequestMapping("/libraryPool")
public class LibraryPoolController {

    @Autowired
    private LibraryPoolService libraryPoolService;

    /**
     * ajax 加载听力试卷
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("/initSubject")
    @ResponseBody
    public ListenResult initSubject(Integer checkPoint, HttpServletRequest request) throws Exception {
        User user = (User) request.getAttribute("user");
        if (null == user.getGrade() || null == checkPoint) {
            return ListenResult.error("试卷加载异常");
        }
        ListenResult result = libraryPoolService.getCurrentGradeSubjects(user.getGrade(), checkPoint);
        return result;
    }

    /**
     * 查看当前关卡设置
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("/getSetting")
    @ResponseBody
    public ListenResult getCurrentScoreSet(LibraryPool libraryPool) throws Exception {
        if (null == libraryPool.getGrade() || null == libraryPool.getCheckPoint()) {
            return ListenResult.error("查询参数错误");
        }
        return libraryPoolService.selectPoolByGradeAndCheckPoint(libraryPool);
    }
}
