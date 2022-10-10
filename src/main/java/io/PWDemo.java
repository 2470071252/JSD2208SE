package io;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class PWDemo {
    public static void main(String[] args) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter("pw.txt");
        pw.println("让我掉下眼泪的，不止昨夜的酒");
        pw.println("让我依依不舍的，不止……");
        System.out.println("写出完毕!");
        pw.close();
    }
}
