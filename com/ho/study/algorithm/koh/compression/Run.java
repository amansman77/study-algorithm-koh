package com.ho.study.algorithm.koh.compression;

public class Run implements Comparable<Run> {

    private byte symbol;
    private Integer runLength;
    private Integer frequency;

    private Run leftChild;
    private Run rightChild;

    private int codeword;
    private int codewordLength;

    public Run(int data, int runLength) {
        this.symbol = (byte) data;
        this.runLength = runLength;
        this.frequency = 1;
    }

    public Run(int data, int runLength, int frequency) {
        this.symbol = (byte) data;
        this.runLength = runLength;
        this.frequency = frequency;
    }

    public Run(Run firstRun, Run secondRun) {
        this.leftChild = firstRun;
        this.rightChild = secondRun;
        this.frequency = firstRun.frequency + secondRun.frequency;
    }

    public Run getLeftChild() {
        return this.leftChild;
    }
    public Run getRightChild() {
        return this.rightChild;
    }

    public void addFrequency() {
        this.frequency++;
    }

    public void setCodeword(int codeword, int length) {
        this.codeword = codeword;
        this.codewordLength = length;
    }

    public boolean isLeaf() {
        return this.leftChild == null && this.rightChild == null;
    }

    public boolean isEquals(int data, int runLength) {
        if (this.symbol == (byte) data && this.runLength == runLength) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return String.valueOf((char) this.symbol) + ", run length: " + this.runLength + "," + this.frequency + ", code: " + this.codeword + ", " + this.codewordLength;
    }

    @Override
    public int compareTo(Run o) {
        return this.frequency - o.frequency;
    }

}
