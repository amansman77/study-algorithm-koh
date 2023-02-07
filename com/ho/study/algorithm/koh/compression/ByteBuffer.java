package com.ho.study.algorithm.koh.compression;

import java.io.IOException;
import java.io.RandomAccessFile;

public class ByteBuffer {

    private byte buffer;
    private int length;

    public ByteBuffer() {
        this.buffer = 0x00;
        this.length = 0;
    }

    public ByteBuffer(byte buffer, int length) {
        this.buffer = buffer;
        this.length = length;
    }

    public int pack(int codeword, int codewordLength) {
        int availableSize = 8 - this.length;
        int shiftSize = codewordLength;
        if (codewordLength > availableSize) {
            shiftSize = availableSize;
        }

        this.buffer = (byte) (this.buffer << shiftSize);
        // System.out.println("buffer: " + ByteUtil.getBinaryString(this.buffer));

        byte mask = 0x00;
        mask = (byte) (mask | (codeword >> (codewordLength - shiftSize)));
        // System.out.println("mask: " + ByteUtil.getBinaryString(mask));

        this.buffer = (byte) (buffer | mask);
        // System.out.println("buffer: " + ByteUtil.getBinaryString(this.buffer));

        this.length += shiftSize;
        return shiftSize;
    }

    private String printBinary() {
        return ByteUtil.getBinaryString(this.buffer);
    }

    public void write(RandomAccessFile fout) throws IOException {
        fout.writeByte(this.buffer);
    }

    public void set(byte data, int length) {
        this.buffer = 0x00;

        byte tmpBuffer = (byte) (data << 8 - length);
        // System.out.println("tmpBuffer: " + ByteUtil.getBinaryString(tmpBuffer));

        for (int i = 0; i < 8-length; i++) {
            tmpBuffer = (byte) (tmpBuffer >>> 1);
            tmpBuffer = (byte) (0x7F & tmpBuffer);
        }
        this.buffer = tmpBuffer;
        // System.out.println("buffer: " + ByteUtil.getBinaryString(this.buffer));
        this.length = length;
    }

    public void padding() {
        this.buffer = (byte) (this.buffer << 8 - length);
        this.length = 8;
    }

    public boolean isEmpty() {
        return this.length == 0;
    }

    public static void main(String[] args) {
        ByteBuffer byteBuffer = new ByteBuffer();
        byte codeword = 2;
        int codewordLength = 2;
        System.out.println("input: " + ByteUtil.getBinaryString(codeword));
        int shiftSize = byteBuffer.pack(codeword, codewordLength);
        System.out.println("shift: " + shiftSize + ", " + byteBuffer.printBinary());

        codeword = 7;
        codewordLength = 3;
        System.out.println("input: " + ByteUtil.getBinaryString(codeword));
        shiftSize = byteBuffer.pack(codeword, codewordLength);
        System.out.println("shift: " + shiftSize + ", " + byteBuffer.printBinary());
        
        codeword = 0;
        codewordLength = 2;
        System.out.println("input: " + ByteUtil.getBinaryString(codeword));
        shiftSize = byteBuffer.pack(codeword, codewordLength);
        System.out.println("shift: " + shiftSize + ", " + byteBuffer.printBinary());

        codeword = 3;
        codewordLength = 2;
        System.out.println("input: " + ByteUtil.getBinaryString(codeword));
        shiftSize = byteBuffer.pack(codeword, codewordLength);
        System.out.println("shift: " + shiftSize + ", " + byteBuffer.printBinary());

        byteBuffer.set(codeword, codewordLength - shiftSize);
        System.out.println("set: " + byteBuffer.printBinary());

        codeword = 0;
        codewordLength = 2;
        System.out.println("input: " + ByteUtil.getBinaryString(codeword));
        shiftSize = byteBuffer.pack(codeword, codewordLength);
        System.out.println("shift: " + shiftSize + ", " + byteBuffer.printBinary());

        codeword = 3;
        codewordLength = 2;
        System.out.println("input: " + ByteUtil.getBinaryString(codeword));
        shiftSize = byteBuffer.pack(codeword, codewordLength);
        System.out.println("shift: " + shiftSize + ", " + byteBuffer.printBinary());

        byteBuffer.padding();
        System.out.println("padding: " + byteBuffer.printBinary());

        // test case : over buffer
        // ByteBuffer byteBuffer = new ByteBuffer((byte) 92, 7);
        // System.out.println("init: " + byteBuffer.printBinary());
        // byte codeword = 3;
        // int codewordLength = 2;
        // System.out.println("input: " + ByteUtil.getBinaryString(codeword));
        // int shiftSize = byteBuffer.pack(codeword, codewordLength);
        // System.out.println("shift: " + shiftSize + ", " + byteBuffer.printBinary());
        // EOF test case : over buffer
    }

}
