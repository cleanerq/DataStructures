package com.atguigu.sort;

import java.util.Arrays;

public class TestSort2 {
    public static void main(String[] args) {
        int length = 20;
        int[] sz = new int[length];
        for (int i = 0; i < length; i++) {
            sz[i] = (int) (Math.random() * 1000);
        }
        System.out.println("排序前: " + Arrays.toString(sz));
        long s = System.currentTimeMillis();
        // 冒泡 选择 插入 希尔 基数 排序
        jSort(sz);
        // 快速排序
//        kSort6(sz, 0, sz.length - 1);
        // 归并排序
//        int temp[] = new int[sz.length];
//        mergeSort3(sz, 0, sz.length - 1, temp);
        long e = System.currentTimeMillis();
        System.out.println("排序后: " + Arrays.toString(sz));
        System.out.println("经过时间：" + (e - s) + "ms");
    }

    /**
     * 基数排序练习1
     *
     * @param arr
     */
    public static void jSort(int[] arr) {
        // 求最大值
        int mVal = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > mVal) {
                mVal = arr[i];
            }
        }
        // 最大位数
        int mLength = String.valueOf(mVal).length();

        // 桶
        int[][] bucket = new int[10][arr.length];
        // 每个桶里面的数量
        int[] bucketCount = new int[10];

        for (int i = 0, j = 1; i < mLength; i++, j = j * 10) {
            for (int m = 0; m < arr.length; m++) {
                int pos = arr[m] / j % 10;
                bucket[pos][bucketCount[pos]] = arr[m];
                bucketCount[pos]++;
            }

            int idx = 0;
            for (int n = 0; n < bucketCount.length; n++) {
                if (bucketCount[n] != 0) {
                    for (int k = 0; k < bucketCount[n]; k++) {
                        arr[idx++] = bucket[n][k];
                    }
                }
                bucketCount[n] = 0;
            }
        }
    }
}
