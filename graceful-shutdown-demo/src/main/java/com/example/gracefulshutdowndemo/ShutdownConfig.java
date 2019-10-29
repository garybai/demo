//package com.example.gracefulshutdowndemo;
//
//import com.sun.jdi.connect.Connector;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;
//import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
//import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
//import org.springframework.context.ApplicationListener;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.event.ContextClosedEvent;
//
//import java.util.concurrent.Executor;
//import java.util.concurrent.ThreadPoolExecutor;
//import java.util.concurrent.TimeUnit;
//
///**
// * @author Gary
// * @className ShutdownConfig
// * @description TODO
// * @date 2019-09-18 10:29
// **/
//@Configuration
//public class ShutdownConfig {
//
//    /**
//     * 用于接受shutdown事件
//     * @return
//     */
//    /**
//     * 9     * 用于接受 shutdown 事件
//     * 10
//     */
//    @Bean
//    public GracefulShutdown gracefulShutdown() {
//        return new GracefulShutdown();
//    }
//
//    @Bean
//    public ServletWebServerFactory servletContainer() {
//        TomcatServletWebServerFactory tomcatServletWebServerFactory = new TomcatServletWebServerFactory();
//        tomcatServletWebServerFactory.addConnectorCustomizers(gracefulShutdown());
//        return tomcatServletWebServerFactory;
//    }
//
//
//    private class GracefulShutdown implements TomcatConnectorCustomizer, ApplicationListener<ContextClosedEvent> {
//        private final Logger logger = LoggerFactory.getLogger(GracefulShutdown.class);
//        private volatile Connector connector;
//        private final int waitTime = 10;
//
//
//        public void customize(Connector connector) {
//            this.connector = connector;
//        }
//
//        @Override
//        public void onApplicationEvent(ContextClosedEvent contextClosedEvent) {
//            this.connector.pause();
//            Executor executor = this.connector.getProtocolHandler().getExecutor();
//            try {
//                if (executor instanceof ThreadPoolExecutor) {
//                    ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) executor;
//                    threadPoolExecutor.shutdown();
//                    if (!threadPoolExecutor.awaitTermination(waitTime, TimeUnit.SECONDS)) {
//                        logger.warn("Tomcat 进程在" + waitTime + " 秒内无法结束，尝试强制结束");
//                    }
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//                Thread.currentThread().interrupt();
//            }
//
//
//        }
//    }
//
//}
