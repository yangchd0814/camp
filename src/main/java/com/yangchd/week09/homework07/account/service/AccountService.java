package com.yangchd.week09.homework07.account.service;

import com.yangchd.week09.homework07.account.entity.Account;
import org.dromara.hmily.annotation.Hmily;

public interface AccountService {

    /**
     * 美元账户和人民币账户交易
     * @param account account
     * @return bool
     */
    @Hmily
    boolean pay(Account account);
}
