package com.zjh.homework;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
/*
* 1.编程题Homework01.java 5min
(1)在判断e盘下是否有文件夹mytemp ,如果没有就创建mytemp
* (2)在e:lImytemp目录下，创建文件hello.txt
(3)如果hello.txt已经存在，提示该文件已经存在，就不要再重复创建Jawo
*/

public class Homework01 {
    public static void main(String[] args) throws IOException {
        String directoryPath = "D:\\mytemp";
        File dir = new File(directoryPath);
        if(!dir.exists()){
            dir.mkdir();
            System.out.println("创建目录成功");
        }else {
            System.out.println("目录存在");
        }
        String filePath = dir.getAbsolutePath()+"\\hello.txt";
        File file = new File(filePath);
        if(!file.exists()){
            if(file.createNewFile()){
                System.out.println("创建文件成功");
            }else {
                System.out.println("创建文件失败");
            }
        }else {
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            bw.write("蝴蝶结卡和数据库稍等哈及");
            bw.close();
            System.out.println("文件存在");
        }

    }
}
