package com.example.unnameddemo.io.nio.chat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

/**
 * 聊天服务器端
 *
 * @author Gary
 * @date 2020/2/28 17:40
 * @since jdk1.8
 **/
public class ChatServer {
    private ServerSocketChannel listenerChannel; //监听通道
    private Selector selector; // 选择器对象
    private final static int PORT = 9999; // 监听端口

    public ChatServer() {
        try {
            listenerChannel = ServerSocketChannel.open();
            selector = Selector.open();
            listenerChannel.bind(new InetSocketAddress(PORT));
            listenerChannel.configureBlocking(false);
            listenerChannel.register(selector, SelectionKey.OP_ACCEPT);
            printLog("Chart Server is ready");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        try {
            while (true) {
                if (selector.select(2000) == 0) {
                    System.out.println("无客户端连接");
                    continue;
                }
                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                if (iterator.hasNext()) {
                    SelectionKey key = iterator.next();
                    if (key.isAcceptable()) {
                        SocketChannel socketChannel = listenerChannel.accept();
                        socketChannel.configureBlocking(false);
                        socketChannel.register(selector, SelectionKey.OP_READ);
                        System.out.println(socketChannel.getRemoteAddress()
                                .toString().substring(1) + "上线了");
                    }
                    if (key.isReadable()) {
                        readMsg(key);
                    }
                    iterator.remove();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readMsg(SelectionKey key) throws IOException {
        SocketChannel channel = (SocketChannel) key.channel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        int read = channel.read(buffer);

        if (read > 0) {
            String s = new String(buffer.array());
            printLog(s);
            broadCast(channel, s);
        }
    }

    private void broadCast(SocketChannel channel, String s) throws IOException {
        System.out.println("服务器发送广播");
        for (SelectionKey key : selector.keys()) {
            Channel targetChannel = key.channel();
            if (targetChannel instanceof SocketChannel && targetChannel != channel) {
                SocketChannel destChannel = (SocketChannel) targetChannel;
                ByteBuffer buffer = ByteBuffer.wrap(s.getBytes());
                destChannel.write(buffer);
            }
        }
    }

    private void printLog(String msg) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("[" + sdf.format(new Date()) + "] - " + msg);
    }

    public static void main(String[] args) {
        new ChatServer().start();
    }
}
