package com.listen.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *  * **************************************************************
 *  * 公司名称    :杭州大猷网络科技有限公司
 *  * 系统名称    :大猷金融平台-spring cloud2 最新架构版 v1.10
 *  * 类 名 称    :
 *  * 功能描述    :
 *  * 业务描述    : Date操作工具类
 *  * 作 者 名    :@Author Exleryz(叶舟)
 *  * 开发日期    :2019/2/8 21:20
 *  * Created     :IntelliJ IDEA
 *  * **************************************************************
 *  * 修改日期    :
 *  * 修 改 者    :
 *  * 修改内容    :
 *  * **************************************************************
 *  
 */
public class DateUtils {

    public final static String YYYYMMDDHHMMSS = "yyyy-MM-dd HH:mm:ss";
    public final static String YYYYMMDD = "yyyy-MM-dd";

    /**
     * 根据规则获取date的string
     *
     * @param date
     * @param pattern
     * @return
     */
    public static String DateToString(Date date, String pattern) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        return simpleDateFormat.format(date);
    }
}
