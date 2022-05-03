package com.zjh.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {
    public static void main(String[] args) {
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        String filePath = "d:\\pic.png";
        String descPath = "d:\\pic2.png";
        try {
            fileInputStream = new FileInputStream(filePath);
            fileOutputStream = new FileOutputStream(descPath);
            byte[] buf = new byte[1024];
            int readLen  = 0;
            while((readLen = fileInputStream.read(buf)) != -1){
                fileOutputStream.write(buf,0,readLen);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(fileInputStream != null){
                    fileInputStream.close();
                }
                if(fileOutputStream != null){
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
}
}
