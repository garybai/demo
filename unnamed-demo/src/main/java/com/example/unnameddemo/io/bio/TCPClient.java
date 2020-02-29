package com.example.unnameddemo.io.bio;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * 客户端
 *
 * @author Gary
 * @date 2020/2/28 11:07
 * @since jdk1.8
 **/
public class TCPClient {
    public static void main(String[] args) throws IOException {
        while (true) {
            Socket socket = new Socket("127.0.0.1", 8888);
            OutputStream outputStream = socket.getOutputStream();
            System.out.println("请输入:");
            Scanner scanner = new Scanner(System.in);
            String s = scanner.nextLine();
            outputStream.write(s.getBytes());
            InputStream inputStream = socket.getInputStream();
            byte[] bytes = new byte[10];
            inputStream.read(bytes);
            System.out.println("老板说：" + new String(bytes).trim());
            socket.close();
        }
    }
}
