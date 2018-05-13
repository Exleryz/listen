package com.listen.web.action;

import com.listen.domain.LibraryPool;
import com.listen.service.CheckService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class CheckAction extends ActionSupport implements ModelDriven<LibraryPool> {

    private LibraryPool libraryPool = new LibraryPool();
    private CheckService checkService;

    /**
     * 设置当前选中关卡 form
     * @return
     * @throws Exception
     */
    @Override
    public String execute() throws Exception {
        checkService.setLibraryPool(libraryPool);

        return super.execute();
    }


    public CheckService getCheckService() {
        return checkService;
    }

    public void setCheckService(CheckService checkService) {
        this.checkService = checkService;
    }

    @Override
    public LibraryPool getModel() {
        return libraryPool;
    }
}
