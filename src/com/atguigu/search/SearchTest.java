package com.atguigu.search;

public class SearchTest {
    public static void main(String[] args) {
//        int arr[] = {1, 8, 10, 89, 1000, 1000, 1234};
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        //
        int resIndex = binarySearch(arr, 0, arr.length - 1, 20);
        System.out.println("resIndex=" + resIndex);
    }

    /**
     * 二分查找法
     *
     * @param arr
     * @param left
     * @param right
     * @param findVal
     * @return
     */
    public static int binarySearch(int[] arr, int left, int right, int findVal) {
        System.out.println("search...");
        if (left > right) {
            return -1;
        }
        int m = (left + right) / 2;
        if (findVal < arr[m]) {
            return binarySearch(arr, left, m - 1, findVal);
        } else if (arr[m] < findVal) {
            return binarySearch(arr, m + 1, right, findVal);
        } else {
            return m;
        }
    }

    public static int binarySearch2(int[] arr, int left, int right, int findVal) {
        System.out.println("search...");
        if (left > right || findVal < arr[0] || findVal > arr[arr.length - 1]) {
            return -1;
        }
        int m = left + (right - left) * (findVal - arr[left]) / (arr[right] - arr[left]);
        if (findVal < arr[m]) {
            return binarySearch(arr, left, m - 1, findVal);
        } else if (arr[m] < findVal) {
            return binarySearch(arr, m + 1, right, findVal);
        } else {
            return m;
        }
    }

}
