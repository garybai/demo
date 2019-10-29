package com.example.declarativetransactiondemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName BarServiceImpl
 * @Description TODO
 * @Author Gary
 * @Date 2019-04-06 18:10
 **/
@Service
public class BarServiceImpl implements BarService {

    @Autowired
    private FooService fooService;

    @Override
    @Transactional(rollbackFor = RollbackException.class)
    public void invokeInsertThenRollback() throws RollbackException {
        fooService.insertThenRollback();
        throw new RollbackException();
    }
}
