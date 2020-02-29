package com.javabgy.nettydemo.basic;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * 客户端
 *
 * @author Gary
 * @date 2020/2/29 01:16
 * @since jdk1.8
 **/
public class NettyClient {

    public static void main(String[] args) throws InterruptedException {

        // 1. 创建线程组
        EventLoopGroup group = new NioEventLoopGroup();
        // 2. 创建客户端启动助手，完成相关配置
        Bootstrap b = new Bootstrap();
        b.group(group) // 3.设置线程组
                .channel(NioSocketChannel.class) //4.设置客户端通道实现
                .handler(new ChannelInitializer<SocketChannel>() { //5.创建一个通道初始化对象
                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        // 6. 往pipeline中加入自定义handler
                        socketChannel.pipeline().addLast(new NettyClientHandler());
                    }
                });
        System.out.println("Client is ready");
        // 7. 启动客户端去连接服务器（异步非阻塞）
        ChannelFuture future = b.connect("127.0.0.1", 9999).sync();
        // 8. 关闭连接（异步非阻塞）
        future.channel().closeFuture().sync();

    }
}
