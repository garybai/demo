package com.example.unnameddemo.io.nio.chat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * chat 客户端
 *
 * @author Gary
 * @date 2020/2/28 18:22
 * @since jdk1.8
 **/
public class ChatClient {
    private static final String HOST = "127.0.0.1"; // 服务器地址
    private static final int PORT = 9999; // 服务器端口
    private SocketChannel socketChannel;
    private String username;

    public ChatClient() throws IOException {
        socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(false);
        InetSocketAddress address = new InetSocketAddress(HOST, PORT);
        if (!socketChannel.connect(address)) {
            while (!socketChannel.finishConnect()) {
                System.out.println("Client: 连接服务器");
            }
        }
        username = socketChannel.getLocalAddress().toString().substring(1);
        System.out.println("----Client " + username + " is ready");
    }

    public void sendMsg(String msg) throws IOException {
        if (msg.equalsIgnoreCase("bye")) {
            socketChannel.close();
            return;
        }
        msg = username + "说：" + msg;
        ByteBuffer buffer = ByteBuffer.wrap(msg.getBytes());
        socketChannel.write(buffer);
    }

    public void receiveMsg() throws IOException {
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        int read = socketChannel.read(buffer);
        if (read > 0) {
            String msg = new String(buffer.array());
            System.out.println(msg.trim());
        }
    }
}
