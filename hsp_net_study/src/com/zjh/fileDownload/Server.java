package com.zjh.fileDownload;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("服务端正在等待连接......");
        Socket socket = serverSocket.accept();

        //接收文件名
        InputStream inputStream = socket.getInputStream();
        byte[] b = new byte[1024];
        int len = 0;
        String fileName = "";
        while ((len = inputStream.read(b)) != -1){
            fileName = new String(b,0,len);
        }
        //查找本地文件(?) 读取为字节数组
        String filePath = "";
        System.out.println(fileName);
        if(fileName.equals("图1")){
            System.out.println("pic1");
            filePath = "src\\pic1.png";
        }else {
            filePath = "src\\pic2.png";
        }
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(filePath));
        byte[] fileBytes = StreamUtils.streamToByteArray(bis);
        //发送文件
        OutputStream outputStream = socket.getOutputStream();
        BufferedOutputStream bos = new BufferedOutputStream(outputStream);
        bos.write(fileBytes);
        bos.flush();
        socket.shutdownOutput();

        //关闭流 退出
        bos.close();
        bis.close();
        socket.close();
        serverSocket.close();
        System.out.println("服务端退出.....");
    }
}
