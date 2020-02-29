package com.javabgy.nettydemo.chat;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * 聊天客户端处理类
 *
 * @author Gary
 * @date 2020/2/29 16:11
 * @since jdk1.8
 **/
public class ChatClientHandler extends SimpleChannelInboundHandler<String> {
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, String s) throws Exception {
        System.out.println(s.trim());
    }
}
