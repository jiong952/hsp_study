package com.zjh.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketTCP02Server {
    public static void main(String[] args) throws IOException {
        //服务器端ServerSocket 监听9999端口
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务端，在9999端口监听，等待连接..");
        //监听到后获得此时的socket
        Socket socket = serverSocket.accept();
        System.out.println("服务端连接 socket =" + socket.getClass());
        //IO读取
        InputStream inputStream = socket.getInputStream();
        byte[] buf = new byte[1024];
        int readLen = 0;
        while ((readLen = inputStream.read(buf)) != -1){
            System.out.println(new String(buf,0,readLen));
        }

        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("hello client".getBytes());
        //表示输出结束
        socket.shutdownOutput();

        //关闭流
        inputStream.close();
        socket.close();
        serverSocket.close();
        System.out.println("服务端退出.....");
    }
}
