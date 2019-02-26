package com.listen.common.utils;

import java.util.Date;
import java.util.UUID;

/**
 *  * **************************************************************
 *  * 公司名称    :杭州大猷网络科技有限公司
 *  * 系统名称    :大猷金融平台-spring cloud2 最新架构版 v1.10
 *  * 类 名 称    :
 *  * 功能描述    : 文件名打散
 *  * 业务描述    :
 *  * 作 者 名    :@Author Exleryz(叶舟)
 *  * 开发日期    :2019/2/26 16:58
 *  * Created     :IntelliJ IDEA
 *  * **************************************************************
 *  * 修改日期    :
 *  * 修 改 者    :
 *  * 修改内容    :
 *  * **************************************************************
 *  
 */

public class GenerateFileNameUtils {

    public static String generateFileName() {
        UUID uuid = UUID.randomUUID();
        return DateUtils.DateToString(new Date(), DateUtils.YYYYMMDDFOLDER) + uuid.toString();
    }

    public static void main(String[] args) {
        System.out.println(generateFileName());
    }

}
