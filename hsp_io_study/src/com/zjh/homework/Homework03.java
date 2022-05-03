package com.zjh.homework;

import com.zjh.Cat;

import java.io.*;
import java.util.Properties;

/*
* ()要编写一个dog.properties
*   name=tom
    age=5
    color=red
(2)编写Dog类(name,age,color)创建一个dog对象，读取dog.properties用相应的内容完成属性初始化并输出
* (3)序列化到文件d:\\b.txt
*/
public class Homework03 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Properties pro = new Properties();
        pro.load(new FileReader("src\\cat.properties"));
        String name = pro.getProperty("name");
        int age =  Integer.parseInt(pro.getProperty("age"));
        String color = pro.getProperty("color");
        Cat cat = new Cat(age, name, color);
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("d:\\b.txt"));
        oos.writeObject(cat);
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("d:\\b.txt"));
        Cat cat2 = (Cat) ois.readObject();
        System.out.println(cat2);
        ois.close();
    }
}
