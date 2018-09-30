package com.listen.service.impl;

import com.listen.mapper.IntegralMapper;
import com.listen.pojo.Integral;
import com.listen.pojo.User;
import com.listen.service.IntegralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Exler
 */
@Service
public class IntegralServiceImpl implements IntegralService {

    @Autowired
    private IntegralMapper integralMapper;

    @Override
    public void operateIntegral(User user, Integral integral) {
        integral.setUserId(user.getId());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        integral.setGetTime(sdf.format(new Date()));
        integralMapper.insert(integral);
    }

}
