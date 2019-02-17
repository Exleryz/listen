package com.listen.controller;

import com.listen.common.utils.ListenResult;
import com.listen.pojo.ClassDic;
import com.listen.pojo.Library;
import com.listen.pojo.User;
import com.listen.pojo.vo.QueryLibraryVo;
import com.listen.service.ClassDicService;
import com.listen.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Exler
 */

@Controller
@RequestMapping("/library")
public class LibraryController {

    @Autowired
    private LibraryService libraryService;

    @Autowired
    private ClassDicService classDicService;

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

    /**
     * 管理员上传听力文件 及题目 子题s
     *
     * @param library
     * @param audioFile
     * @param request
     * @return
     */
    @RequestMapping(value = "/admin/upload", method = RequestMethod.POST)
    @ResponseBody
    public ListenResult upload(Library library, MultipartFile audioFile, HttpServletRequest request) {
        User user = (User) request.getAttribute("user");
        library.setUserId(user.getId());
        if (audioFile != null) {
//            if ("".equals(listenLibraryFileName) || listenLibraryFileName == null) {
//                 生成名称 或使用title
//                 查询数据库中题目名称是否存在
//            }
//            String path = ServletActionContext.getServletContext().getRealPath("/file/test");
//            int i = listenLibraryFileName.lastIndexOf(".");
//            String name = listenLibraryFileName.substring(0, i);
//            String suffix = listenLibraryFileName.substring(i, listenLibraryFileName.length());
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
//            name = name + sdf.format(new Date());
//             保存文件
//            File f = new File(path + "/" + name + suffix);
//            listenLibrary.renameTo(f);
//             设置文件路径
//            library.setSrc("/file/test/" + name + suffix);
//             保存题目信息及其子题
//            libraryService.saveLibrary(library, subjectList);
        }
        return null;
    }

    /**
     * 获取所有题目列表(V2 添加条件查询) 分页
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("/queryList")
    @ResponseBody
    public ListenResult queryLibraryList(Library library, @RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "10") Integer pageSize) {
        return libraryService.queryLibraryList(library, pageNum, pageSize);
    }

    /**
     * 删除题目
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("/admin/deleteLibrary")
    @ResponseBody
    public ListenResult deleteLibrary(Library library) throws Exception {
        if (null == library.getId()) {
            return ListenResult.error("参数错误，删除失败");
        }
        return libraryService.deleteLibrary(library);
    }

    /**
     * 修改题目
     *
     * @return
     */
    @RequestMapping("/editLibrary")
    @ResponseBody
    public ListenResult editLibrary(QueryLibraryVo vo) {
        return libraryService.updateLibrary(vo);
    }

    /**
     * 获取题目分类
     */
    @RequestMapping("/getClassDic")
    @ResponseBody
    public ListenResult getClassDic() {
        return ListenResult.success(classDicService.getAll());
    }

    /**
     * 添加题目分类
     */
    @RequestMapping("/addClassDic")
    @ResponseBody
    public ListenResult addClassDic(ClassDic classDic) {
        return classDicService.addClassDic(classDic);
    }

    /**
     * 删除题目分类
     */
    @RequestMapping("/delectClassDic")
    @ResponseBody
    public ListenResult delectClassDic(ClassDic classDic) {
        return classDicService.deleteClassDic(classDic);

    }
}
