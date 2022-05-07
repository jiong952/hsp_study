package com.zjh.homework;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class HomeWork01Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        System.out.println("连接成功");
        //读取用户指令
        Scanner scanner = new Scanner(System.in);
        String question = scanner.next();
        //发送数据
        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(outputStream));
        bw.write(question);
        bw.flush();
        socket.shutdownOutput();
        //接收数据
        InputStream inputStream = socket.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        String s = br.readLine();
        System.out.println(s);
        //关闭流
        br.close();
        bw.close();
        socket.close();
        System.out.println("客户端退出......");
    }
}
