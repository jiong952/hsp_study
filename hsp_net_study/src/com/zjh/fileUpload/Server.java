package com.zjh.fileUpload;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("服务端正在等待连接......");
        Socket socket = serverSocket.accept();

        //接收图片
        InputStream inputStream = socket.getInputStream();
        BufferedInputStream bis = new BufferedInputStream(inputStream);

        //转为字节数组
        byte[] fileByte = StreamUtils.streamToByteArray(bis);
        //使用FileOutputStream输出到src:\pic.png
        String filePath = "D:\\pic22.png";
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath));
        bos.write(fileByte);

        //发送消息
        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(outputStream));
        bw.write("收到图片 上传成功");
        bw.newLine();
        bw.flush();

        //关闭流 退出
        bw.close();
        bos.close();
        bis.close();
        socket.close();
        serverSocket.close();
    }
}
