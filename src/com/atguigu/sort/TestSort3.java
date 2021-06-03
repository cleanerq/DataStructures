package com.atguigu.sort;

import java.util.Arrays;

public class TestSort3 {

    public static void main(String[] args) {
        int length = 20;
        int[] sz = new int[length];
        for (int i = 0; i < length; i++) {
            sz[i] = (int) (Math.random() * length * 50);
        }
        System.out.println("≈≈–Ú«∞: " + Arrays.toString(sz));
        long s = System.currentTimeMillis();
        // √∞≈› —°‘Ò ≤Â»Î œ£∂˚ ª˘ ˝ ∂—
//        dSort2(sz);
        // øÏÀŸ
        kSortL2(sz, 0, sz.length - 1);
        // πÈ≤¢
//        int temp[] = new int[sz.length];
//        gSort2(sz, 0, sz.length - 1, temp);
        long e = System.currentTimeMillis();
        System.out.println("≈≈–Ú∫Û: " + Arrays.toString(sz));
        System.out.println("æ≠π˝ ±º‰£∫" + (e - s) + "ms");
    }

    /**
     * √∞≈›≈≈–Ú¡∑œ∞1
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
     * —°‘Ò≈≈–Ú1
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
     * ≤Â»Î≈≈–Ú1
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
     * œ£∂˚≈≈–Ú1
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
     * ª˘ ˝≈≈–Ú1
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
     * ∂—≈≈–Ú1
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

    /**
     * ∂—≈≈–Ú1
     *
     * @param sz
     */
    public static void dSort2(int[] sz) {
        for (int i = sz.length / 2 - 1; i >= 0; i--) {
            dSort2(sz, i, sz.length);
        }

        for (int i = sz.length - 1; i >= 0; i--) {
            int tmp = sz[i];
            sz[i] = sz[0];
            sz[0] = tmp;

            dSort2(sz, 0, i);
        }
    }

    /**
     * ∂—≈≈–Ú2
     *
     * @param sz
     * @param i
     * @param length
     */
    public static void dSort2(int[] sz, int i, int length) {
        int tmp = sz[i];
        for (int k = 2 * i + 1; k < length; k = k * 2 + 1) {
            if (k + 1 < length && sz[k] < sz[k + 1]) {
                k++;
            }
            if (sz[k] > tmp) {
                sz[i] = sz[k];
                i = k;
            } else {
                break;
            }
        }
        sz[i] = tmp;
    }


    /**
     * øÏÀŸ≈≈–Ú1
     * ÷–º‰
     *
     * @param sz
     * @param left
     * @param right
     */
    public static void kSortM1(int[] sz, int left, int right) {
        int l = left, r = right;
        int m = sz[l + (r - l) / 2];
        while (l < r) {
            while (sz[l] < m) {
                l++;
            }
            while (sz[r] > m) {
                r--;
            }
            if (l >= r) {
                break;
            }
            int tmp = sz[l];
            sz[l] = sz[r];
            sz[r] = tmp;
            if (sz[l] == m) {
                r--;
            }
            if (sz[r] == m) {
                l++;
            }
        }
        if (l == r) {
            l++;
            r--;
        }
        if (l < right) {
            kSortM1(sz, l, right);
        }
        if (left < r) {
            kSortM1(sz, left, r);
        }
    }

    /**
     * øÏÀŸ≈≈–Ú1
     * ◊Û±ﬂ
     *
     * @param sz
     * @param left
     * @param right
     */
    public static void kSortL1(int[] sz, int left, int right) {
        int l = left, r = right;
        int m = sz[l];

        while (l < r) {
            while (l < r && sz[r] >= m) {
                r--;
            }
            if (l < r) {
                sz[l] = sz[r];
                l++;
            }
            while (l < r && sz[l] < m) {
                l++;
            }
            if (l < r) {
                sz[r] = sz[l];
                r--;
            }
        }
        if (l == r) {
            sz[l] = m;
            l++;
            r--;
        }
        if (l < right) {
            kSortL1(sz, l, right);
        }
        if (left < r) {
            kSortL1(sz, left, r);
        }
    }

    /**
     * øÏÀŸ≈≈–Ú1
     * ÷–º‰
     *
     * @param sz
     * @param left
     * @param right
     */
    public static void kSortM2(int[] sz, int left, int right) {
        int l = left, r = right;
        int m = sz[l + (r - l) / 2];

        while (l < r) {
            while (sz[l] < m) {
                l++;
            }
            while (sz[r] > m) {
                r--;
            }
            if (l >= r) {
                break;
            }
            int tmp = sz[l];
            sz[l] = sz[r];
            sz[r] = tmp;

            if (sz[l] == m) {
                r--;
            }
            if (sz[r] == m) {
                l++;
            }
        }
        if (l == r) {
            l++;
            r--;
        }
        if (left < r) {
            kSortM2(sz, left, r);
        }
        if (l < right) {
            kSortM2(sz, l, right);
        }
    }

    /**
     * øÏÀŸ≈≈–Ú1
     * ◊Û±ﬂ
     *
     * @param sz
     * @param left
     * @param right
     */
    public static void kSortL2(int[] sz, int left, int right) {
        int l = left, r = right;
        int m = sz[l];
        while (l < r) {
            while (l < r && sz[r] >= m) {
                r--;
            }
            if (l < r) {
                sz[l] = sz[r];
                l++;
            }
            while (l < r && sz[l] < m) {
                l++;
            }
            if (l < r) {
                sz[r] = sz[l];
                r--;
            }
        }
        if (l == r) {
            sz[l] = m;
            l++;
            r--;
        }
        if (left < r) {
            kSortL2(sz, left, r);
        }
        if (l < right) {
            kSortL2(sz, l, right);
        }

    }

    /**
     * πÈ≤¢¡∑œ∞1
     *
     * @param sz
     * @param left
     * @param right
     * @param tmp
     */
    public static void gSort1(int[] sz, int left, int right, int[] tmp) {
        if (left < right) {
            int m = left + (right - left) / 2;
            gSort1(sz, left, m, tmp);
            gSort1(sz, m + 1, right, tmp);
            gSort1(sz, left, m, right, tmp);
        }
    }

    public static void gSort1(int[] sz, int left, int m, int right, int[] tmp) {
        int i = left;
        int j = m + 1;
        int idx = 0;

        while (i <= m && j <= right) {
            if (sz[i] < sz[j]) {
                tmp[idx++] = sz[i++];
            } else {
                tmp[idx++] = sz[j++];
            }
        }
        while (i <= m) {
            tmp[idx++] = sz[i++];
        }
        while (j <= right) {
            tmp[idx++] = sz[j++];
        }
        idx = 0;
        i = left;
        while (i <= right) {
            sz[i++] = tmp[idx++];
        }
    }

    /**
     * πÈ≤¢≈≈–Ú2
     *
     * @param sz
     * @param left
     * @param right
     * @param tmp
     */
    public static void gSort2(int[] sz, int left, int right, int[] tmp) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            gSort2(sz, left, mid, tmp);
            gSort2(sz, mid + 1, right, tmp);
            gSort2(sz, left, mid, right, tmp);
        }
    }

    public static void gSort2(int[] sz, int left, int mid, int right, int[] tmp) {
        int i = left, j = mid + 1;
        int idx = 0;

        while (i <= mid && j <= right) {
            if (sz[i] < sz[j]) {
                tmp[idx++] = sz[i++];
            } else {
                tmp[idx++] = sz[j++];
            }
        }

        while (i <= mid) {
            tmp[idx++] = sz[i++];
        }

        while (j <= right) {
            tmp[idx++] = sz[j++];
        }

        i = left;
        idx = 0;
        while (i <= right) {
            sz[i++] = tmp[idx++];
        }
    }
}


