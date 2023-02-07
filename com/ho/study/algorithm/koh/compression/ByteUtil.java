package com.ho.study.algorithm.koh.compression;

public class ByteUtil {

    public static String getBinaryString(byte b) {
        return String.format("%8s", Integer.toBinaryString(b & 0xFF)).replace(' ', '0');
    }

}
