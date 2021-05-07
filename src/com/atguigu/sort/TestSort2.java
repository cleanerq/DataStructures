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
        jSort2(sz);
        // ��������
//        kSort6(sz, 0, sz.length - 1);
        // �鲢����
//        int temp[] = new int[sz.length];
//        mergeSort(sz, 0, sz.length - 1, temp);
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

    /**
     * ѡ��������ϰ
     *
     * @param sz
     */
    public static void sSort(int[] sz) {
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
     * ����������ϰ4
     *
     * @param sz
     */
    public static void cSort4(int[] sz) {
        int iVal = 0;
        int iIdx = 0;
        for (int i = 1; i < sz.length; i++) {
            iIdx = i - 1;
            iVal = sz[i];
            while (iIdx >= 0 && iVal < sz[iIdx]) {
                sz[iIdx + 1] = sz[iIdx];
                iIdx--;
            }
            sz[iIdx + 1] = iVal;
        }
    }

    /**
     * ϣ��������ϰ4
     *
     * @param sz
     */
    public static void xSort4(int[] sz) {
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
     * ����������ϰ5
     * �м�ֵΪ��׼
     *
     * @param arr
     * @param left
     * @param right
     */
    public static void kSort5(int[] arr, int left, int right) {
        int l = left, r = right;
        int mVal = arr[(l + r) / 2];
        while (l < r) {
            while (arr[l] < mVal) {
                l++;
            }
            while (arr[r] > mVal) {
                r--;
            }
            if (l >= r) {
                break;
            }
            int tmp = arr[l];
            arr[l] = arr[r];
            arr[r] = tmp;

            if (arr[l] == mVal) {
                r--;
            }
            if (arr[r] == mVal) {
                l++;
            }
        }
        if (l == r) {
            l++;
            r--;
        }
        if (left < r) {
            kSort5(arr, left, r);
        }
        if (l < right) {
            kSort5(arr, l, right);
        }
    }

    /**
     * ����������ϰ6
     * ���ֵΪ��׼
     *
     * @param arr
     * @param left
     * @param right
     */
    public static void kSort6(int[] arr, int left, int right) {
        int l = left, r = right;
        int mVal = arr[l];
        while (l < r) {
            while (l < r && arr[r] >= mVal) {
                r--;
            }
            if (l < r) {
                arr[l] = arr[r];
                l++;
            }
            while (l < r && arr[l] < mVal) {
                l++;
            }
            if (l < r) {
                arr[r] = arr[l];
                r--;
            }
        }
        if (l == r) {
            arr[l] = mVal;
            l++;
            r--;
        }
        if (left < r) {
            kSort6(arr, left, r);
        }
        if (l < right) {
            kSort6(arr, l, right);
        }
    }

    /**
     * �鲢������ϰ1
     *
     * @param arr
     * @param left
     * @param right
     * @param temp
     */
    public static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int m = (left + right) / 2;
            mergeSort(arr, left, m, temp);
            mergeSort(arr, m + 1, right, temp);
            mergeSorth(arr, left, m, right, temp);
        }
    }

    /**
     * �鲢������ϰ1
     *
     * @param arr
     * @param left
     * @param mid
     * @param right
     * @param temp
     */
    public static void mergeSorth(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid + 1;
        int idx = 0;

        while (i <= mid && j <= right) {
            if (arr[i] < arr[j]) {
                temp[idx++] = arr[i++];
            } else {
                temp[idx++] = arr[j++];
            }
        }
        while (i <= mid) {
            temp[idx++] = arr[i++];
        }
        while (j <= right) {
            temp[idx++] = arr[j++];
        }

        // ������ԭ�������� ע���left��ʼ����
        i = left;
        idx = 0;
        while (left <= right) {
            arr[left++] = temp[idx++];
        }
    }

    /**
     * ����������ϰ2
     *
     * @param arr
     */
    public static void jSort2(int[] arr) {
        // �����ֵ
        int mVal = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > mVal) {
                mVal = arr[i];
            }
        }
        int mBit = String.valueOf(mVal).length();
        // ����Ͱ
        int[][] bucket = new int[10][arr.length];
        // ����Ͱ������
        int[] bucketCount = new int[10];

        for (int i = 0, j = 1; i < mBit; i++, j *= 10) {
            // �ȼ���Ͱ
            for (int m = 0; m < arr.length; m++) {
                // �����Ͱ��λ��
                int inDx = arr[m] / j % 10;
                bucket[inDx][bucketCount[inDx]] = arr[m];
                bucketCount[inDx]++;
            }
            // ��Ͱ��ȡ��
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
