package com.syf.leetcode.arrayType;

/**
 * @auth syf
 * @date 2021/1/4 15:05
 */
// 两数相加
public class TwoSum2 {
    public static void main(String[] args) {
        String a = "123" ;
        String b = "345" ;
        String res = multiply(a,b);
        System.out.println(res);
    }

    private static String multiply(String a, String b) {
        if(a == "0" || b == "0") return "0";
        if(a == "1" ) return b ;
        if(b == "1") return a ;
        // 字符 乘以 字符串
        int i = a.length() - 1 ;
        String res = "" ;
        for(int j = 0 ; i >= 0 ; i --){ // j表示b缺少多少位，进行补位
            String mulRes = mulRes(b,a.charAt(i));//字符 乘以 字符串
            // 补零 左边补零
            for(int k = 0 ; k < j ; k ++){
                mulRes += "0" ;
            }
            res = twoSum(res, mulRes);
            j ++ ;
        }
        return res;
    }

    private static String mulRes(String b, char c) {
        int flag = 0 ;
        String res = "" ;
        for(int i = b.length()-1 ; i >= 0 ; i --){
            int temp = (b.charAt(i)-'0') * (c - '0') + flag ;
            res = String.valueOf(temp % 10)+res;
            flag = temp / 10 ;
        }
        if (flag != 0 ){
            res = String.valueOf(flag)+res;
        }
        return res ;
    }

    // 双指针 从末尾开始遍历
    private static String twoSum(String a, String b) {
        if (a == "" || a == "0") return b ;
        if (b == "" || b == "0") return a ;
        int m = a.length() - 1 ;
        int n = b.length() - 1;
        int flag = 0 ;
        String res = "";
        while (n >= 0 || m >= 0){
            int x = n >= 0 ? a.charAt(n)-'0' : 0 ;
            int y = m >= 0 ? b.charAt(m)-'0' : 0 ;
            res = String.valueOf((x+y)%10+flag) +res;
            flag = (x+y)/10 ;
            if(n >= 0 ) n-- ;
            if(m >= 0) m --;
        }
        if(flag != 0){
            res = "1" + res;
        }
        return res ;
    }
}
