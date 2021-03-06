package com.atguigu.sort;

import java.util.Arrays;

/**
 * ??ϰ????
 */
public class TestSort {
    public static void main(String[] args) {
        int length = 20;
        int[] sz = new int[length];
        for (int i = 0; i < length; i++) {
            sz[i] = (int) (Math.random() * 1000);
        }
        System.out.println("????ǰ: " + Arrays.toString(sz));
        long s = System.currentTimeMillis();
        // ð?? ѡ?? ???? ϣ?? ????
//        jSort1(sz);
        // ????????
//        kSort8(sz, 0, sz.length - 1);
        // ?鲢????
        int temp[] = new int[sz.length];
        mergeSort4(sz, 0, sz.length - 1, temp);
        long e = System.currentTimeMillis();
        System.out.println("??????: " + Arrays.toString(sz));
        System.out.println("????ʱ?䣺" + (e - s) + "ms");
    }

    /**
     * ð??????
     *
     * @param sz
     */
    public static void mSort(int[] sz) {
        // С?Ż? ?ж??Ƿ??Ѿ???????
        boolean flag = false;
        for (int i = 0; i < sz.length; i++) {
            for (int j = 1; j < sz.length - i; j++) {
                if (sz[j] < sz[j - 1]) {
                    flag = true;
                    int tmp = sz[j - 1];
                    sz[j - 1] = sz[j];
                    sz[j] = tmp;
                }
            }
            if (!flag) {
                System.out.println("û???????˳?ѭ??");
                break;
            } else {
                flag = false;
            }
        }
    }

    /**
     * ð????????ϰ2
     *
     * @param sz
     */
    public static void mSort2(int[] sz) {
        boolean flg = false;
        for (int i = 0; i < sz.length; i++) {
            for (int j = 1; j < sz.length - i; j++) {
                if (sz[j] < sz[j - 1]) {
                    flg = true;
                    int tmp = sz[j - 1];
                    sz[j - 1] = sz[j];
                    sz[j] = tmp;
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
     * ð????????ϰ3
     *
     * @param sz
     */
    public static void mSort3(int[] sz) {
        boolean flg = false;

        for (int i = 0; i < sz.length; i++) {
            for (int j = 1; j < sz.length - i; j++) {
                if (sz[j] < sz[j - 1]) {
                    flg = true;
                    int tmp = sz[j - 1];
                    sz[j - 1] = sz[j];
                    sz[j] = tmp;
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
     * ѡ??????
     *
     * @param sz
     */
    public static void sSort(int[] sz) {
        for (int i = 0; i < sz.length; i++) {
            int min = sz[i];
            int mIndex = i;
            for (int j = i + 1; j < sz.length; j++) {
                if (min > sz[j]) {
                    min = sz[j];
                    mIndex = j;
                }
            }
            if (mIndex != i) {
                sz[mIndex] = sz[i];
                sz[i] = min;
            }
        }
    }

    /**
     * ѡ????????ϰ2
     *
     * @param sz
     */
    public static void sSort2(int[] sz) {

        int minIndex = 0;
        int minVal = 0;
        for (int i = 0; i < sz.length; i++) {
            minVal = sz[i];
            minIndex = i;
            for (int j = i + 1; j < sz.length; j++) {
                if (sz[j] < minVal) {
                    // ֻ??¼λ?ò????н???
                    minVal = sz[j];
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                sz[minIndex] = sz[i];
                sz[i] = minVal;
            }
        }
    }

    /**
     * ѡ????????ϰ3
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
     * ѡ????????ϰ4
     *
     * @param sz
     */
    public static void sSort4(int[] sz) {
        int mVal = 0;
        int mIdx = 0;

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
     * ????????
     *
     * @param sz
     */
    public static void cSort(int[] sz) {
        int insIndex = 0;
        int insVal = 0;
        for (int i = 1; i < sz.length; i++) {
            insIndex = i - 1;
            insVal = sz[i];
            while (insIndex >= 0 && sz[insIndex] > insVal) {
                sz[insIndex + 1] = sz[insIndex];
                insIndex--;
            }
            sz[insIndex + 1] = insVal;
        }
    }

    /**
     * ??????????ϰ2
     *
     * @param sz
     */
    public static void cSort2(int[] sz) {
        int insertIndex = 0;
        int insertVal = 0;
        for (int i = 1; i < sz.length; i++) {
            insertIndex = i - 1;
            insertVal = sz[i];
            while (insertIndex >= 0 && insertVal < sz[insertIndex]) {
                sz[insertIndex + 1] = sz[insertIndex];
                insertIndex--;
            }
            sz[insertIndex + 1] = insertVal;
        }
    }

    /**
     * ??????????ϰ3
     *
     * @param sz
     */
    public static void cSort3(int[] sz) {
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
     * ??????????ϰ4
     *
     * @param sz
     */
    public static void cSort4(int[] sz) {
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
     * ϣ??????
     *
     * @param sz
     */
    public static void xSort(int[] sz) {
        for (int gap = sz.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < sz.length; i++) {
                int j = i - gap;
                int tmp = sz[i];
                if (tmp < sz[j]) {
                    while (j >= 0 && tmp < sz[j]) {
                        sz[j + gap] = sz[j];
                        j = j - gap;
                    }
                    sz[j + gap] = tmp;
                }
            }
        }
    }

    /**
     * ϣ????????ϰ2
     *
     * @param sz
     */
    public static void xSort2(int[] sz) {
        for (int gap = sz.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < sz.length; i++) {
                int insertIndex = i - gap;
                int insertVal = sz[i];

                while (insertIndex >= 0 && insertVal < sz[insertIndex]) {
                    sz[insertIndex + gap] = sz[insertIndex];
                    insertIndex -= gap;
                }

                sz[insertIndex + gap] = insertVal;
            }
        }
    }

    /**
     * ϣ????????ϰ3
     *
     * @param sz
     */
    public static void xSort3(int[] sz) {
        int inVal = 0;
        int inIdx = 0;

        for (int gap = sz.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < sz.length; i++) {
                inIdx = i - gap;
                inVal = sz[i];
                while (inIdx >= 0 && sz[inIdx] > inVal) {
                    sz[inIdx + gap] = sz[inIdx];
                    inIdx -= gap;
                }
                sz[inIdx + gap] = inVal;
            }
        }
    }

    /**
     * ϣ????????ϰ4
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
     * ??????????ϰ
     * ????Ϊ??׼
     *
     * @param arr
     * @param l
     * @param r
     */
    public static void kSort(int[] arr, int l, int r) {
        if (l < r) {
            // m??׼ֵ
            int i = l, j = r, m = arr[i];
            while (i < j) {
                // ???ұ߱??? ?ҵ??Ȼ?׼ֵС???????±?
                while (i < j && arr[j] >= m) {
                    j--;
                }
                if (i < j) {
                    arr[i] = arr[j];
                    i++;
                }


                // ?????߱??? ?ҵ??Ȼ?׼ֵ?????????±?
                while (i < j && arr[i] < m) {
                    i++;
                }
                if (i < j) {
                    arr[j] = arr[i];
                    j--;
                }
            }
            if (i == j) {
                arr[i] = m;
            }
            kSort(arr, l, i - 1);
            kSort(arr, i + 1, r);
        }
    }

    /**
     * ??????????ϰ2
     * ?м?ֵΪ??׼
     *
     * @param arr
     * @param left
     * @param right
     */
    public static void kSort2(int[] arr, int left, int right) {
        int l = left;
        int r = right;
        // ??׼ֵ
        int m = arr[(r + l) / 2];
        int tmp = 0;
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
            tmp = arr[l];
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
            kSort2(arr, left, r);
        }
        if (l < right) {
            kSort2(arr, l, right);
        }
    }

    /**
     * ??????????ϰ3
     * ?м?Ϊ??׼
     *
     * @param arr
     * @param left
     * @param right
     */
    public static void kSort3(int[] arr, int left, int right) {
        int i = left, j = right;
        int p = arr[(i + j) / 2];
        int tmp = 0;

        while (i < j) {
            while (arr[j] > p) {
                j--;
            }
            while (arr[i] < p) {
                i++;
            }
            if (i >= j) {
                break;
            }
            tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
            if (arr[i] == p) {
                j--;
            }
            if (arr[j] == p) {
                i++;
            }
        }
        if (i == j) {
            i++;
            j--;
        }
        if (left <= j) {
            kSort3(arr, left, j);
        }
        if (i <= right) {
            kSort3(arr, i, right);
        }
    }

    /**
     * ??????????ϰ4
     * ????ֵΪ??׼
     *
     * @param arr
     * @param left
     * @param right
     */
    public static void kSort4(int[] arr, int left, int right) {
        if (left < right) {
            int l = left, r = right;
            int m = arr[left];

            while (l < r) {
                while (l < r && arr[r] > m) {
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
            if (r == l) {
                arr[r] = m;
            }
            kSort4(arr, left, r - 1);
            kSort4(arr, r + 1, right);
        }
    }

    /**
     * ??????????ϰ5
     * ?м?ֵΪ??׼
     *
     * @param arr
     * @param left
     * @param right
     */
    public static void kSort5(int[] arr, int left, int right) {
        int l = left;
        int r = right;
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

            if (l < r && arr[l] == m) {
                r--;
            }
            if (l < r && arr[r] == m) {
                l++;
            }
        }

        if (l == r) {
            l++;
            r--;
        }
        if (left <= r) {
            kSort5(arr, left, r);
        }
        if (l <= right) {
            kSort5(arr, l, right);
        }
    }

    /**
     * ??????????ϰ6
     * ????ֵΪ??׼
     *
     * @param arr
     * @param left
     * @param right
     */
    public static void kSort6(int[] arr, int left, int right) {
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
        if (left <= r) {
            kSort6(arr, left, r);
        }
        if (l <= right) {
            kSort6(arr, l, right);
        }
    }

    /**
     * ??????????ϰ7
     * ?м?ֵΪ??׼
     *
     * @param arr
     * @param left
     * @param right
     */
    public static void kSort7(int[] arr, int left, int right) {
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
            kSort7(arr, left, r);
        }
        if (l < right) {
            kSort7(arr, l, right);
        }

    }

    /**
     * ??????????ϰ8
     * ????ֵΪ??׼
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
     * ??????????ϰ1
     *
     * @param arr
     */
    public static void jSort1(int[] arr) {
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
     * ?鲢??????ϰ1
     *
     * @param arr
     * @param left
     * @param right
     * @param temp
     */
    public static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int m = (left + right) / 2; //?м?????
            mergeSort(arr, left, m, temp);
            mergeSort(arr, m + 1, right, temp);
            merge(arr, left, m, right, temp);
        }
    }

    /**
     * ?鲢??????ϰ1
     *
     * @param arr
     * @param left
     * @param mid
     * @param right
     * @param temp
     */
    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid + 1;
        int t = 0;
        while (i <= mid && j <= right) {
            if (arr[i] < arr[j]) {
                temp[t] = arr[i];
                t++;
                i++;
            } else {
                temp[t] = arr[j];
                t++;
                j++;
            }
        }
        while (i <= mid) {
            temp[t] = arr[i];
            t++;
            i++;
        }

        while (j <= right) {
            temp[t] = arr[j];
            t++;
            j++;
        }
        t = 0;
        i = left;
        int r = right;
        while (i <= r) {
            arr[i] = temp[t];
            i++;
            t++;
        }
    }

    /**
     * ?鲢??????ϰ2
     *
     * @param arr   ??????????
     * @param left  ???߽?
     * @param right ?ұ߽?
     * @param temp  ??ʱ????
     */
    public static void mergeSort2(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int m = (left + right) / 2;
            mergeSort2(arr, left, m, temp);
            mergeSort2(arr, m + 1, right, temp);
            merge2(arr, left, m, right, temp);
        }
    }

    /**
     * ?鲢??????ϰ2
     *
     * @param arr
     * @param left
     * @param mid
     * @param right
     * @param temp
     */
    public static void merge2(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid + 1;
        int n = 0;
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[n] = arr[i];
                n++;
                i++;
            } else {
                temp[n] = arr[j];
                n++;
                j++;
            }
        }
        while (i <= mid) {
            temp[n] = arr[i];
            n++;
            i++;
        }
        while (j <= right) {
            temp[n] = arr[j];
            n++;
            j++;
        }
        n = 0;
        i = left;
        while (i <= right) {
            arr[i] = temp[n];
            i++;
            n++;
        }
    }

    /**
     * ?鲢??????ϰ3
     *
     * @param arr   ??????????
     * @param left  ???߽?
     * @param right ?ұ߽?
     * @param temp  ??ʱ????
     */
    public static void mergeSort3(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int m = (left + right) / 2;
            mergeSort3(arr, left, m, temp);
            mergeSort3(arr, m + 1, right, temp);
            merge3(arr, left, m, right, temp);
        }
    }

    /**
     * ?鲢??????ϰ3
     *
     * @param arr
     * @param left
     * @param mid
     * @param right
     * @param temp
     */
    public static void merge3(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid + 1;
        int idx = 0;
        while (i <= mid && j <= right) {
            if (arr[i] < arr[j]) {
                temp[idx] = arr[i];
                i++;
                idx++;
            } else {
                temp[idx] = arr[j];
                j++;
                idx++;
            }
        }
        while (i <= mid) {
            temp[idx] = arr[i];
            i++;
            idx++;
        }
        while (j <= right) {
            temp[idx] = arr[j];
            j++;
            idx++;
        }

        idx = 0;
        // ע?ⲻ?Ǵ?0??ʼ?????????Ǵ?left??ʼ????
        i = left;
        while (i <= right) {
            arr[i] = temp[idx];
            idx++;
            i++;
        }
    }

    /**
     * ?鲢??????ϰ4
     *
     * @param arr   ??????????
     * @param left  ???߽?
     * @param right ?ұ߽?
     * @param temp  ??ʱ????
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

        i = left;
        idx = 0;
        while (i <= right) {
            arr[i++] = temp[idx++];
        }
    }
}
