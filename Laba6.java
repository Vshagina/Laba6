package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Laba6 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Введите количество значений в массиве:");
        int size = input.nextInt();
        int[] array1 = new int[size];
        for (int i = 0; i < size; i++) {
            System.out.println("Введите значения массива:");
            array1[i] = input.nextInt();
        }
        int[] result = mergesort(array1);
        System.out.println(Arrays.toString(result));
    }
    public static int[] mergesort(int[] sortArr) {
        int[] buffer1 = Arrays.copyOf(sortArr, sortArr.length);
        int[] buffer2 = new int[sortArr.length];
        int[] result = mergesortInner(buffer1, buffer2, 0, sortArr.length);
        return result;
    }
    public static int[] mergesortInner(int[] buffer1, int[] buffer2,
                                       int startIndex, int endIndex) {
        if (startIndex >= endIndex - 1) {
            return buffer1;
        }

        // поиск середины и разбиение массива
        int middle = startIndex + (endIndex - startIndex) / 2;
        int[] sorted1 = mergesortInner(buffer1, buffer2, startIndex, middle);
        int[] sorted2 = mergesortInner(buffer1, buffer2, middle, endIndex);

        // слияние массивов в один
        int index1 = startIndex;
        int index2 = middle;//середина
        int destIndex = startIndex;
        int[] result = sorted1 == buffer1 ? buffer2 : buffer1;
        while (index1 < middle && index2 < endIndex) {
            result[destIndex++] = sorted1[index1] < sorted2[index2]
                    ? sorted1[index1++] : sorted2[index2++];
        }
        while (index1 < middle) {
            result[destIndex++] = sorted1[index1++];
        }
        while (index2 < endIndex) {
            result[destIndex++] = sorted2[index2++];
        }
        return result;
    }
}


