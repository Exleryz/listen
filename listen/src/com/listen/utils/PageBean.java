package com.listen.utils;

import java.util.List;

public class PageBean {

    // 当前页数
    private Integer currentPage;
    // 总记录数
    private Integer totalCount;
    // 总页数
    private Integer totalPage;
    // 分页列表数据
    private List list;
    // 每页显示条数
    private Integer pageSize;


    public PageBean(Integer currentPage, Integer totalCount, Integer pageSize) {
        System.out.println("start");
        this.totalCount = totalCount;

        this.currentPage = currentPage;
        this.pageSize = pageSize;

        if (this.currentPage == null) {
            // 如果页面没有指定显示哪一页
            this.currentPage = 1;
        }
        if (this.pageSize == null) {
            this.pageSize = 3;
        }

        // 计算总页数
        this.totalPage = (this.totalCount + this.pageSize - 1) / this.pageSize;
        System.out.println(this.totalPage + "tc");
        // 判断当前页数是否超出范围
        // 不能小于1
        if (this.currentPage < 1) {
            this.currentPage = 1;
        }
        // 不能大于总页数
        if (this.currentPage > this.totalPage) {
            this.currentPage = totalPage;
        }
        System.out.println("end");
    }

    // 计算起始索引方法
    public int getStart() {
        return (this.currentPage - 1) * this.pageSize;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }
}
