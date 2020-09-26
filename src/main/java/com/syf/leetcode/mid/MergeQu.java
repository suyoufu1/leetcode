package com.syf.leetcode.mid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @auth syf
 * @date 2020/9/26 11:08
 * @des  合并区间
 */
public class MergeQu {
    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        int[][] merge = merge(intervals);
        for(int[] ints : merge){
            for(int x : ints){
                System.out.print(x+" ");
            }
            System.out.println();
            System.out.println("===========");
        }
    }

    /**
     * 用list保存数据集
     * @param intervals
     * @return
     */
    private static int[][] merge(int[][] intervals) {
        int len = intervals.length ;
        if(len < 2){
            return intervals;
        }
        //先排序
        Arrays.sort(intervals,(o1,o2)->o1[0]-o2[0]);
        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);
        for (int i = 1 ; i < len ; i ++){
            int[] current = intervals[i];
            int[] peek = res.get(res.size() - 1);
            if(current[0]>peek[1]){
                res.add(current);
            }else {
                //取区间中的最大值
                peek[1] = Math.max(peek[1],current[1]);
            }
        }
        return res.toArray(new int[res.size()][]);
    }

    public static int[][] merge2(int[][] intervals) {
        //排序
        Arrays.sort(intervals,(o1,o2)->o1[0] - o2[0]);
        //两两合并
        int[][] res = new int[intervals.length][2];
        //标志位
        int d = -1 ;
        //遍历
        for(int[] ints : intervals){
            if(d == -1 || ints[0]>intervals[d][1]){
                res[++d] = ints;
            }else {
                res[d][1] = Math.max(intervals[d][1],ints[1]);
            }
        }
        return Arrays.copyOf(res,d+1);
    }
}
