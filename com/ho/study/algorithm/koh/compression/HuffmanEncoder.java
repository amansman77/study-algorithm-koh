package com.ho.study.algorithm.koh.compression;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

class HuffmanEncoder {

    public static void main(String[] args) {
        HuffmanMethodWithRun app = new HuffmanMethodWithRun();
        String inputFileName = "/home/hshwang/workspace/study-algorithm-koh/com/ho/study/algorithm/koh/compression/input-data.txt";
        String outputFileName = "/home/hshwang/workspace/study-algorithm-koh/com/ho/study/algorithm/koh/compression/input-data.z";
        try (FileInputStream fis = new FileInputStream(inputFileName);
            RandomAccessFile fos = new RandomAccessFile(outputFileName, "rw")) {
            app.compressFile(fis, fos);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}