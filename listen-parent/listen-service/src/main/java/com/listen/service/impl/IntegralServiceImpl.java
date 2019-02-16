package com.listen.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.listen.common.utils.DateUtils;
import com.listen.common.utils.ListenResult;
import com.listen.mapper.IntegralMapper;
import com.listen.pojo.Integral;
import com.listen.service.IntegralService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author Exler
 */
@Service
public class IntegralServiceImpl implements IntegralService {

    @Autowired
    private IntegralMapper integralMapper;

    @Override
    public Boolean operateIntegral(Integral integral) {
        if (StringUtils.isEmpty(integral.getGetWay()) || null == integral.getNum()
                || StringUtils.isEmpty(integral.getGetWay())) {
            return false;
        }
        integral.setGetTime(DateUtils.DateToString(new Date(), DateUtils.YYYYMMDDHHMMSS));
        integralMapper.insert(integral);
        return true;
    }

    @Override
    public Integer getUserSumIntegral(Integer userId) {
        return integralMapper.getUserSumIntegral(userId);
    }

    @Override
    public ListenResult getIntegralHistory(Integer userId, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize, "id");
        List<Integral> integrals = integralMapper.select(new Integral(userId));
        PageInfo pageInfo = new PageInfo(integrals);
        return ListenResult.success(pageInfo);
    }

}
