package com.listen.pojo;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 *  * **************************************************************
 *  * 公司名称    :杭州大猷网络科技有限公司
 *  * 系统名称    :大猷金融平台-spring cloud2 最新架构版 v1.10
 *  * 类 名 称    :
 *  * 功能描述    :
 *  * 业务描述    :
 *  * 作 者 名    :@Author Exleryz(叶舟)
 *  * 开发日期    :2019/2/15 16:42
 *  * Created     :IntelliJ IDEA
 *  * **************************************************************
 *  * 修改日期    :
 *  * 修 改 者    :
 *  * 修改内容    :
 *  * **************************************************************
 *  
 */

@Table(name = "ClassDic")
public class ClassDic {

    @Id
    private Integer id;

    private String className;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
