package com.example.unnameddemo.classloader;

import java.io.*;

/**
 * 自定义类加载器
 *
 * @author Gary
 * @date 2020/3/20 11:55
 * @since jdk1.8
 **/
public class TestClassLoader extends ClassLoader {


    private String name;

    public TestClassLoader(ClassLoader parent, String name) {
        super(parent);
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public Class<?> findClass(String name) {

        InputStream is = null;
        byte[] data = null;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            is = new FileInputStream(new File("/Users/Gary/Documents/IdeaProjects/demo/unnamed-demo/target/classes/com/example/unnameddemo/classloader/Test.class"));
            int c = 0;
            while (-1 != (c = is.read())) {
                baos.write(c);
            }
            data = baos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                assert is != null;
                is.close();
                baos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return this.defineClass(name, data, 0, data.length);
    }

    public static void main(String[] args) {
        TestClassLoader loader = new TestClassLoader(
                TestClassLoader.class.getClassLoader(), "TestLoader");
        Class clazz;
        try {
            clazz = loader.loadClass("com.example.unnameddemo.classloader.Test");
            Object object = clazz.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
