package com.zjh.fileDownload;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket(InetAddress.getLocalHost(), 8888);
        System.out.println("客户端连接成功......");
        //读取文件名
        System.out.println("请输入文件名");
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.next();
        //发送文件名
        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(outputStream));
        bw.write(fileName);
        bw.flush();
        socket.shutdownOutput();
        //读取文件
        InputStream inputStream = socket.getInputStream();
        byte[] file = StreamUtils.streamToByteArray(inputStream);
        //存储文件到D:\\
        String filePath = "D:\\receive.png";
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath));
        bos.write(file);
        System.out.println("写入成功");
        bos.flush();

        //关闭流 后开的先关闭
        bos.close();
        inputStream.close();
        bw.close();
        socket.close();
        System.out.println("客户端退出.....");
    }
}
