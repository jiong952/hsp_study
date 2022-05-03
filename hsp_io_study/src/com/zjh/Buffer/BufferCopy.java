package com.zjh.Buffer;

import java.io.*;

public class BufferCopy {
    public static void main(String[] args) {
        String fromPath = "d:\\a.txt";
        String toPath = "d:\\a2.txt";
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            br = new BufferedReader(new FileReader(fromPath));
            bw = new BufferedWriter(new FileWriter(toPath));
            String line;
            while ((line = br.readLine()) != null){
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(br != null){
                    br.close();
                }
                if(bw != null){
                    bw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
