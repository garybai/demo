package com.example.unnameddemo.io.bio;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务端
 *
 * @author Gary
 * @date 2020/2/28 10:59
 * @since jdk1.8
 **/
public class TCPServer {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);
        while (true) {
            Socket socket = serverSocket.accept();
            InputStream inputStream = socket.getInputStream();
            byte[] bytes = new byte[10];
            inputStream.read(bytes);
            String hostAddress = socket.getInetAddress().getHostAddress();
            System.out.println(hostAddress + ": " + new String(bytes).trim());
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write("aaa".getBytes());
            socket.close();
        }
    }
}
