package com.javabgy.nettydemo.basic;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * 服务器端
 *
 * @author Gary
 * @date 2020/2/29 01:16
 * @since jdk1.8
 **/
public class NettyServer {

    public static void main(String[] args) throws InterruptedException {

        // 1. 创建一个线程组，接口客户端连接
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        // 2. 创建一个线程组，处理网络操作
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        // 3. 创建服务器端启动助手来配置参数
        ServerBootstrap b = new ServerBootstrap();
        b.group(bossGroup, workerGroup) //4. 设置两个线程池
                .channel(NioServerSocketChannel.class) // 5. 设置服务器端通道实现
                .option(ChannelOption.SO_BACKLOG, 128) // 6. 设置线程队列中等待连接的数量
                .childOption(ChannelOption.SO_KEEPALIVE, true) //7.保持活动连接状态
                .childHandler(new ChannelInitializer<SocketChannel>() { // 8.创建一个通道初始化对象
                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        // 9.往pipeline中加入自定义的handler
                        socketChannel.pipeline().addLast(new NettyServerHandler());
                    }
                });
        System.out.println("Netty Server is ready...");
        ChannelFuture future = b.bind(9999).sync();// 10.绑定端口，非阻塞
        System.out.println("Netty Server is started");

        // 11.关闭通道，关闭线程组
        future.channel().closeFuture().sync();
        bossGroup.shutdownGracefully();
        workerGroup.shutdownGracefully();

    }
}
