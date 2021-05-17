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
        jSort6(sz);
        // 快速排序
//        kSort14(sz, 0, sz.length - 1);
        // 归并排序
//        int temp[] = new int[sz.length];
//        mergeSort5(sz, 0, sz.length - 1, temp);
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

    /**
     * 选择排序练习
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
     * 选择排序练习1
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
     * 选择排序练习2
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
     * 冒泡排序练习1
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
     * 选择排序练习3
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
     * 选择排序练习4
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
     * 插入排序练习4
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
     * 插入排序练习5
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
     * 插入排序练习6
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
     * 插入排序练习4
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
     * 插入排序练习4
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
     * 希尔排序练习4
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
     * 希尔排序练习5
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
     * 希尔排序练习6
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
     * 希尔排序练习4
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
     * 希尔排序练习4
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
     * 快速排序练习5
     * 中间值为基准
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
     * 快速排序练习6
     * 左边值为基准
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
     * 快速排序练习7
     * 中间值为基准
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
     * 快速排序练习8
     * 左边值为基准
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
     * 快速排序练习9
     * 中间值为基准
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
     * 快速排序练习10
     * 左边值为基准
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
     * 快速排序练习11
     * 中间值为基准
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
     * 快速排序练习12
     * 左边值为基准
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
     * 快速排序练习11
     * 中间值为基准
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
     * 快速排序练习12
     * 左边值为基准
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
     * 归并排序练习1
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
     * 归并排序练习1
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

        // 拷贝回原来的数组 注意从left开始拷贝
        i = left;
        idx = 0;
        while (left <= right) {
            arr[left++] = temp[idx++];
        }
    }

    /**
     * 基数排序练习2
     *
     * @param arr
     */
    public static void jSort2(int[] arr) {
        // 求最大值
        int mVal = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > mVal) {
                mVal = arr[i];
            }
        }
        int mBit = String.valueOf(mVal).length();
        // 定义桶
        int[][] bucket = new int[10][arr.length];
        // 定义桶的数量
        int[] bucketCount = new int[10];

        for (int i = 0, j = 1; i < mBit; i++, j *= 10) {
            // 先加入桶
            for (int m = 0; m < arr.length; m++) {
                // 求插入桶的位置
                int inDx = arr[m] / j % 10;
                bucket[inDx][bucketCount[inDx]] = arr[m];
                bucketCount[inDx]++;
            }
            // 从桶中取出
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
     * 基数排序练习3
     *
     * @param arr
     */
    public static void jSort3(int[] arr) {
        // 先求最大值 取得最大的位数
        int mVal = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > mVal) {
                mVal = arr[i];
            }
        }
        // 循环次数
        int mBit = String.valueOf(mVal).length();

        // 定义桶
        int[][] bucket = new int[10][arr.length];
        // 定义桶计数
        int[] bucketCount = new int[10];

        for (int i = 0, j = 1; i < mBit; i++, j *= 10) {
            // 求余数放入相应的桶中并进行计数
            for (int m = 0; m < arr.length; m++) {
                // 放入桶下标
                int idx = arr[m] / j % 10;
                bucket[idx][bucketCount[idx]] = arr[m];
                // 更新计数
                bucketCount[idx]++;
            }
            // 从桶中取出放入原数组
            int idx = 0;
            for (int m = 0; m < bucketCount.length; m++) {
                if (bucketCount[m] != 0) {
                    for (int n = 0; n < bucketCount[m]; n++) {
                        arr[idx++] = bucket[m][n];
                    }
                }
                // 清空计数 下次时候使用
                bucketCount[m] = 0;
            }
        }
    }

    /**
     * 归并排序练习2
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
     * 归并排序练习2
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

        // 拷贝回原数组
        i = left;
        idx = 0;
        while (i <= right) {
            arr[i++] = temp[idx++];
        }
    }

    /**
     * 归并排序练习3
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
     * 合并
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
     * 归并排序练习4
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
     * 归并排序练习
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
     * 基数排序练习4
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
     * 基数排序练习5
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
     * 基数排序练习6
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
     * 堆排序练习1
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
     * @param arr    待调整的数组
     * @param i      非叶子节点在数组中的索引
     * @param length 要调整的个数
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
     * 堆排序练习1
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
     * @param arr    待调整的数组
     * @param i      非叶子节点在数组中的索引
     * @param length 要调整的个数
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
}
