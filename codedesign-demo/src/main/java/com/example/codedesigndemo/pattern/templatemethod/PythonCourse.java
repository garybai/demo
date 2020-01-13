package com.example.codedesigndemo.pattern.templatemethod;

/**
 * Python课程
 *
 * @author Gary
 * @date 2020/1/11 15:20
 * @since jdk1.8
 **/
public class PythonCourse extends Acourse {
    private boolean needWriteArticleFlag = false;

    public PythonCourse(boolean needWriteArticleFlag) {
        this.needWriteArticleFlag = needWriteArticleFlag;
    }

    @Override
    public void packageCourse() {
        System.out.println("4. 提供Python课程源代码");
    }

    @Override
    public boolean needWriteArticle() {
        return this.needWriteArticleFlag;
    }
}
