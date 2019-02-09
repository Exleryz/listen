package com.listen.controller;

import com.listen.common.utils.ListenResult;
import com.listen.pojo.LibraryPool;
import com.listen.pojo.SysLibraryLibraryPool;
import com.listen.pojo.User;
import com.listen.service.LibraryPoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public ListenResult initSubject(Integer checkPoint, HttpServletRequest request) {
        User user = (User) request.getAttribute("user");
        if (null == user.getGrade() || null == checkPoint) {
            return ListenResult.error("试卷加载异常");
        }
        ListenResult result = libraryPoolService.getCurrentGradeSubjects(user.getGrade(), user.getId(), checkPoint);
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
    public ListenResult getCurrentScoreSet(LibraryPool libraryPool) {
        if (null == libraryPool.getGrade() || null == libraryPool.getCheckPoint()) {
            return ListenResult.error("查询参数错误");
        }
        return libraryPoolService.selectPoolByGradeAndCheckPoint(libraryPool);
    }

    /**
     * 查找题库池中所有题目
     *
     * @param lpId
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping("/queryList")
    @ResponseBody
    public ListenResult queryList(Integer lpId, Integer pageNum, Integer pageSize) {
        if (null == lpId) {
            return ListenResult.error("获取题目列表错误");
        }
        return libraryPoolService.queryLibraryListByPool(lpId, pageNum, pageSize);
    }

    /**
     * 设置当前选中关卡
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("/admin/updateLibraryPool")
    @ResponseBody
    public ListenResult updateLibraryPool(LibraryPool libraryPool) throws Exception {
        if (null == libraryPool.getId()) {
            return ListenResult.error("参数错误");
        }
        return libraryPoolService.updateLibraryPool(libraryPool);
    }

    /**
     * 管理员给关卡添加题目
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("/admin/addLibrary")
    @ResponseBody
    public ListenResult addLibrary(SysLibraryLibraryPool sysLibraryLibraryPool, @RequestParam(value = "libIds", defaultValue = "0") Integer[] libIds) {
        if (null == libIds || libIds.length == 0 || null == sysLibraryLibraryPool.getLpId()) {
            return ListenResult.error("参数错误， 无法添加");
        }
        return libraryPoolService.insertLibraryToLibraryPool(sysLibraryLibraryPool, libIds);
    }

    /**
     * 管理员删除关卡中的题目
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("/admin/deleteLibrary")
    @ResponseBody
    public ListenResult deleteLibraryInPool(SysLibraryLibraryPool sysLibraryLibraryPool, @RequestParam(value = "libIds", defaultValue = "0") Integer[] libIds) {
        if (null == sysLibraryLibraryPool.getLpId() || null == libIds || libIds.length == 0) {
            return ListenResult.error("参数错误，无法删除");
        }
        return libraryPoolService.deleteLibraryInPool(sysLibraryLibraryPool, libIds);
    }

}
