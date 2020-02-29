package com.example.unnameddemo.io.nio.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * nio 服务端
 *
 * @author Gary
 * @date 2020/2/28 15:57
 * @since jdk1.8
 **/
public class NioServer {
    public static void main(String[] args) throws IOException {

        // 1. 得到一个serverSocketChannel
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        // 2. 得到一个selector对象
        Selector selector = Selector.open();

        // 3. 绑定端口号
        serverSocketChannel.bind(new InetSocketAddress(9999));

        // 4. 设置非阻塞方式
        serverSocketChannel.configureBlocking(false);

        // 5. 把serverSocketChannel注册给selector对象
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        // 6. 干活
        while (true) {
            // 6.1 监控客户端
            if (selector.select(2000)==0) {
                System.out.println("Server：没有客户端链接，可以干些其他事情");
                continue;
            }
            // 6.2 得到selectionkey，判断通道里的事件
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while (iterator.hasNext()){
                SelectionKey selectionKey = iterator.next();
                // 客户端连接事件
                if (selectionKey.isAcceptable()){
                    System.out.println("OP_ACCEPT");
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    socketChannel.configureBlocking(false);
                    socketChannel.register(selector, SelectionKey.OP_READ, ByteBuffer.allocate(1024));
                }
                // 读取客户端事件
                if (selectionKey.isReadable()){
                    System.out.println("OP_READ");
                    SocketChannel channel = (SocketChannel) selectionKey.channel();
                    ByteBuffer buffer = (ByteBuffer) selectionKey.attachment();
                    channel.read(buffer);
                    System.out.println("客户端发来数据：" + new String(buffer.array()));
                }

                // 6.3 手动从集合中移除当前的key，防止重复处理
                iterator.remove();

            }


        }


    }
}
