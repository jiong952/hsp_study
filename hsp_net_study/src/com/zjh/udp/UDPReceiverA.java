package com.zjh.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPReceiverA {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(9999);
        byte[] buf = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buf, buf.length);
        System.out.println("接收端A等待接收数据..");
        //阻塞等待接收
        socket.receive(packet);
        //拆包
        int length = packet.getLength();
        byte[] data = packet.getData();
        System.out.println(new String(data,0,length));

        //回发消息
        byte[] msg = "那明天见~".getBytes();
        packet = new DatagramPacket(msg, msg.length, InetAddress.getByName("10.33.223.237"), 9998);
        socket.send(packet);
        //关闭资源
        socket.close();
        System.out.println("A端退出");
    }
}
