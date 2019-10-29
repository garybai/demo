package com.example.declarativetransactiondemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName FooServiceImpl
 * @Description TODO
 * @Author Gary
 * @Date 2019-04-06 17:54
 **/
@Component
public class FooServiceImpl implements FooService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // 注入自身代理对象，在本类内部方法调用事务的传递性才会生效
    @Autowired
    private FooService selfFooService;

    @Override
    @Transactional
    public void insertRecord() {
        jdbcTemplate.execute("INSERT INTO FOO (BAR) VALUES ('AAA')");
    }

    @Override
    @Transactional(rollbackFor = RollbackException.class)
    public void insertThenRollback() throws RollbackException {
        jdbcTemplate.execute("INSERT INTO FOO (BAR) VALUES ('BBB')");
        throw new RollbackException();
    }

    @Override
    @Transactional(rollbackFor = RollbackException.class)
    public void invokeInsertThenRollback() throws RollbackException {
//        insertThenRollback();
        selfFooService.insertThenRollback();
    }
}
