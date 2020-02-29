package com.example.unnameddemo.io.nio.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * nio
 *
 * @author Gary
 * @date 2020/2/28 14:47
 * @since jdk1.8
 **/
public class FileNioTest {

    public static void main(String[] args) throws IOException {
//        write();
//        read();
        copy();
    }

    public static void write() throws IOException {
        // 1. 得到输出流
        FileOutputStream fos = new FileOutputStream("/Users/Gary/Desktop/source.txt");
        // 2. 从流中得到一个通道
        FileChannel channel = fos.getChannel();
        // 3. 提供一个缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        // 4. 往缓冲区传入数据
        String s = "hello, nio";
        buffer.put(s.getBytes());
        // 5. 反转缓冲区
        buffer.flip();
        // 6. 把缓冲区写入到通道
        channel.write(buffer);
        // 7. 关闭流
        fos.close();
    }

    public static void read() throws IOException {
        File file = new File("/Users/Gary/Desktop/source.txt");
        // 1. 得到一个输入流
        FileInputStream fis = new FileInputStream(file);
        // 2. 从流中得到一个通道
        FileChannel channel = fis.getChannel();
        // 3. 准备一个缓冲区
        ByteBuffer buffer = ByteBuffer.allocate((int) file.length());
        // 4. 从通道读取数据并存入缓冲区
        channel.read(buffer);
        System.out.println(new String(buffer.array()));
        // 5. 关闭流
        fis.close();
    }

    public static void copy() throws IOException {
        // 1. 创建两个流
        FileInputStream fis = new FileInputStream("/Users/Gary/Desktop/source.txt");
        FileOutputStream fos = new FileOutputStream("/Users/Gary/Desktop/target.txt");
        // 2. 得到两个通道
        FileChannel sourceChannel = fis.getChannel();
        FileChannel targetChannel = fos.getChannel();
        // 3. 复制（从sourceChannel复制到targetChannel）
//        targetChannel.transferFrom(sourceChannel, 0, sourceChannel.size());
        sourceChannel.transferTo(0, sourceChannel.size(), targetChannel);
        // 4. 关闭流
        fis.close();
        fos.close();
    }
}
