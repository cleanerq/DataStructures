package com.atguigu.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {-9, 78, 0, 23, -567, 70, -1, 900, 4561};
        System.out.println("arr=" + Arrays.toString(arr));

        //测试快排的执行速度
        // 创建要给80000个的随机的数组
//        int[] arr = new int[8000000];
//        for (int i = 0; i < 8000000; i++) {
//            arr[i] = (int) (Math.random() * 8000000); // 生成一个[0, 8000000) 数
//        }

        System.out.println("排序前");
        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是=" + date1Str);

        quickSort(arr, 0, arr.length - 1);

        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序前的时间是=" + date2Str);
        System.out.println("arr=" + Arrays.toString(arr));
    }

    /**
     * 以 (l+h)/2 中间值为基准
     *
     * 1234567
     *
     * @param arr
     * @param left
     * @param right
     */
    public static void quickSort(int[] arr, int left, int right) {
        int l = left; //左下标
        int r = right; //右下标
        //pivot 中轴值
        int pivot = arr[(left + right) / 2];
        int temp = 0; //临时变量，作为交换时使用
        //while循环的目的是让比pivot 值小放到左边
        //比pivot 值大放到右边
        while (l < r) {
            //在pivot的左边一直找,找到大于等于pivot值,才退出
            while (arr[l] < pivot) {
                l += 1;
            }
            //在pivot的右边一直找,找到小于等于pivot值,才退出
            while (arr[r] > pivot) {
                r -= 1;
            }
            //如果l >= r说明pivot 的左右两的值，已经按照左边全部是
            //小于等于pivot值，右边全部是大于等于pivot值
            if (l >= r) {
                break;
            }

            //交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            //如果交换完后，发现这个arr[l] == pivot值 相等 r--， 前移
            // arr[l]的值就是 arr[r]的值
            // 如果右边的值就是 pivot值
            // 这时 r右边的值都已经比较过了 所以要减1 向前移动 继续进行比较
            if (arr[l] == pivot) {
                r -= 1;
            }

            //如果交换完后，发现这个arr[r] == pivot值 相等 l++， 后移
            // arr[r]的值就是 arr[l]的值
            // 如果左边的值就是 pivot值
            // 这时 l左边的值都已经比较过了 所以要加1 向后移动 继续进行比较
            if (arr[r] == pivot) {
                l += 1;
            }
        }
        // 这时l=r 并且 左边的值都比基准值x小 右边的值比基准值x大
        // 上面的while循环的退出条件就是l==r
        // 如果 l == r, 必须l++, r--, 否则为出现栈溢出
        System.out.println(l);
        if (l == r) {
            l += 1;
            r -= 1;
        }

        //向左递归 这时r作为新的l
        if (left < r) {
            quickSort(arr, left, r);
        }
        //向右递归 这时l作为新的r
        if (right > l) {
            quickSort(arr, l, right);
        }
    }

    /**
     * 以left（0）为基准值
     * <p>
     * 1．i = L; j = R; 将基准数挖出形成第一个坑a[i]。
     * 2．j--由后向前找比它小的数，找到后挖出此数填前一个坑a[i]中。
     * 3．i++由前向后找比它大的数，找到后也挖出此数填到前一个坑a[j]中。
     * 4．再重复执行2，3二步，直到i==j，将基准数填入a[i]中。
     *
     * @param arr
     * @param l   left
     * @param r   right
     */
    public static void quickSortZero(int[] arr, int l, int r) {
        if (l < r) {
            int i = l, j = r, x = arr[l];
            while (i < j) {
                while (i < j && arr[j] >= x) {
                    // 从右向左找第一个小于x的数
                    j--;
                }
                if (i < j) {
                    // 从右向左找到了比x小的数
                    arr[i] = arr[j];
                    i++;
                }

                while (i < j && arr[i] < x) {
                    // 从左向右找第一个大于x的数
                    i++;
                }
                if (i < j) {
                    arr[j] = arr[i];
                    j--;
                }
            }
            // 这时i=j 并且 i左边的值都比x小 右边的值比x大
            arr[i] = x;
            // 下面分别进行数组基准值左右两边的左递归和右递归
            quickSortZero(arr, l, i - 1);
            quickSortZero(arr, i + 1, r);
        }
    }
}
