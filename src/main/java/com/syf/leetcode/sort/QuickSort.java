package com.syf.leetcode.sort;

/**
 * 快速排序算法
 *  找到一个基点，然后大于这个基点的值存储到右边，小于存储左边
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {6,1,5,4,3,5};
        arr = quickSort(arr,0,arr.length-1);
        for (int x: arr) {
            System.out.println(x);
        }
    }
    private static int[]  quickSort(int[] arr, int left, int right) {
        if(left < right){
            //找到基准点
            int partitionIndex = partitionSort(arr,left,right);
            //递归
            quickSort(arr,left,partitionIndex-1);
            quickSort(arr,partitionIndex+1,right);
        }
        return arr ;
    }

    /**
     * 比基点小的放到左边，大的放到右边
     * @param arr
     * @param left
     * @param right
     * @return
     */
    private static int partitionSort(int[] arr, int left, int right) {
        //基准点
        int p = left ;
        int index = p + 1 ;
        for(int i = index ; i <= right ; i ++){
            if(arr[i]<arr[p]){
                swap(arr, i, p);
                index ++ ;
            }
        }
        /**
         * 6 1 2 3 4 9 8 7
         *  把基准点移动到中间位置
         */
        swap(arr,p,index-1);
        return index-1;
    }

    private static void swap(int[] arr, int i, int p) {
        int temp = arr[i] ;
        arr[i] = arr[p];
        arr[p] = temp ;
    }


    //快速排序
    public  static void quick_sort(int s[], int l, int r)
    {
        if (l < r)
        {
            //Swap(s[l], s[(l + r) / 2]); //将中间的这个数和第一个数交换
            int i = l, j = r, x = s[l];
            while (i < j)
            {
                while(i < j && s[j] >= x) // 从右向左找第一个小于x的数
                    j--;
                if(i < j)
                    s[i++] = s[j];

                while(i < j && s[i] < x) // 从左向右找第一个大于等于x的数
                    i++;
                if(i < j)
                    s[j--] = s[i];
            }
            s[i] = x;
            quick_sort(s, l, i - 1); // 递归调用
            quick_sort(s, i + 1, r);
        }
    }

}
