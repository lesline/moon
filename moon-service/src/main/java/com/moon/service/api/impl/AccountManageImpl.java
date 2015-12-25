package com.moon.service.api.impl;

import com.moon.service.api.AccountManage;
import org.springframework.stereotype.Service;

/**
 * Created by win7 on 2015/12/25.
 */
@Service(value = "accountManageImpl")
public class AccountManageImpl implements AccountManage {
    @Override
    public  String getAccountNameByAccountNo(String accountNo){
        return "账户号:"+accountNo+" 账户名：张三";
    }
}
