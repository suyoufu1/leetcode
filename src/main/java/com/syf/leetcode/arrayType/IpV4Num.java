package com.syf.leetcode.arrayType;

/**
 * @ClassName
 * @Author syf
 * @Date 2021/1/5
 * @Version
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 统计满足条件的ipv4，保存起来
 *  怎么样来计算呢？
 *      分析问题->可以利用深度遍历进行递归，将不满足条件的进行过滤，也就是剪枝。用到回溯法
 * @author Administrator
 */

public class IpV4Num {
    private static List<String> res = new ArrayList<> ();
    private static final Integer SEGNUM = 4 ;
    public static void main(String[] args) {
        String a = "25525511135" ;
        int[] segments = new int[SEGNUM];
        dfs(a,0,0,segments);
        System.out.println (res);
    }

    /**
     *
     * @param a 字符串
     * @param start 开始索引位置
     * @param num 记录次数
     */
    private static void dfs(String a, int start, int num , int[] segments) {
        // 出口
        if(num == SEGNUM){
            if(start == a.length ()){
                StringBuffer sb = new StringBuffer ();
                for(int i = 0 ; i < 3 ; i ++){
                    sb.append ( segments[i] ).append ( "." );
                }
                sb.append ( segments[3] );
                res.add ( sb.toString () );
            }
            return;
        }
        // 边界条件
        if (start == a.length ()){
            return;
        }
        if (a.charAt ( start )=='0'){
            segments[start] = 0 ;
            dfs ( a,start + 1, num + 1,segments );
        }
        int temp = 0 ;
        for (int end = start ; end < a.length () ; end ++){
            temp = temp * 10 + a.charAt ( end )-'0';
            if(temp > 0 && temp <= 255){
                segments[num] = temp;
                dfs ( a,end+1,num+1,segments );
            }else { // 回溯
                break;
            }
        }
    }
}
