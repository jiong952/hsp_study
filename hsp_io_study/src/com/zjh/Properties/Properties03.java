package com.zjh.Properties;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class Properties03 {
    public static void main(String[] args) throws IOException {
        //使用Properties 类来创建 配置文件, 修改配置文件内容
        Properties properties = new Properties();

        properties.setProperty("charset", "utf8");
        properties.setProperty("user", "汤姆");//注意保存时，是中文的 unicode码值
        properties.setProperty("pwd", "888888");

        //将k-v 存储文件中即可
//        properties.store(new FileOutputStream("src\\mysql2.properties"), "注释");
        properties.store(new FileWriter("src\\mysql2.properties"), "注释");

        System.out.println("保存配置文件成功~");
    }
}
