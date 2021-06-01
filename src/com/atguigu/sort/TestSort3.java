package com.atguigu.sort;

import java.util.Arrays;

public class TestSort3 {

    public static void main(String[] args) {
        int length = 20;
        int[] sz = new int[length];
        for (int i = 0; i < length; i++) {
            sz[i] = (int) (Math.random() * length * 50);
        }
        System.out.println("ÅÅÐòÇ°: " + Arrays.toString(sz));
        long s = System.currentTimeMillis();
        // Ã°ÅÝ Ñ¡Ôñ ²åÈë Ï£¶û »ùÊý
        dSort1(sz);
        // ¿ìËÙ
//        kSort8(sz, 0, sz.length - 1);
        // ¹é²¢ ¶Ñ
//        int temp[] = new int[sz.length];
//        mergeSort(sz, 0, sz.length - 1, temp);
        long e = System.currentTimeMillis();
        System.out.println("ÅÅÐòºó: " + Arrays.toString(sz));
        System.out.println("¾­¹ýÊ±¼ä£º" + (e - s) + "ms");
    }

    /**
     * Ã°ÅÝÅÅÐòÁ·Ï°1
     *
     * @param sz
     */
    public static void mSort1(int[] sz) {
        boolean flg = false;

        for (int i = 0; i < sz.length; i++) {
            for (int j = 1; j < sz.length - i; j++) {
                if (sz[j] < sz[j - 1]) {
                    int tmp = sz[j];
                    sz[j] = sz[j - 1];
                    sz[j - 1] = tmp;
                    flg = true;
                }
            }
            if (!flg) {
                break;
            } else {
                flg = false;
            }
        }
    }

    /**
     * Ñ¡ÔñÅÅÐò1
     *
     * @param sz
     */
    public static void xSort1(int[] sz) {
        int mVal = 0;
        int mIdx = 0;
        for (int i = 0; i < sz.length; i++) {
            mVal = sz[i];
            mIdx = i;
            for (int j = i + 1; j < sz.length; j++) {
                if (sz[j] < mVal) {
                    mVal = sz[j];
                    mIdx = j;
                }
            }
            if (mIdx != i) {
                sz[mIdx] = sz[i];
                sz[i] = mVal;
            }
        }
    }

    /**
     * ²åÈëÅÅÐò1
     *
     * @param sz
     */
    public static void cSort1(int[] sz) {
        int iIdx = 0;
        int iVal = 0;
        for (int i = 1; i < sz.length; i++) {
            iVal = sz[i];
            iIdx = i - 1;
            while (iIdx >= 0 && iVal < sz[iIdx]) {
                sz[iIdx + 1] = sz[iIdx];
                iIdx--;
            }
            sz[iIdx + 1] = iVal;
        }
    }

    /**
     * Ï£¶ûÅÅÐò1
     *
     * @param sz
     */
    public static void hSort1(int[] sz) {
        int iVal = 0;
        int iIdx = 0;
        for (int gap = sz.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < sz.length; i++) {
                iVal = sz[i];
                iIdx = i - gap;
                while (iIdx >= 0 && iVal < sz[iIdx]) {
                    sz[iIdx + gap] = sz[iIdx];
                    iIdx -= gap;
                }
                sz[iIdx + gap] = iVal;
            }
        }
    }

    /**
     * »ùÊýÅÅÐò1
     *
     * @param sz
     */
    public static void jSort1(int[] sz) {
        int mVal = sz[0];
        for (int i = 1; i < sz.length; i++) {
            if (sz[i] > mVal) {
                mVal = sz[i];
            }
        }

        int mBit = String.valueOf(mVal).length();
        int[][] bucket = new int[10][sz.length];
        int[] bucketCount = new int[10];
        int idx = 0;

        for (int i = 0, j = 1; i < mBit; i++, j *= 10) {
            for (int m = 0; m < sz.length; m++) {
                idx = sz[m] / j % 10;
                bucket[idx][bucketCount[idx]] = sz[m];
                bucketCount[idx]++;
            }

            idx = 0;
            for (int m = 0; m < bucketCount.length; m++) {
                if (bucketCount[m] != 0) {
                    for (int n = 0; n < bucketCount[m]; n++) {
                        sz[idx++] = bucket[m][n];
                    }
                }
                bucketCount[m] = 0;
            }
        }
    }

    /**
     * ¶ÑÅÅÐò1
     *
     * @param sz
     */
    public static void dSort1(int[] sz) {
        for (int i = sz.length / 2 - 1; i >= 0; i--) {
            dSort1(sz, i, sz.length);
        }

        for (int i = sz.length - 1; i >= 0; i--) {
            int tmp = sz[i];
            sz[i] = sz[0];
            sz[0] = tmp;
            dSort1(sz, 0, i);
        }
    }

    public static void dSort1(int[] sz, int idx, int length) {
        int tmp = sz[idx];
        for (int k = 2 * idx + 1; k < length; k = 2 * k + 1) {
            if (k + 1 < length && sz[k] < sz[k + 1]) {
                k++;
            }
            if (tmp < sz[k]) {
                sz[idx] = sz[k];
                idx = k;
            } else {
                break;
            }
        }
        sz[idx] = tmp;
    }
}


