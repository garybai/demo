package com.javabgy.nettydemo.chat;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * 聊天服务端处理类
 *
 * @author Gary
 * @date 2020/2/29 15:42
 * @since jdk1.8
 **/
public class ChatServerHandler extends SimpleChannelInboundHandler<String> {

    public static List<Channel> channels = new ArrayList<>();

    /**
     * 通道就绪
     *
     * @param ctx:
     * @return void
     * @author: Gary
     * @date: 2020/2/29 15:44
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        channels.add(channel);
        System.out.println("[Server]:" + channel.remoteAddress().toString().substring(1) + "上线了");
    }

    /**
     * 通道未就绪
     *
     * @param ctx:
     * @return void
     * @author: Gary
     * @date: 2020/2/29 15:47
     */
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        channels.remove(channel);
        System.out.println("[Server]:" + channel.remoteAddress().toString().substring(1) + "下线了");
    }

    /**
     * 读取数据
     *
     * @param channelHandlerContext:
     * @param s:
     * @return void
     * @author: Gary
     * @date: 2020/2/29 15:48
     */
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, String s) throws Exception {
        Channel channel = channelHandlerContext.channel();
        channels.forEach(c -> {
            if (c != channel) {
                c.writeAndFlush("[" + channel.remoteAddress().toString().substring(1) + "]:" + s + "\n");
            }
        });
    }
}
