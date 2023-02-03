package com.ho.study.algorithm.koh.compression;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class MinHeap<T extends Comparable<T>> {

    private List<T> arr = new ArrayList<>();
    
    public void insert(T item) {
        arr.add(item);

        Integer currentPosition = arr.size();
        Integer parentPosition = getParentIndex(currentPosition);
        while (currentPosition > 1 && (arr.get(parentPosition-1).compareTo(arr.get(currentPosition-1)) > 0)) {
            swap(currentPosition-1, parentPosition-1);
            currentPosition = parentPosition;
        }
    }

    private void swap(Integer firstIndex, Integer secondIndex) {
        T tmp = arr.get(firstIndex);
        arr.set(firstIndex, arr.get(secondIndex));
        arr.set(secondIndex, tmp);
    }

    private Integer getParentIndex(Integer currentIndex) {
        return currentIndex / 2;
    }
    
    public T extractMin() {
        if (arr.size() < 1) {
            throw new NoSuchElementException("데이터가 존재하지 않습니다.");
        }

        T min =  arr.get(0);
        arr.set(0, arr.get(arr.size()-1));
        arr.remove(arr.size()-1);

        minHeapify(1);

        return min;
    }

    private void minHeapify(int position) {
        if (arr.size() < position*2) {
            return;
        }

        int minChildPosition = position*2;
        if (arr.size() == position*2) {
            // 왼쪽 자식만 있는 경우, 스킵
        } else if (arr.get(position*2 - 1).compareTo(arr.get((position*2))) > 0) {
            // 오른쪽 자식도 있는 경우 비교
            minChildPosition = position*2 + 1;
        }

        if (arr.get(position-1).compareTo(arr.get(minChildPosition-1)) < 0) {
            return;
        }

        swap(position-1, minChildPosition-1);
        minHeapify(minChildPosition);
    }

    private void print() {
        preOrderTraverse(arr, 1);
    }

    private void preOrderTraverse(List<T> arr, int position) {
        for (int i = 1; i < position; i = (i * 2) + 1) {
            System.out.print("  ");
        }
        if (position > arr.size()) {
            System.out.println("null");
        } else {
            System.out.println(arr.get(position-1));
            preOrderTraverse(arr, position*2);
            preOrderTraverse(arr, (position*2)+1);
        }
    }

    public static void main(String[] args) {
        MinHeap<Run> minHeap = new MinHeap<>();
        minHeap.insert(new Run(65, 1, 30));
        minHeap.insert(new Run(65, 1, 1));
        minHeap.insert(new Run(65, 1, 20));
        minHeap.insert(new Run(65, 1, 5));
        minHeap.insert(new Run(65, 1, 6));
        minHeap.insert(new Run(65, 1, 7));
        minHeap.print();

        minHeap.extractMin();
        System.out.println();
        minHeap.print();

        minHeap.extractMin();
        System.out.println();
        minHeap.print();

        minHeap.extractMin();
        System.out.println();
        minHeap.print();

        minHeap.extractMin();
        System.out.println();
        minHeap.print();

        minHeap.extractMin();
        System.out.println();
        minHeap.print();

        minHeap.extractMin();
        System.out.println();
        minHeap.print();

        minHeap.extractMin();
        System.out.println();
        minHeap.print();
    }

    public int size() {
        return this.arr.size();
    }

    public T getRoot() {
        return this.arr.get(0);
    }
}
