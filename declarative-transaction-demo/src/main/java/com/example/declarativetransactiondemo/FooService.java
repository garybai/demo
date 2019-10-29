package com.example.declarativetransactiondemo;


/**
 * @author Gary
 * @description: TODO
 * @date 2019-04-06 17:49
 */
public interface FooService {
    void insertRecord();

    void insertThenRollback() throws RollbackException;

    void invokeInsertThenRollback() throws RollbackException;
}
