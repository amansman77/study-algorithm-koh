package com.ho.study.algorithm.koh.compression;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HuffmanMethodWithRun {
    
    private List<Run> runs = new ArrayList<>();
    private MinHeap<Run> heap;
    private Run rootOfHuffmanTree = null;

    private Map<RunKey, Run> codewordMap = new HashMap<>();
 
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

    public void compressFile(FileInputStream fis, RandomAccessFile fos) throws IOException {
        collectRun(fis);
        // printRun();
        outputFrequencies(fis.getChannel().size(), fos);

        createHuffmanTree();
        assignCodewords(this.rootOfHuffmanTree, 0, 0);
        // printHuffmanTree();
        storeRunIntoHashMap(this.rootOfHuffmanTree);
        // printCodewordMap();

        encode(fis, fos);
    }

    private void encode(FileInputStream fis, RandomAccessFile fos) throws IOException {
        int data = fis.read();
        int preData = -1;
        int runLength = 1;
        ByteBuffer byteBuffer = new ByteBuffer();
        while (data > 0) {
            if (preData > 0 && data != preData) {
                encode(fos, byteBuffer, (byte) preData, runLength-1);
                runLength = 1;
            }
            
            preData = data;
            data = fis.read();
            runLength++;
        }

        if (preData > 0 && data != preData) {
            encode(fos, byteBuffer, (byte) preData, runLength-1);
        }

        padding(fos, byteBuffer);
    }

    private void padding(RandomAccessFile fos, ByteBuffer byteBuffer) throws IOException {
        if (!byteBuffer.isEmpty()) {
            byteBuffer.padding();
            byteBuffer.write(fos);
        }
    }

    private void encode(RandomAccessFile fout, ByteBuffer byteBuffer, byte symbol, int runLength) throws IOException {
        Run findRun = this.codewordMap.get(new RunKey(symbol, runLength));
        
        packCodeword(fout, byteBuffer, findRun.getCodeword(), findRun.getCodewordLength());
    }

    private void packCodeword(RandomAccessFile fout, ByteBuffer byteBuffer, int codeword, int codewordLength) throws IOException {
        int packSize = byteBuffer.pack(codeword, codewordLength);
        if (packSize < codewordLength) {
            byteBuffer.write(fout);

            byteBuffer.set((byte) codeword, codewordLength - packSize);
        }
    }

    private void outputFrequencies(Long inputFileSize, RandomAccessFile fos) throws IOException {
        fos.writeInt(this.runs.size());
        fos.writeLong(inputFileSize);

        for (Run run : runs) {
            fos.write(run.getSymbol());
            fos.writeInt(run.getRunLength());
            fos.writeInt(run.getFrequency());
        }
    }

    private void printCodewordMap() {
        Set<Entry<RunKey, Run>> entrySet = this.codewordMap.entrySet();
        Iterator<Entry<RunKey, Run>> iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            Entry<RunKey, Run> next = iterator.next();
            System.out.println(next.getKey().toString() + next.getValue().toString());
        }
    }

    private void storeRunIntoHashMap(Run node) {
        if (node.isLeaf()) {
            this.codewordMap.put(node.getRunKey(), node);
        } else {
            storeRunIntoHashMap(node.getLeftChild());
            storeRunIntoHashMap(node.getRightChild());
        }
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
