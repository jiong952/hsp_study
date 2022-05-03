package com.zjh.homework;

import java.io.*;

/*
* 要求:使用BufferedReader读取一个文本文件，为每行加上行号,再连同内容一并输出到屏幕上。
 */
public class Homework02 {
    public static void main(String[] args) throws IOException {
        String path = "d:\\a.txt";
        File file = new File(path);
        String charset = "gbk";
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file),charset));
        String line;
        int id = 1;
        while ((line = br.readLine()) != null){
            System.out.println(id++ +":"+line);
        }
        br.close();
    }
}
