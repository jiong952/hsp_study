package com.zjh.print;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PrintWriter_ {
    public static void main(String[] args) throws IOException {
        PrintWriter printWriter = new PrintWriter(new FileWriter("d:\\f2.txt"));
        printWriter.print("dasdasdass是是是~~~~");
//        printWriter.flush();
        printWriter.close();//flush + 关闭流, 才会将数据写入到文件..

    }
}
