package com.syf.leetcode.easy;

import org.jetbrains.annotations.NotNull;

/**
 * @auth syf
 * @date 2020/9/20 13:07
 * @des 字符串相加
 * "3876620623801494171"
 * "6529364523802684779"
 */
public class AddStrings {
    public static void main(String[] args) {
        String num1 = "123";
        String num2 = "123";
        String sum = addStrings(num1, num2);
        System.out.println(sum);
    }

    /**
     * 自主实现
     * @param num1
     * @param num2
     * @return
     */
    private static @NotNull String addStrings(String num1, String num2) {
        int i = num1.length() - 1 ;
        int j  = num2.length() - 1 ;
        int flag = 0 ;
        StringBuffer res = new StringBuffer();
        while (i>=0 && j >= 0){
            int temp = num1.charAt(i) - '0' + num2.charAt(j) - '0';
            if(temp >= 10){
                flag = 1 ;
                temp = temp % 10 ;
            }else {
                temp =(temp + flag) % 10;
                flag = 0 ;
            }
            i -- ;
            j -- ;
            res.append(temp);
        }
        while (i >= 0){
            res.append(num1.charAt(i));
        }
        while (j >= 0){
            res.append(num1.charAt(j));
        }
        if(flag != 0){
            res.append(flag);
        }
        return res.reverse().toString();
    }

    /**
     * 模拟
     * @param num1
     * @param num2
     * @return
     */
    private static String addStrings2(String num1, String num2){
        int i = num1.length() - 1 , j = num2.length() -1;
        int add = 0 ;
        StringBuffer res = new StringBuffer();
        while (i >= 0 || j >= 0 || add != 0){
            int x = i >= 0 ? num1.charAt(i) - '0' : 0 ;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0 ;
            int temp = x + y +add;
            res.append(temp % 10);
            add = temp/10 ;
            j -- ;
            i -- ;
        }
        return res.reverse().toString();
    }

    public static String kuangjia(String param1 , String param2){
        int i = param1.length() - 1, j = param2.length() - 2, add=0 ;
        while (i >= 0 || j >= 0 || add !=0){
            // 写业务逻辑
        }
        return "";
    }
}
