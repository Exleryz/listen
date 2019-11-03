package com.listen.controller;

import com.listen.common.utils.ListenResult;
import com.listen.pojo.ClassDic;
import com.listen.pojo.Library;
import com.listen.pojo.Subject;
import com.listen.pojo.User;
import com.listen.pojo.vo.QueryLibraryVo;
import com.listen.service.ClassDicService;
import com.listen.service.LibraryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @author Exler
 */

@Controller
@RequestMapping("/library")
@Slf4j
public class LibraryController {

    @Autowired
    private LibraryService libraryService;

    @Autowired
    private ClassDicService classDicService;

    @Value("${audio.file.postfix}")
    private String POSTFIX;

    @Value("${audio.file.savePath}")
    private String SAVE_PATH;

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
     * @param audioFile
     * @param request
     * @return
     */
    @RequestMapping(value = "/admin/upload", method = RequestMethod.POST)
    @ResponseBody
    public ListenResult upload(Integer count, @RequestParam(value = "audioFile") CommonsMultipartFile audioFile, HttpServletRequest request) throws IOException {
        List<Subject> subjectList = new ArrayList<>();
        Map parameterMap = request.getParameterMap();
        String[] optionA = (String[]) parameterMap.get("optionA");
        String[] optionB = (String[]) parameterMap.get("optionB");
        String[] optionC = (String[]) parameterMap.get("optionC");
        String[] optionD = (String[]) parameterMap.get("optionD");
        Character[] answer = (Character[]) parameterMap.get("answer");
        Integer[] sort = (Integer[]) parameterMap.get("sort");

        String title = (String) parameterMap.get("title");
        Integer difficulty = (Integer) parameterMap.get("difficulty");
        Integer classDic = (Integer) parameterMap.get("classDic");

        for (int i = 0; i < count; count++) {
            Subject subject = new Subject();
            subject.setOptionA(optionA[i]);
            subject.setOptionA(optionB[i]);
            subject.setOptionA(optionC[i]);
            subject.setOptionA(optionD[i]);
            subject.setAnswer(answer[i]);
            subject.setSort(sort[i]);

            subjectList.add(subject);
        }
        User user = (User) request.getAttribute("user");
        Library library = new Library();
        library.setTitle(title);
        library.setDifficulty(difficulty);
        library.setClassDic(classDic);

        library.setUserId(user.getId());
        if (audioFile != null) {
            String postfix = audioFile.getOriginalFilename().substring(audioFile.getOriginalFilename().lastIndexOf("."));
            if (!POSTFIX.contains(postfix)) {
                return ListenResult.error("不支持的文件类型");
            }

            if (StringUtils.isEmpty(library.getTitle())) {
                library.setTitle(audioFile.getOriginalFilename());
            }

            UUID uuid = UUID.randomUUID();
            String fileName = uuid.toString().replace("-", "");
            // 设置文件路径
            library.setSrc(SAVE_PATH + fileName + postfix);
            audioFile.transferTo(new File(request.getSession().getServletContext().getRealPath(SAVE_PATH) + fileName + postfix));

            // 保存题目信息及其子题
            return libraryService.saveLibrary(library, subjectList);
        }
        return ListenResult.error("文件保存出错");
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
