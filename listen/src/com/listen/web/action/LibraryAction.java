package com.listen.web.action;

import com.listen.domain.Library;
import com.listen.domain.Student;
import com.listen.domain.Subject;
import com.listen.service.LibraryService;
import com.listen.utils.PageBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * FileName LibraryAction
 * Created by Exler
 * Time 2018-08-30 14:27
 * Description:
 */

@Controller
@Scope("prototype")
public class LibraryAction extends ActionSupport implements ModelDriven<Library> {

    private Library library = new Library();

    private File listenLibrary;
    private String listenLibraryFileName;
    private String listenLibraryContentType;
    private List<Subject> subjectList;

    @Autowired
    private LibraryService libraryService;

    /**
     * 管理员上传听力文件 及题目 子题s
     *
     * @return
     * @throws Exception
     */
    public String upload() throws Exception {
        Student admin = (Student) ActionContext.getContext().getSession().get("admin");
        library.setTeacher(admin);
        if (listenLibrary != null) {
            if ("".equals(listenLibraryFileName) || listenLibraryFileName == null) {
                // 生成名称 或使用title
                // 查询数据库中题目名称是否存在
            }
            String path = ServletActionContext.getServletContext().getRealPath("/file/test");
            int i = listenLibraryFileName.lastIndexOf(".");
            String name = listenLibraryFileName.substring(0, i);
            String suffix = listenLibraryFileName.substring(i, listenLibraryFileName.length());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
            name = name + sdf.format(new Date());
            // 保存文件
            File f = new File(path + "/" + name + suffix);
            listenLibrary.renameTo(f);
            // 设置文件路径
            library.setSrc("/file/test/" + name + suffix);
            // 保存题目信息及其子题
            libraryService.saveLibrary(library, subjectList);
        }
        return null;
    }

    /**
     * ajax 查询名称是否存在
     *
     * @return
     * @throws Exception
     */
    public String findTitleIsExists() throws Exception {
        String filename = ServletActionContext.getRequest().getParameter("filename");

        return null;
    }

    /**
     * 获取所有题目列表 分页
     *
     * @return
     * @throws Exception
     */
    public String getAllLibraries() throws Exception {
        String currentPage = ServletActionContext.getRequest().getParameter("currentPage");
        System.out.println(currentPage);
        if ("".equals(currentPage) || currentPage == null) {
            currentPage = "0";
        }
        PageBean pb = libraryService.getCurrentPageBean(Integer.parseInt(currentPage), 10);
        ActionContext.getContext().put("pageBean", pb);
        return "librariesList";
    }

    /**
     * 删除题目 ajax
     *
     * @return
     * @throws Exception
     */
    public String deleteLibrary() throws Exception {
        String libraryId = ServletActionContext.getRequest().getParameter("libraryId");
        if (libraryService.deleteLibrary(Integer.parseInt(libraryId))) {
            ServletActionContext.getResponse().getWriter().write("success");
        } else {
            ServletActionContext.getResponse().getWriter().write("error");
        }
        return null;
    }

    /**
     * 修改题目(未完成)
     *
     * @return
     * @throws Exception
     */
    public String execute() throws Exception {
        String libraryId = ServletActionContext.getRequest().getParameter("libraryId");

        return super.execute();
    }

    public File getListenLibrary() {
        return listenLibrary;
    }

    public void setListenLibrary(File listenLibrary) {
        this.listenLibrary = listenLibrary;
    }

    public String getListenLibraryFileName() {
        return listenLibraryFileName;
    }

    public void setListenLibraryFileName(String listenLibraryFileName) {
        this.listenLibraryFileName = listenLibraryFileName;
    }

    public String getListenLibraryContentType() {
        return listenLibraryContentType;
    }

    public void setListenLibraryContentType(String listenLibraryContentType) {
        this.listenLibraryContentType = listenLibraryContentType;
    }

    public List<Subject> getSubjectList() {
        return subjectList;
    }

    public void setSubjectList(List<Subject> subjectList) {
        this.subjectList = subjectList;
    }

    @Override
    public Library getModel() {
        return library;
    }
}

