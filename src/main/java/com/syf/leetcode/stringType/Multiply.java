package com.syf.leetcode.stringType;


/**
 * @auth syf
 * @date 2021/1/4 13:43
 */
// 两字符串相乘
public class Multiply {
    public static void main(String[] args) {
        String a = "123" ;
        String b = "324" ;
        String sum = multiply(a , b);
        System.out.println(sum);
    }

    private static String multiply(String a, String b) {
        if(a.length() < 1 && b.length() < 1 ){
            return null;
        }
        if(a.length() < 1){
            return b;
        }
        if(b.length() < 1){
            return a ;
        }
        // 单个字符从左往右进行相乘，如果大于10，求模
        int flag = 0 ;
        StringBuffer sum = new StringBuffer() ;
        int i = a.length() - 1 , j = b.length() - 1 ;
        for (; i >= 0 ; i --){
            for (; j >= 0 ; j --){
                int temp = a.charAt(i)-'0' * b.charAt(j)-'0';
                if(temp < 10){

                }else {

                }
            }
        }
        if (i>=0){
            sum.append(Integer.valueOf(a.substring(i,a.length()))+ flag);
        }
        if (j >= 0){
            sum.append(Integer.valueOf(a.substring(j,b.length()))+ flag);
        }
        return sum.toString();
    }
}
