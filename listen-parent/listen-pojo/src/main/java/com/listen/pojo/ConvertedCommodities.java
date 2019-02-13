package com.listen.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *  * **************************************************************
 *  * 公司名称    :杭州大猷网络科技有限公司
 *  * 系统名称    :大猷金融平台-spring cloud2 最新架构版 v1.10
 *  * 类 名 称    :
 *  * 功能描述    : 积分兑换商品类
 *  * 业务描述    :
 *  * 作 者 名    :@Author Exleryz(叶舟)
 *  * 开发日期    :2019/2/13 19:45
 *  * Created     :IntelliJ IDEA
 *  * **************************************************************
 *  * 修改日期    :
 *  * 修 改 者    :
 *  * 修改内容    :
 *  * **************************************************************
 *  
 */

@Table(name = "ConvertedCommodities")
public class ConvertedCommodities {

    @Id
    @Column(name = "id")
    private Integer id;

    /**
     * 商品名称
     */
    @Column(name = "commodityName")
    private String commodityName;

    /**
     * 剩余数量
     */
    @Column(name = "surplusQuantity")
    private Integer surplusQuantity;

    /**
     * 所需积分
     */
    @Column(name = "requiredIntegral")
    private Integer requiredIntegral;

    /**
     * 修改时间
     */
    @Column(name = "gmtModified")
    private String gmtModified;

    /**
     * 创建时间
     */
    @Column(name = "gmtCreate")
    private String gmtCreate;

    /**
     * 是否上架
     */
    @Column(name = "isGrounding")
    private Integer isGrounding;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    public Integer getSurplusQuantity() {
        return surplusQuantity;
    }

    public void setSurplusQuantity(Integer surplusQuantity) {
        this.surplusQuantity = surplusQuantity;
    }

    public Integer getRequiredIntegral() {
        return requiredIntegral;
    }

    public void setRequiredIntegral(Integer requiredIntegral) {
        this.requiredIntegral = requiredIntegral;
    }

    public String getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(String gmtModified) {
        this.gmtModified = gmtModified;
    }

    public String getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(String gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Integer getIsGrounding() {
        return isGrounding;
    }

    public void setIsGrounding(Integer isGrounding) {
        this.isGrounding = isGrounding;
    }
}
