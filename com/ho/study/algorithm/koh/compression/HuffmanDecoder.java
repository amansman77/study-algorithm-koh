package com.ho.study.algorithm.koh.compression;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class HuffmanDecoder {
    
    public static void main(String[] args) {
        HuffmanMethodWithRun app = new HuffmanMethodWithRun();
        String inputFileName = "/home/hshwang/workspace/study-algorithm-koh/com/ho/study/algorithm/koh/compression/input-data.z";
        String outputFileName = "/home/hshwang/workspace/study-algorithm-koh/com/ho/study/algorithm/koh/compression/input-data-decom.txt";
        try (RandomAccessFile fis = new RandomAccessFile(inputFileName, "r");
            RandomAccessFile fos = new RandomAccessFile(outputFileName, "rw")) {
            app.decompressFile(fis, fos);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
