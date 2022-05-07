package com.zjh.socket;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class SocketTCP03Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        System.out.println("客户端 socket返回=" + socket.getClass());
        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(outputStream));
        bw.write("hello server");
        //可以使用bw.newLine()写入输出结束标记，但是要用br.readLine()才能读取到输出结束标记
//        bw.newLine();
        bw.flush();
//        //表示输出结束
        socket.shutdownOutput();

        InputStream inputStream = socket.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        String s = br.readLine();
        System.out.println(s);

        br.close();
        bw.close();
        socket.close();
        System.out.println("客户端退出.....");
    }
}
