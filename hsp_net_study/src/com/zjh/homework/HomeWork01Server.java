package com.zjh.homework;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class HomeWork01Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务端，在9999端口监听，等待连接..");
        Socket socket = serverSocket.accept();
        //接收消息
        InputStream inputStream = socket.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        String s = br.readLine();
        System.out.println(s);
        //回消息
        String replay;
        if(s.equals("name")){
            replay = "我是nova";
        }else if (s.equals("hobby")){
            replay = "编写java程序";
        }else {
            replay = "你说啥呢";
        }
        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(outputStream));
        bw.write(replay);
        bw.flush();
        socket.shutdownOutput();
        //关闭流
        bw.close();
        br.close();
        socket.close();
        serverSocket.close();
        System.out.println("服务端退出.....");
    }
}
