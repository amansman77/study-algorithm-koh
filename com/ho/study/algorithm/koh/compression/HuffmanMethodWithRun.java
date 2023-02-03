package com.ho.study.algorithm.koh.compression;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HuffmanMethodWithRun {
    
    private List<Run> runs = new ArrayList<>();
    private MinHeap<Run> heap;
    private Run rootOfHuffmanTree = null;
 
    private void collectRun(FileInputStream fis) throws IOException {
        int data = fis.read();
        int preData = -1;
        int runLength = 1;
        while (data > 0) {
            if (preData > 0 && data != preData) {
                addRun(preData, runLength-1);
                runLength = 1;
            }
            
            preData = data;
            data = fis.read();
            runLength++;
        }

        if (preData > 0 && data != preData) {
            addRun(preData, runLength-1);
        }
    }

    private void addRun(int data, int runLength) {
        for (Run run : runs) {
            if (run.isEquals(data, runLength)) {
                run.addFrequency();
                return;
            }
        }

        runs.add(new Run(data, runLength));
    }

    public static void main(String[] args) {
        HuffmanMethodWithRun app = new HuffmanMethodWithRun();
        try (FileInputStream fis = new FileInputStream("/home/hshwang/workspace/study-algorithm-koh/com/ho/study/algorithm/koh/compression/input-data.txt")) {
            app.compressFile(fis);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return;
        }
    }

    private void compressFile(FileInputStream fis) throws IOException {
        collectRun(fis);
        // printRun();

        createHuffmanTree();
        
        assignCodewords(this.rootOfHuffmanTree, 0, 0);
        printHuffmanTree();
    }

    private void assignCodewords(Run node, int codeword, int length) {
        if (node.isLeaf()) {
            node.setCodeword(codeword, length);
        } else {
            assignCodewords(node.getLeftChild(), codeword << 1, length+1);
            assignCodewords(node.getRightChild(), (codeword << 1) + 1 , length+1);
        }
    }

    private void createHuffmanTree() {
        heap = new MinHeap<>();
        for (Run run : runs) {
            heap.insert(run);
        }

        while (heap.size() > 1) {
            Run firstRun = heap.extractMin();
            Run secondRun = heap.extractMin();
            heap.insert(new Run(firstRun, secondRun));;
        }
        rootOfHuffmanTree = heap.getRoot();
    }

    private void printHuffmanTree() {
        preOrderTraverse(rootOfHuffmanTree, 0);
    }

    private void preOrderTraverse(Run node, int depth) {
        for (int i = 0; i < depth; i++) {
            System.out.print("  ");
        }
        if (node == null) {
            System.out.println("null");
        } else {
            System.out.println(node);
            preOrderTraverse(node.getLeftChild(), depth+1);
            preOrderTraverse(node.getRightChild(), depth+1);
        }
    }

}
