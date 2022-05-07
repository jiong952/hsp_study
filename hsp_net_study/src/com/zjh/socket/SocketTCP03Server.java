package com.zjh.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketTCP03Server {
    public static void main(String[] args) throws IOException {
        //服务器端ServerSocket 监听9999端口
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务端，在9999端口监听，等待连接..");
        //监听到后获得此时的socket
        Socket socket = serverSocket.accept();
        System.out.println("服务端连接 socket =" + socket.getClass());
        //IO读取
        InputStream inputStream = socket.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        String s = br.readLine();
        System.out.println(s);

        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(outputStream));
        bw.write("hello client");
        //可以使用bw.newLine()写入输出结束标记，但是要用br.readLine()才能读取到输出结束标记
//        bw.newLine();
        bw.flush();
        //表示输出结束
        socket.shutdownOutput();

        //关闭流
        bw.close();
        br.close();
        socket.close();
        serverSocket.close();
        System.out.println("服务端退出.....");
    }
}
