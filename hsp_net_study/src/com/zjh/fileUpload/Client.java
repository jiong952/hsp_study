package com.zjh.fileUpload;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket(InetAddress.getLocalHost(), 8888);
        System.out.println("客户端连接成功......");
        //先读取照片
        String filePath = "D:\\pic.png";
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(filePath));
        //使用工具类通过ByteArrayOutputStream将照片文件输出为字节数组
        byte[] fileByte = StreamUtils.streamToByteArray(bis);
        //把照片字节数组通过OutputStream发送
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write(fileByte);
        socket.shutdownOutput();

        //接收响应消息
        InputStream inputStream = socket.getInputStream();
        String s = StreamUtils.streamToString(inputStream);
        System.out.println(s);

        //关闭流 后开的先关闭
        outputStream.close();
        bis.close();
        socket.close();
    }
}
