package com.example.springaopdemo.service.impl;

import com.example.springaopdemo.service.IAccountService;

/**
 * AccountService
 *
 * @author Gary
 * @date 2020/1/29 11:00
 * @since jdk1.8
 **/
public class AccountServiceImpl implements IAccountService {
    @Override
    public void saveAccount() {
        System.out.println("保存账户。。。");
    }

    @Override
    public void updateAccount(int i) {
        System.out.println("更新账户：" + i);
    }

    @Override
    public int deleteAccount() {
        System.out.println("删除账户。。。");
        return 0;
    }
}
