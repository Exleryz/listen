package com.listen.web.action;

import com.listen.domain.LibraryPool;
import com.listen.service.CheckService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;

public class CheckAction extends ActionSupport implements ModelDriven<LibraryPool> {

    private LibraryPool libraryPool = new LibraryPool();
    private CheckService checkService;
    private String currentCheck;
    private String currentGrade;


    /**
     * 设置当前选中关卡 form
     *
     * @return
     * @throws Exception
     */
    @Override

    public String execute() throws Exception {
        checkService.setLibraryPool(libraryPool);
        return super.execute();
    }

    /**
     * 管理员给关卡添加题目 由题目选择页面跳转
     *
     * @return
     * @throws Exception
     */
    public String addLibToLP() throws Exception {
        String lpId = ServletActionContext.getRequest().getParameter("lpId");
        String lId = ServletActionContext.getRequest().getParameter("lId");
        String[] lIdsStr = lId.split(",");
        Integer[] lIds = new Integer[lIdsStr.length];
        for (int i = 0; i < lIdsStr.length; i++) {
            lIds[i] = Integer.parseInt(lIdsStr[i]);
        }
        checkService.saveLibToLibPool(Integer.parseInt(lpId), lIds);
        // 根据lpid 查询 lp对象
        LibraryPool lp = checkService.getLPByLPId(Integer.parseInt(lpId));
        currentCheck = lp.getCheckPoint().toString();
        currentGrade = lp.getGrade().toString();
        return "showLibraryDet";    // 重新跳转到 关卡详情页面
    }

    /**
     * 管理员删除关卡中的题目
     *
     * @return
     * @throws Exception
     */
    public String delLibInLibPool() throws Exception {
        String lpId = ServletActionContext.getRequest().getParameter("lpId");
        String lId = ServletActionContext.getRequest().getParameter("lId");
        checkService.deleteLibByLibPool(Integer.parseInt(lpId), Integer.parseInt(lId));
        return super.execute();    // 重新跳转到 关卡详情页面
    }


    public CheckService getCheckService() {
        return checkService;
    }

    public void setCheckService(CheckService checkService) {
        this.checkService = checkService;
    }

    public String getCurrentCheck() {
        return currentCheck;
    }

    public void setCurrentCheck(String currentCheck) {
        this.currentCheck = currentCheck;
    }

    public String getCurrentGrade() {
        return currentGrade;
    }

    public void setCurrentGrade(String currentGrade) {
        this.currentGrade = currentGrade;
    }

    @Override
    public LibraryPool getModel() {
        return libraryPool;
    }
}
