package com.atguigu.sort;

import java.util.Arrays;

public class TestSort2 {
    public static void main(String[] args) {
        int length = 20;
        int[] sz = new int[length];
        for (int i = 0; i < length; i++) {
            sz[i] = (int) (Math.random() * 1000);
        }
        System.out.println("����ǰ: " + Arrays.toString(sz));
        long s = System.currentTimeMillis();
        // ð�� ѡ�� ���� ϣ�� ���� ����
        jSort(sz);
        // ��������
//        kSort6(sz, 0, sz.length - 1);
        // �鲢����
//        int temp[] = new int[sz.length];
//        mergeSort3(sz, 0, sz.length - 1, temp);
        long e = System.currentTimeMillis();
        System.out.println("�����: " + Arrays.toString(sz));
        System.out.println("����ʱ�䣺" + (e - s) + "ms");
    }

    /**
     * ����������ϰ1
     *
     * @param arr
     */
    public static void jSort(int[] arr) {
        // �����ֵ
        int mVal = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > mVal) {
                mVal = arr[i];
            }
        }
        // ���λ��
        int mLength = String.valueOf(mVal).length();

        // Ͱ
        int[][] bucket = new int[10][arr.length];
        // ÿ��Ͱ���������
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
