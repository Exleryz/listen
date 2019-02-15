package com.listen.service.impl;

import com.listen.mapper.ClassDicMapper;
import com.listen.pojo.ClassDic;
import com.listen.service.ClassDicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *  * **************************************************************
 *  * 公司名称    :杭州大猷网络科技有限公司
 *  * 系统名称    :大猷金融平台-spring cloud2 最新架构版 v1.10
 *  * 类 名 称    :
 *  * 功能描述    :
 *  * 业务描述    :
 *  * 作 者 名    :@Author Exleryz(叶舟)
 *  * 开发日期    :2019/2/15 16:56
 *  * Created     :IntelliJ IDEA
 *  * **************************************************************
 *  * 修改日期    :
 *  * 修 改 者    :
 *  * 修改内容    :
 *  * **************************************************************
 *  
 */

@Service
public class ClassDicServiceImpl implements ClassDicService {

    @Autowired
    ClassDicMapper classDicMapper;


    @Override
    public List<ClassDic> getAll() {
        return classDicMapper.selectAll();
    }
}
