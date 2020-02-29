package com.javabgy.nettydemo.basic;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

/**
 * 服务端处理类
 *
 * @author Gary
 * @date 2020/2/29 01:18
 * @since jdk1.8
 **/
public class NettyServerHandler extends ChannelInboundHandlerAdapter {

    /**
     * 读取数据事件
     *
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("Server: " + ctx);
        ByteBuf buf = (ByteBuf) msg;
        System.out.println("客户端发来消息：" + buf.toString(CharsetUtil.UTF_8));
    }

    /**
     * 数据读取完毕事件
     *
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.writeAndFlush(Unpooled.copiedBuffer("就是没钱", CharsetUtil.UTF_8));
    }

    /**
     * 异常发生事件
     *
     * @param ctx:
     * @param cause:
     * @return void
     * @author: Gary
     * @date: 2020/2/29 01:25
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}
