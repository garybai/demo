package com.example.unnameddemo.io.nio.chat;

import java.io.IOException;
import java.util.Scanner;

/**
 * chat 测试类
 *
 * @author Gary
 * @date 2020/2/28 18:31
 * @since jdk1.8
 **/
public class ChatTest1 {

    public static void main(String[] args) throws IOException {
        ChatClient chatClient = new ChatClient();
        new Thread(){
            @Override
            public void run(){
                while (true) {
                    try {
                        chatClient.receiveMsg();
                        Thread.sleep(2000);
                    } catch (IOException | InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String s = scanner.nextLine();
            chatClient.sendMsg(s);
        }
    }
}
