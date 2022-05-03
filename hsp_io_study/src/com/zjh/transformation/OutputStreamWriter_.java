package com.zjh.transformation;

import java.io.*;

public class OutputStreamWriter_ {
    public static void main(String[] args) throws IOException {
        String filePath = "d:\\hsp.txt";
        String charSet = "gbk";
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath), charSet));
        bw.write("hi, 韩顺平教育");
        bw.close();
        System.out.println("按照 " + charSet + " 保存文件成功~");
    }
}
