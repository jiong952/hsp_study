package com.zjh.print;

import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

public class PrintStream_ {
    public static void main(String[] args) throws IOException {
        PrintStream out =  System.out;
        out.print("");
        out.write("张俊鸿".getBytes());
        out.close();

        System.setOut(new PrintStream("d:\\hh.txt"));
        PrintStream out2 =  System.out;
        out2.println("的阖家安康和接口大");
        out2.close();
    }
}
