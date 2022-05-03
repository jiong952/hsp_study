package com.zjh.Buffer;

import java.io.*;

public class BufferStreamCopy {
    public static void main(String[] args) {
        String fromPath = "d:\\pic.png";
        String toPath = "d:\\pic2.png";
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            bis = new BufferedInputStream(new FileInputStream(fromPath));
            bos = new BufferedOutputStream(new FileOutputStream(toPath));
            byte[] buf = new byte[1024];
            int readLen  = 0;
            while ((readLen = bis.read(buf)) != -1){
                bos.write(buf,0,readLen);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(bis != null){
                    bis.close();
                }
                if(bos != null){
                    bos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
