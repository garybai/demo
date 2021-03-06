package com.example.druiddemo;

import com.alibaba.druid.filter.FilterChain;
import com.alibaba.druid.filter.FilterEventAdapter;
import com.alibaba.druid.proxy.jdbc.ConnectionProxy;
import lombok.extern.slf4j.Slf4j;

import java.util.Properties;

/**
 * @ClassName ConnectionLogFilter
 * @Description TODO
 * @Author Gary
 * @Date 2019-04-06 00:36
 **/
@Slf4j
public class ConnectionLogFilter extends FilterEventAdapter {


    @Override
    public void connection_connectBefore(FilterChain chain, Properties info) {
        log.info("before connection");
    }

    @Override
    public void connection_connectAfter(ConnectionProxy connection) {
        log.info("after connection");
    }
}
