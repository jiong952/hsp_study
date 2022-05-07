package com.zjh.homework;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;

public class HomeWork02Receiver {
    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket(8888);
        System.out.println("等待客户端发送消息");
        byte[] bytes = new byte[1024];
        DatagramPacket packet = new DatagramPacket(bytes, bytes.length);
        datagramSocket.receive(packet);
        int length = packet.getLength();
        byte[] data1 = packet.getData();
        String s = new String(data1, 0, length);
        System.out.println(s);
        String replay;
        if(s.equals("四大名著")){
            replay = "是这些";
        }else {
            replay = "你说啥";
        }
        byte[] replayBytes = replay.getBytes(StandardCharsets.UTF_8);
        packet = new DatagramPacket(replayBytes,replayBytes.length, InetAddress.getByName("10.33.223.237"),9999);
        datagramSocket.send(packet);
        //关闭
        datagramSocket.close();
    }
}
