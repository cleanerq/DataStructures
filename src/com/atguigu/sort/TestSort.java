package com.atguigu.sort;

/**
 * ¡∑œ∞≈≈–Ú
 */
public class TestSort {
    public static void main(String[] args) {
        int length = 80000;
        int[] sz = new int[length];
        for (int i = 0; i < length; i++) {
            sz[i] = (int) (Math.random() * length * 10);
        }
//        System.out.println(" ≈≈–Ú«∞: " + Arrays.toString(sz));
        long s = System.currentTimeMillis();
        xSort(sz);
        long e = System.currentTimeMillis();
//        System.out.println(" ≈≈–Ú∫Û: " + Arrays.toString(sz));
        System.out.println(" æ≠π˝ ±º‰£∫" + (e - s) + "ms");
    }

    /**
     * √∞≈›≈≈–Ú
     *
     * @param sz
     */
    public static void mSort(int[] sz) {
        // –°”≈ªØ ≈–∂œ «∑Ò“—æ≠≈≈–Úπ˝
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
                System.out.println("√ª”–≈≈–ÚÕÀ≥ˆ—≠ª∑");
                break;
            } else {
                flag = false;
            }
        }
    }

    /**
     * —°‘Ò≈≈–Ú
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
     * ≤Â»Î≈≈–Ú
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
     * œ£∂˚≈≈–Ú
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
}
