package com.atguigu.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {-9, 78, 0, 23, -567, 70, -1, 900, 4561};
        System.out.println("arr=" + Arrays.toString(arr));

        //���Կ��ŵ�ִ���ٶ�
        // ����Ҫ��80000�������������
//        int[] arr = new int[8000000];
//        for (int i = 0; i < 8000000; i++) {
//            arr[i] = (int) (Math.random() * 8000000); // ����һ��[0, 8000000) ��
//        }

        System.out.println("����ǰ");
        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("����ǰ��ʱ����=" + date1Str);

        quickSort(arr, 0, arr.length - 1);

        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("����ǰ��ʱ����=" + date2Str);
        System.out.println("arr=" + Arrays.toString(arr));
    }

    /**
     * �� (l+h)/2 �м�ֵΪ��׼
     *
     * 1234567
     *
     * @param arr
     * @param left
     * @param right
     */
    public static void quickSort(int[] arr, int left, int right) {
        int l = left; //���±�
        int r = right; //���±�
        //pivot ����ֵ
        int pivot = arr[(left + right) / 2];
        int temp = 0; //��ʱ��������Ϊ����ʱʹ��
        //whileѭ����Ŀ�����ñ�pivot ֵС�ŵ����
        //��pivot ֵ��ŵ��ұ�
        while (l < r) {
            //��pivot�����һֱ��,�ҵ����ڵ���pivotֵ,���˳�
            while (arr[l] < pivot) {
                l += 1;
            }
            //��pivot���ұ�һֱ��,�ҵ�С�ڵ���pivotֵ,���˳�
            while (arr[r] > pivot) {
                r -= 1;
            }
            //���l >= r˵��pivot ����������ֵ���Ѿ��������ȫ����
            //С�ڵ���pivotֵ���ұ�ȫ���Ǵ��ڵ���pivotֵ
            if (l >= r) {
                break;
            }

            //����
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            //���������󣬷������arr[l] == pivotֵ ��� r--�� ǰ��
            // arr[l]��ֵ���� arr[r]��ֵ
            // ����ұߵ�ֵ���� pivotֵ
            // ��ʱ r�ұߵ�ֵ���Ѿ��ȽϹ��� ����Ҫ��1 ��ǰ�ƶ� �������бȽ�
            if (arr[l] == pivot) {
                r -= 1;
            }

            //���������󣬷������arr[r] == pivotֵ ��� l++�� ����
            // arr[r]��ֵ���� arr[l]��ֵ
            // �����ߵ�ֵ���� pivotֵ
            // ��ʱ l��ߵ�ֵ���Ѿ��ȽϹ��� ����Ҫ��1 ����ƶ� �������бȽ�
            if (arr[r] == pivot) {
                l += 1;
            }
        }
        // ��ʱl=r ���� ��ߵ�ֵ���Ȼ�׼ֵxС �ұߵ�ֵ�Ȼ�׼ֵx��
        // �����whileѭ�����˳���������l==r
        // ��� l == r, ����l++, r--, ����Ϊ����ջ���
        System.out.println(l);
        if (l == r) {
            l += 1;
            r -= 1;
        }

        //����ݹ� ��ʱr��Ϊ�µ�l
        if (left < r) {
            quickSort(arr, left, r);
        }
        //���ҵݹ� ��ʱl��Ϊ�µ�r
        if (right > l) {
            quickSort(arr, l, right);
        }
    }

    /**
     * ��left��0��Ϊ��׼ֵ
     * <p>
     * 1��i = L; j = R; ����׼���ڳ��γɵ�һ����a[i]��
     * 2��j--�ɺ���ǰ�ұ���С�������ҵ����ڳ�������ǰһ����a[i]�С�
     * 3��i++��ǰ����ұ�����������ҵ���Ҳ�ڳ������ǰһ����a[j]�С�
     * 4�����ظ�ִ��2��3������ֱ��i==j������׼������a[i]�С�
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
                    // ���������ҵ�һ��С��x����
                    j--;
                }
                if (i < j) {
                    // ���������ҵ��˱�xС����
                    arr[i] = arr[j];
                    i++;
                }

                while (i < j && arr[i] < x) {
                    // ���������ҵ�һ������x����
                    i++;
                }
                if (i < j) {
                    arr[j] = arr[i];
                    j--;
                }
            }
            // ��ʱi=j ���� i��ߵ�ֵ����xС �ұߵ�ֵ��x��
            arr[i] = x;
            // ����ֱ���������׼ֵ�������ߵ���ݹ���ҵݹ�
            quickSortZero(arr, l, i - 1);
            quickSortZero(arr, i + 1, r);
        }
    }
}
