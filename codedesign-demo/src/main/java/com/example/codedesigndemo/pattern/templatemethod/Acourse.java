package com.example.codedesigndemo.pattern.templatemethod;

/**
 * 一节课程
 *
 * @author Gary
 * @date 2020/1/11 15:13
 * @since jdk1.8
 **/
public abstract class Acourse {

    public final void makeCourse(){
        this.makePPT();
        this.makeVideo();
        if (this.needWriteArticle()){
            this.writeArticle();
        }
        this.packageCourse();
    }

    public final void makePPT(){
        System.out.println("1. 制作ppt");
    }

    public final void makeVideo(){
        System.out.println("2. 制作视频");
    }

    public final void writeArticle(){
        System.out.println("3. 编写笔记");
    }

    public boolean needWriteArticle(){
        return false;
    }

    public abstract void packageCourse();
}
