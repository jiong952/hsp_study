package com.zjh.udp;

import java.io.IOException;
import java.net.*;

public class UDPSenderB {
    public static void main(String[] args) throws IOException {
        //这里为了模拟不同主机选择不同端口
        DatagramSocket socket = new DatagramSocket(9998);
        byte[] data = "hello,明天吃火锅".getBytes();
        DatagramPacket packet = new DatagramPacket(data, data.length, InetAddress.getByName("10.33.223.237"), 9999);
        //发送消息
        socket.send(packet);
        //接收消息
        byte[] buf = new byte[1024];
        packet = new DatagramPacket(buf, buf.length);
        socket.receive(packet);
        //拆包
        int length = packet.getLength();
        byte[] msg_back = packet.getData();
        System.out.println(new String(msg_back,0,length));
        //关闭资源
        socket.close();
        System.out.println("B端退出");

    }
}
