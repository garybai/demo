package com.example.declarativetransactiondemo;

public interface BarService {
    void invokeInsertThenRollback() throws RollbackException;
}
