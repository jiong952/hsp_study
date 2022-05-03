package com.zjh.transformation;

import java.io.*;

public class InputStreamReader_ {
    public static void main(String[] args) throws IOException {
        String filePath = "d:\\a.txt";
        String charset = "gbk";
        //使用FileInputStream读取文件
        //使用InputStreamReader将字节流转为指定编码的字符流
        //使用BufferedReader提高读取效率
        BufferedReader br = new BufferedReader(
                new InputStreamReader(
                new FileInputStream(filePath), charset));
        String s = br.readLine();
        System.out.println(s);
        //关闭最外层即可
        br.close();
    }
}
