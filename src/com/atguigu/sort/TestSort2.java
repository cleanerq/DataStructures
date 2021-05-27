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
        // ð�� ѡ�� ���� ϣ�� ���� ������
        jSort8(sz);
        // ��������
//        kSort16(sz, 0, sz.length - 1);
        // �鲢����
//        int temp[] = new int[sz.length];
//        mergeSort6(sz, 0, sz.length - 1, temp);
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
     * ѡ��������ϰ1
     *
     * @param sz
     */
    public static void sSort1(int[] sz) {
        int mIdx = 0;
        int mVal = 0;
        for (int i = 0; i < sz.length; i++) {
            mIdx = i;
            mVal = sz[i];
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
     * ѡ��������ϰ2
     *
     * @param sz
     */
    public static void sSort2(int[] sz) {
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
     * ѡ��������ϰ5
     *
     * @param sz
     */
    public static void sSort5(int[] sz) {
        int mIdx = 0;
        int mVal = 0;

        for (int i = 0; i < sz.length; i++) {
            mIdx = i;
            mVal = sz[i];
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
     * ð��������ϰ1
     *
     * @param sz
     */
    public static void mSort1(int[] sz) {
        boolean flg = false;
        for (int i = 0; i < sz.length; i++) {
            for (int j = 1; j < sz.length - i; j++) {
                if (sz[j] < sz[j - 1]) {
                    int tmp = sz[j - 1];
                    sz[j - 1] = sz[j];
                    sz[j] = tmp;
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
     * ð��������ϰ2
     *
     * @param sz
     */
    public static void mSort2(int[] sz) {
        boolean flg = false;
        for (int i = 0; i < sz.length; i++) {
            for (int j = 1; j < sz.length - i; j++) {
                if (sz[j - 1] > sz[j]) {
                    flg = true;
                    int tmp = sz[j];
                    sz[j] = sz[j - 1];
                    sz[j - 1] = tmp;
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
     * ѡ��������ϰ3
     *
     * @param sz
     */
    public static void sSort3(int[] sz) {
        int mIdx = 0;
        int mVal = 0;
        for (int i = 0; i < sz.length; i++) {
            mIdx = i;
            mVal = sz[i];
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
     * ѡ��������ϰ4
     *
     * @param sz
     */
    public static void sSort4(int[] sz) {
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
     * ����������ϰ5
     *
     * @param sz
     */
    public static void cSort5(int[] sz) {
        int iVal = 0;
        int inDx = 0;
        for (int i = 1; i < sz.length; i++) {
            inDx = i - 1;
            iVal = sz[i];
            while (inDx >= 0 && iVal < sz[inDx]) {
                sz[inDx + 1] = sz[inDx];
                inDx--;
            }
            sz[inDx + 1] = iVal;
        }
    }

    /**
     * ����������ϰ6
     *
     * @param sz
     */
    public static void cSort6(int[] sz) {
        int idx = 0;
        int iVal = 0;
        for (int i = 1; i < sz.length; i++) {
            idx = i - 1;
            iVal = sz[i];
            while (idx >= 0 && iVal < sz[idx]) {
                sz[idx + 1] = sz[idx];
                idx--;
            }
            sz[idx + 1] = iVal;
        }
    }

    /**
     * ����������ϰ4
     *
     * @param sz
     */
    public static void cSort7(int[] sz) {
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
     * ����������ϰ4
     *
     * @param sz
     */
    public static void cSort8(int[] sz) {
        int iIdx = 0;
        int iVal = 0;
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
     * ����������ϰ9
     *
     * @param sz
     */
    public static void cSort9(int[] sz) {
        int inVal = 0;
        int inIdx = 0;
        for (int i = 1; i < sz.length; i++) {
            inVal = sz[i];
            inIdx = i - 1;
            while (inIdx >= 0 && inVal < sz[inIdx]) {
                sz[inIdx + 1] = sz[inIdx];
                inIdx--;
            }
            sz[inIdx + 1] = inVal;
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
     * ϣ��������ϰ5
     *
     * @param sz
     */
    public static void xSort5(int[] sz) {
        int iVal = 0;
        int iind = 0;
        for (int gap = sz.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < sz.length; i++) {
                iind = i - gap;
                iVal = sz[i];
                while (iind >= 0 && iVal < sz[iind]) {
                    sz[iind + gap] = sz[iind];
                    iind -= gap;
                }
                sz[iind + gap] = iVal;
            }
        }
    }

    /**
     * ϣ��������ϰ6
     *
     * @param sz
     */
    public static void xSort6(int[] sz) {
        int idx = 0;
        int iVal = 0;
        for (int gap = sz.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < sz.length; i++) {
                idx = i - gap;
                iVal = sz[i];
                while (idx >= 0 && iVal < sz[idx]) {
                    sz[idx + gap] = sz[idx];
                    idx -= gap;
                }
                sz[idx + gap] = iVal;
            }
        }
    }

    /**
     * ϣ��������ϰ4
     *
     * @param sz
     */
    public static void xSort7(int[] sz) {
        int iIdx = 0;
        int iVal = 0;
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
     * ϣ��������ϰ4
     *
     * @param sz
     */
    public static void xSort8(int[] sz) {
        int iIdx = 0;
        int iVal = 0;

        for (int gap = sz.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < sz.length; i++) {
                iIdx = i - gap;
                iVal = sz[i];
                while (iIdx >= 0 && iVal < sz[iIdx]) {
                    sz[iIdx + gap] = sz[iIdx];
                    iIdx -= gap;
                }
                sz[iIdx + gap] = iVal;
            }
        }
    }

    /**
     * ϣ��������ϰ9
     *
     * @param sz
     */
    public static void xSort9(int[] sz) {
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
     * ����������ϰ7
     * �м�ֵΪ��׼
     *
     * @param arr
     * @param left
     * @param right
     */
    public static void kSort7(int[] arr, int left, int right) {
        int l = left, r = right;
        int m = arr[(l + r) / 2];

        while (l < r) {
            while (arr[l] < m) {
                l++;
            }
            while (arr[r] > m) {
                r--;
            }
            if (l >= r) {
                break;
            }
            int tmp = arr[l];
            arr[l] = arr[r];
            arr[r] = tmp;

            if (arr[l] == m) {
                r--;
            }
            if (arr[r] == m) {
                l++;
            }
        }
        if (l == r) {
            l++;
            r--;
        }
        if (left < r) {
            kSort7(arr, left, r);
        }
        if (l < right) {
            kSort7(arr, l, right);
        }
    }

    /**
     * ����������ϰ8
     * ���ֵΪ��׼
     *
     * @param arr
     * @param left
     * @param right
     */
    public static void kSort8(int[] arr, int left, int right) {
        int l = left, r = right;
        int m = arr[l];

        while (l < r) {
            while (l < r && arr[r] >= m) {
                r--;
            }
            if (l < r) {
                arr[l] = arr[r];
                l++;
            }
            while (l < r && arr[l] < m) {
                l++;
            }
            if (l < r) {
                arr[r] = arr[l];
                r--;
            }
        }
        if (l == r) {
            arr[l] = m;
            l++;
            r--;
        }
        if (left < r) {
            kSort8(arr, left, r);
        }
        if (l < right) {
            kSort8(arr, l, right);
        }
    }

    /**
     * ����������ϰ9
     * �м�ֵΪ��׼
     *
     * @param arr
     * @param left
     * @param right
     */
    public static void kSort9(int[] arr, int left, int right) {
        int l = left, r = right;
        int m = arr[(left + right) / 2];
        while (l < r) {
            while (arr[l] < m) {
                l++;
            }
            while (arr[r] > m) {
                r--;
            }
            if (l >= r) {
                break;
            }
            int tmp = arr[l];
            arr[l] = arr[r];
            arr[r] = tmp;

            if (arr[l] == m) {
                r--;
            }
            if (arr[r] == m) {
                l++;
            }
        }
        if (l == r) {
            l++;
            r--;
        }
        if (left < r) {
            kSort9(arr, left, r);
        }
        if (l < right) {
            kSort9(arr, l, right);
        }
    }

    /**
     * ����������ϰ10
     * ���ֵΪ��׼
     *
     * @param arr
     * @param left
     * @param right
     */
    public static void kSort10(int[] arr, int left, int right) {
        int l = left, r = right;
        int m = arr[l];

        while (l < r) {
            while (l < r && arr[r] >= m) {
                r--;
            }
            if (l < r) {
                arr[l] = arr[r];
                l++;
            }
            while (l < r && arr[l] < m) {
                l++;
            }
            if (l < r) {
                arr[r] = arr[l];
                r--;
            }
        }

        if (l == r) {
            arr[l] = m;
            l++;
            r--;
        }
        if (left < r) {
            kSort10(arr, left, r);
        }
        if (l < right) {
            kSort10(arr, l, right);
        }
    }

    /**
     * ����������ϰ11
     * �м�ֵΪ��׼
     *
     * @param arr
     * @param left
     * @param right
     */
    public static void kSort11(int[] arr, int left, int right) {
        int m = arr[(left + right) / 2];
        int l = left, r = right;
        while (l < r) {
            while (arr[l] < m) {
                l++;
            }
            while (arr[r] > m) {
                r--;
            }
            if (l >= r) {
                break;
            }
            int tmp = arr[l];
            arr[l] = arr[r];
            arr[r] = tmp;

            if (arr[l] == m) {
                r--;
            }
            if (arr[r] == m) {
                l++;
            }
        }
        if (l == r) {
            l++;
            r--;
        }
        if (left < r) {
            kSort11(arr, left, r);
        }
        if (l < right) {
            kSort11(arr, l, right);
        }
    }

    /**
     * ����������ϰ12
     * ���ֵΪ��׼
     *
     * @param arr
     * @param left
     * @param right
     */
    public static void kSort12(int[] arr, int left, int right) {
        int l = left, r = right;
        int m = arr[l];

        while (l < r) {
            while (l < r && arr[r] >= m) {
                r--;
            }
            if (l < r) {
                arr[l] = arr[r];
                l++;
            }
            while (l < r && arr[l] < m) {
                l++;
            }
            if (l < r) {
                arr[r] = arr[l];
                r--;
            }
        }
        if (l == r) {
            arr[l] = m;
            l++;
            r--;
        }
        if (left < r) {
            kSort12(arr, left, r);
        }
        if (l < right) {
            kSort12(arr, l, right);
        }
    }

    /**
     * ����������ϰ11
     * �м�ֵΪ��׼
     *
     * @param arr
     * @param left
     * @param right
     */
    public static void kSort13(int[] arr, int left, int right) {
        int m = arr[left + (right - left) / 2];
        int l = left, r = right;
        while (l < r) {
            while (arr[l] < m) {
                l++;
            }
            while (arr[r] > m) {
                r--;
            }
            if (l >= r) {
                break;
            }
            int tmp = arr[l];
            arr[l] = arr[r];
            arr[r] = tmp;
            if (arr[l] == m) {
                r--;
            }
            if (arr[r] == m) {
                l++;
            }
        }
        if (l == r) {
            l++;
            r--;
        }
        if (left < r) {
            kSort13(arr, left, r);
        }
        if (l < right) {
            kSort13(arr, l, right);
        }
    }

    /**
     * ����������ϰ12
     * ���ֵΪ��׼
     *
     * @param arr
     * @param left
     * @param right
     */
    public static void kSort14(int[] arr, int left, int right) {
        int m = arr[left];
        int l = left, r = right;
        while (l < r) {
            while (l < r && arr[r] >= m) {
                r--;
            }
            if (l < r) {
                arr[l] = arr[r];
                l++;
            }
            while (l < r && arr[l] < m) {
                l++;
            }
            if (l < r) {
                arr[r] = arr[l];
                r--;
            }
        }
        if (l == r) {
            arr[l] = m;
            l++;
            r--;
        }
        if (left < r) {
            kSort14(arr, left, r);
        }
        if (l < right) {
            kSort14(arr, l, right);
        }
    }

    /**
     * ����������ϰ11
     * �м�ֵΪ��׼
     *
     * @param arr
     * @param left
     * @param right
     */
    public static void kSort15(int[] arr, int left, int right) {
        int l = left, r = right;
        int m = arr[l + (r - l) / 2];
        while (l < r) {
            while (arr[l] < m) {
                l++;
            }
            while (arr[r] > m) {
                r--;
            }
            if (l >= r) {
                break;
            }
            int tmp = arr[l];
            arr[l] = arr[r];
            arr[r] = tmp;

            if (arr[l] == m) {
                r--;
            }
            if (arr[r] == m) {
                l++;
            }
        }
        if (l == r) {
            l++;
            r--;
        }
        if (left < r) {
            kSort15(arr, left, r);
        }
        if (l < right) {
            kSort15(arr, l, right);
        }
    }

    /**
     * ����������ϰ12
     * ���ֵΪ��׼
     *
     * @param arr
     * @param left
     * @param right
     */
    public static void kSort16(int[] arr, int left, int right) {
        int l = left, r = right;
        int m = arr[l];

        while (l < r) {
            while (l < r && arr[r] >= m) {
                r--;
            }
            if (l < r) {
                arr[l] = arr[r];
                l++;
            }

            while (l < r && arr[l] < m) {
                l++;
            }
            if (l < r) {
                arr[r] = arr[l];
                r--;
            }
        }

        if (l == r) {
            arr[l] = m;
            l++;
            r--;
        }
        if (left < r) {
            kSort16(arr, left, r);
        }
        if (l < right) {
            kSort16(arr, l, right);
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

    /**
     * ����������ϰ3
     *
     * @param arr
     */
    public static void jSort3(int[] arr) {
        // �������ֵ ȡ������λ��
        int mVal = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > mVal) {
                mVal = arr[i];
            }
        }
        // ѭ������
        int mBit = String.valueOf(mVal).length();

        // ����Ͱ
        int[][] bucket = new int[10][arr.length];
        // ����Ͱ����
        int[] bucketCount = new int[10];

        for (int i = 0, j = 1; i < mBit; i++, j *= 10) {
            // ������������Ӧ��Ͱ�в����м���
            for (int m = 0; m < arr.length; m++) {
                // ����Ͱ�±�
                int idx = arr[m] / j % 10;
                bucket[idx][bucketCount[idx]] = arr[m];
                // ���¼���
                bucketCount[idx]++;
            }
            // ��Ͱ��ȡ������ԭ����
            int idx = 0;
            for (int m = 0; m < bucketCount.length; m++) {
                if (bucketCount[m] != 0) {
                    for (int n = 0; n < bucketCount[m]; n++) {
                        arr[idx++] = bucket[m][n];
                    }
                }
                // ��ռ��� �´�ʱ��ʹ��
                bucketCount[m] = 0;
            }
        }
    }

    /**
     * �鲢������ϰ2
     *
     * @param arr
     * @param left
     * @param right
     * @param temp
     */
    public static void mergeSort2(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int m = (left + right) / 2;
            mergeSort2(arr, left, m, temp);
            mergeSort2(arr, m + 1, right, temp);
            mergeSort2(arr, left, m, right, temp);
        }
    }

    /**
     * �鲢������ϰ2
     *
     * @param arr
     * @param left
     * @param mid
     * @param right
     * @param temp
     */
    public static void mergeSort2(int[] arr, int left, int mid, int right, int[] temp) {
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

        // ������ԭ����
        i = left;
        idx = 0;
        while (i <= right) {
            arr[i++] = temp[idx++];
        }
    }

    /**
     * �鲢������ϰ3
     *
     * @param arr
     * @param left
     * @param right
     * @param temp
     */
    public static void mergeSort3(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort3(arr, left, mid, temp);
            mergeSort3(arr, mid + 1, right, temp);
            mergeSort3(arr, left, mid, right, temp);
        }
    }

    /**
     * �ϲ�
     *
     * @param arr
     * @param left
     * @param mid
     * @param right
     * @param temp
     */
    public static void mergeSort3(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left, j = mid + 1;
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

        idx = 0;
        i = left;
        while (i <= right) {
            arr[i++] = temp[idx++];
        }
    }

    /**
     * �鲢������ϰ4
     *
     * @param arr
     * @param left
     * @param right
     * @param temp
     */
    public static void mergeSort4(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int m = (left + right) / 2;
            mergeSort4(arr, left, m, temp);
            mergeSort4(arr, m + 1, right, temp);
            mergeSort4(arr, left, m, right, temp);
        }
    }

    public static void mergeSort4(int[] arr, int left, int m, int right, int[] temp) {
        int i = left;
        int j = m + 1;
        int idx = 0;
        while (i <= m && j <= right) {
            if (arr[i] < arr[j]) {
                temp[idx++] = arr[i++];
            } else {
                temp[idx++] = arr[j++];
            }
        }
        while (i <= m) {
            temp[idx++] = arr[i++];
        }
        while (j <= right) {
            temp[idx++] = arr[j++];
        }
        i = left;
        idx = 0;
        while (i <= right) {
            arr[i++] = temp[idx++];
        }
    }

    /**
     * �鲢������ϰ
     *
     * @param arr
     * @param left
     * @param right
     * @param temp
     */
    public static void mergeSort5(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int m = left + (right - left) / 2;
            mergeSort5(arr, left, m, temp);
            mergeSort5(arr, m + 1, right, temp);
            mergeSort5(arr, left, m, right, temp);
        }
    }

    public static void mergeSort5(int[] arr, int left, int m, int right, int[] temp) {
        int i = left, j = m + 1;
        int idx = 0;
        while (i <= m && j <= right) {
            if (arr[i] < arr[j]) {
                temp[idx++] = arr[i++];
            } else {
                temp[idx++] = arr[j++];
            }
        }
        while (i <= m) {
            temp[idx++] = arr[i++];
        }
        while (j <= right) {
            temp[idx++] = arr[j++];
        }

        idx = 0;
        i = left;
        while (i <= right) {
            arr[i++] = temp[idx++];
        }
    }

    /**
     * �鲢������ϰ6
     *
     * @param arr
     * @param left
     * @param right
     * @param temp
     */
    public static void mergeSort6(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int m = left + (right - left) / 2;
            int l = left, r = right;
            mergeSort6(arr, l, m, temp);
            mergeSort6(arr, m + 1, right, temp);
            mergeSort6(arr, l, m, right, temp);
        }
    }

    public static void mergeSort6(int[] arr, int left, int m, int right, int[] temp) {
        int i = left, j = m + 1;
        int idx = 0;
        while (i <= m && j <= right) {
            if (arr[i] < arr[j]) {
                temp[idx++] = arr[i++];
            } else {
                temp[idx++] = arr[j++];
            }
        }

        while (i <= m) {
            temp[idx++] = arr[i++];
        }

        while (j <= right) {
            temp[idx++] = arr[j++];
        }

        idx = 0;
        i = left;
        while (i <= right) {
            arr[i++] = temp[idx++];
        }
    }


    /**
     * ����������ϰ4
     *
     * @param arr
     */
    public static void jSort4(int[] arr) {
        int mVal = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > mVal) {
                mVal = arr[i];
            }
        }

        int mBit = String.valueOf(mVal).length();
        int[][] bucket = new int[10][arr.length];
        int[] bucketCount = new int[10];
        int idx = 0;

        for (int i = 0, j = 1; i < mBit; i++, j *= 10) {
            for (int m = 0; m < arr.length; m++) {
                idx = arr[m] / j % 10;
                bucket[idx][bucketCount[idx]] = arr[m];
                bucketCount[idx]++;
            }
            idx = 0;
            for (int m = 0; m < bucketCount.length; m++) {
                if (bucketCount[m] != 0) {
                    for (int n = 0; n < bucketCount[m]; n++) {
                        arr[idx++] = bucket[m][n];
                    }
                }
                bucketCount[m] = 0;
            }
        }
    }

    /**
     * ����������ϰ5
     *
     * @param arr
     */
    public static void jSort5(int[] arr) {
        int mVal = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > mVal) {
                mVal = arr[i];
            }
        }

        int mBit = String.valueOf(mVal).length();
        int[][] bucket = new int[10][arr.length];
        int[] bucketCont = new int[10];

        int idx = 0;
        for (int i = 0, j = 1; i < mBit; i++, j *= 10) {
            for (int m = 0; m < arr.length; m++) {
                idx = arr[m] / j % 10;
                bucket[idx][bucketCont[idx]] = arr[m];
                bucketCont[idx]++;
            }

            idx = 0;
            for (int m = 0; m < bucketCont.length; m++) {
                if (bucketCont[m] != 0) {
                    for (int n = 0; n < bucketCont[m]; n++) {
                        arr[idx++] = bucket[m][n];
                    }
                }
                bucketCont[m] = 0;
            }
        }
    }

    /**
     * ����������ϰ6
     *
     * @param arr
     */
    public static void jSort6(int[] arr) {
        int mVal = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > mVal) {
                mVal = arr[i];
            }
        }

        int mBit = String.valueOf(mVal).length();
        int[][] bucket = new int[10][arr.length];
        int[] bucketCount = new int[10];

        int idx = 0;
        for (int i = 0, j = 1; i < mBit; i++, j *= 10) {
            for (int m = 0; m < arr.length; m++) {
                idx = arr[m] / j % 10;
                bucket[idx][bucketCount[idx]] = arr[m];
                bucketCount[idx]++;
            }

            idx = 0;
            for (int n = 0; n < bucketCount.length; n++) {
                if (bucketCount[n] != 0) {
                    for (int m = 0; m < bucketCount[n]; m++) {
                        arr[idx++] = bucket[n][m];
                    }
                }
                bucketCount[n] = 0;
            }
        }
    }

    /**
     * ����������ϰ7
     *
     * @param arr
     */
    public static void jSort7(int[] arr) {
        int mVal = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > mVal) {
                mVal = arr[i];
            }
        }
        int mBit = String.valueOf(mVal).length();
        int[][] bucket = new int[10][arr.length];
        int[] bucketCount = new int[10];
        int idx = 0;

        for (int i = 0, j = 1; i < mBit; i++, j *= 10) {
            for (int m = 0; m < arr.length; m++) {
                idx = arr[m] / j % 10;
                bucket[idx][bucketCount[idx]] = arr[m];
                bucketCount[idx]++;
            }

            idx = 0;
            for (int m = 0; m < bucketCount.length; m++) {
                if (bucketCount[m] > 0) {
                    for (int n = 0; n < bucketCount[m]; n++) {
                        arr[idx++] = bucket[m][n];
                    }
                }
                bucketCount[m] = 0;
            }
        }
    }

    /**
     * ����������ϰ8
     *
     * @param arr
     */
    public static void jSort8(int[] arr) {
        int mVal = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > mVal) {
                mVal = arr[i];
            }
        }

        int mBit = String.valueOf(mVal).length();
        int[][] bucket = new int[10][arr.length];
        int[] bucketCount = new int[10];

        int idx = 0;
        for (int i = 0, j = 1; i < mBit; i++, j *= 10) {
            for (int m = 0; m < arr.length; m++) {
                idx = arr[m] / j % 10;
                bucket[idx][bucketCount[idx]] = arr[m];
                bucketCount[idx]++;
            }
            idx = 0;
            for (int n = 0; n < bucketCount.length; n++) {
                if (bucketCount[n] > 0) {
                    for (int m = 0; m < bucketCount[n]; m++) {
                        arr[idx++] = bucket[n][m];
                    }
                }
                bucketCount[n] = 0;
            }
        }
    }


    /**
     * ��������ϰ1
     *
     * @param arr
     */
    public static void heapSort(int arr[]) {
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            int tmp = arr[i];
            arr[i] = arr[0];
            arr[0] = tmp;
            adjustHeap(arr, 0, i);
        }
    }

    /**
     * @param arr    ������������
     * @param i      ��Ҷ�ӽڵ��������е�����
     * @param length Ҫ�����ĸ���
     */
    public static void adjustHeap(int arr[], int i, int length) {
        int tmp = arr[i];

        for (int k = 2 * i + 1; k < length; k = k * 2 + 1) {
            if (k + 1 < length && arr[k] < arr[k + 1]) {
                k++;
            }
            if (arr[k] > tmp) {
                arr[i] = arr[k];
                i = k;
            } else {
                break;
            }
        }

        arr[i] = tmp;
    }

    /**
     * ��������ϰ1
     *
     * @param arr
     */
    public static void heapSort2(int arr[]) {
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap2(arr, i, arr.length);
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            int tmp = arr[i];
            arr[i] = arr[0];
            arr[0] = tmp;
            adjustHeap2(arr, 0, i);
        }
    }

    /**
     * @param arr    ������������
     * @param i      ��Ҷ�ӽڵ��������е�����
     * @param length Ҫ�����ĸ���
     */
    public static void adjustHeap2(int arr[], int i, int length) {
        int tmp = arr[i];
        for (int j = 2 * i + 1; j < length; j = j * 2 + 1) {
            if (j + 1 < length && arr[j] < arr[j + 1]) {
                j++;
            }
            if (arr[j] > tmp) {
                arr[i] = arr[j];
                i = j;
            } else {
                break;
            }
        }
        arr[i] = tmp;
    }

    /**
     * ��������ϰ3
     *
     * @param arr
     */
    public static void heapSort3(int arr[]) {
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap3(arr, i, arr.length);
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            int tmp = arr[i];
            arr[i] = arr[0];
            arr[0] = tmp;
            adjustHeap3(arr, 0, i);
        }
    }

    /**
     * ��������ϰ3
     *
     * @param arr    ������������
     * @param i      ��Ҷ�ӽڵ��������е�����
     * @param length Ҫ�����ĸ���
     */
    public static void adjustHeap3(int arr[], int i, int length) {
        int tmp = arr[i];
        for (int j = i * 2 + 1; j < length; j = j * 2 + 1) {
            if (j + 1 < length && arr[j] < arr[j + 1]) {
                j++;
            }
            if (arr[j] > tmp) {
                arr[i] = arr[j];
                i = j;
            } else {
                break;
            }
        }
        arr[i] = tmp;
    }

    /**
     * ��������ϰ4
     *
     * @param arr
     */
    public static void heapSort4(int arr[]) {
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap4(arr, i, arr.length);
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            int tmp = arr[i];
            arr[i] = arr[0];
            arr[0] = tmp;
            adjustHeap4(arr, 0, i);
        }
    }

    public static void adjustHeap4(int arr[], int i, int length) {
        int tmp = arr[i];
        for (int j = 2 * i + 1; j < length; j = j * 2 + 1) {
            if (j + 1 < length && arr[j] < arr[j + 1]) {
                j++;
            }
            if (arr[j] > tmp) {
                arr[i] = arr[j];
                i = j;
            } else {
                break;
            }
        }
        arr[i] = tmp;
    }

    /**
     * ��������ϰ5
     *
     * @param arr
     */
    public static void heapSort5(int arr[]) {
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap5(arr, i, arr.length);
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            int tmp = arr[i];
            arr[i] = arr[0];
            arr[0] = tmp;
            adjustHeap5(arr, 0, i);
        }
    }

    /**
     * ��������ϰ5
     *
     * @param arr
     * @param i
     * @param length
     */
    public static void adjustHeap5(int arr[], int i, int length) {
        int tmp = arr[i];
        for (int m = 2 * i + 1; m < length; m = m * 2 + 1) {
            if (m + 1 < length && arr[m] < arr[m + 1]) {
                m++;
            }
            if (arr[m] > tmp) {
                arr[i] = arr[m];
                i = m;
            } else {
                break;
            }
        }
        arr[i] = tmp;
    }

    /**
     * ��������ϰ6
     *
     * @param arr
     */
    public static void heapSort6(int arr[]) {
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            heapSort6(arr, i, arr.length);
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            int tmp = arr[i];
            arr[i] = arr[0];
            arr[0] = tmp;
            heapSort6(arr, 0, i);
        }
    }

    public static void heapSort6(int arr[], int i, int length) {
        int tmp = arr[i];
        for (int j = 2 * i + 1; j < length; j = j * 2 + 1) {
            if (j + 1 < length && arr[j] < arr[j + 1]) {
                j++;
            }
            if (arr[j] > tmp) {
                arr[i] = arr[j];
                i = j;
            } else {
                break;
            }
        }
        arr[i] = tmp;
    }
}
