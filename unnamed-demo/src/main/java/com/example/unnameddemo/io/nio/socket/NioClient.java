package com.example.unnameddemo.io.nio.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * nio客户端
 *
 * @author Gary
 * @date 2020/2/28 15:44
 * @since jdk1.8
 **/
public class NioClient {
    public static void main(String[] args) throws IOException {

        // 1. 得到一个网路通道
        SocketChannel channel = SocketChannel.open();
        // 2. 设置非阻塞方式
        channel.configureBlocking(false);
        // 3. 提供服务器ip和port
        InetSocketAddress address = new InetSocketAddress("127.0.0.1", 9999);
        // 4. 链接服务器端
        if (!channel.connect(address)) {
            while (!channel.finishConnect()) {
                System.out.println("Client:链接服务器端的同时，还可以干别的事情");
            }
        }
        // 5. 得到一个缓冲区并存入数据
        String msg = "hello, sever";
        ByteBuffer buffer = ByteBuffer.wrap(msg.getBytes());

        // 6. 发送数据
        channel.write(buffer);

        System.in.read();


    }
}
