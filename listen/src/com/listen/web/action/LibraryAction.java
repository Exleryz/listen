package com.listen.web.action;

import com.listen.dao.LibraryDao;
import com.listen.domain.Library;
import com.listen.domain.Student;
import com.listen.domain.Subject;
import com.listen.service.LibraryService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;

import java.io.File;
import java.util.List;

public class LibraryAction extends ActionSupport implements ModelDriven<Library> {

    private Library library = new Library();

    private File listenLibrary;
    private String listenLibraryFileName;
    private String listenLibraryContentType;
    private List<Subject> subjectList;

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
        System.out.println(library);
        System.out.println(subjectList.get(0));
        if (listenLibrary != null) {
            if ("".equals(listenLibraryFileName) || listenLibraryFileName == null) {
                // 生成名称 或使用title
                // 查询数据库中题目名称是否存在
            }
            String path = ServletActionContext.getServletContext().getRealPath("/file/test");
            String listenLibraryName = listenLibrary.getName();
            // 保存文件
//            listenLibrary.renameTo(new File(path + "/" + listenLibraryFileName));
            // 设置文件路径

            // 保存题目信息及其子题
            libraryService.saveLibrary(library, subjectList);
        }
        return super.execute();
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

    public LibraryService getLibraryService() {
        return libraryService;
    }

    public void setLibraryService(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @Override
    public Library getModel() {
        return library;
    }
}
