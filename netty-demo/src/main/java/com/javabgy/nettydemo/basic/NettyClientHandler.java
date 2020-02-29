package com.javabgy.nettydemo.basic;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

/**
 * 客户端处理类
 *
 * @author Gary
 * @date 2020/2/29 01:18
 * @since jdk1.8
 **/
public class NettyClientHandler extends ChannelInboundHandlerAdapter {

    /**
     * 通道就绪事件
     *
     * @param ctx:
     * @return void
     * @author: Gary
     * @date: 2020/2/29 10:58
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("Client: " + ctx);
        ctx.writeAndFlush(Unpooled.copiedBuffer("老板还钱", CharsetUtil.UTF_8));
    }

    /**
     * 读取数据
     * @param ctx:
     * @param msg:
     * @return void
     * @author: Gary
     * @date: 2020/2/29 11:01
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf byteBuf = (ByteBuf) msg;
        System.out.println("服务器发来的消息：" + byteBuf.toString(CharsetUtil.UTF_8));
    }
}
