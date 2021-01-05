package com.syf.leetcode.easy;

/**
 * @auth syf
 * @date 2020/9/20 13:53
 * @des 验证回文字符串 Ⅱ
 * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "aba"
 * 输出: True
 * 示例 2:
 * <p>
 * 输入: "abca"
 * 输出: True
 * 解释: 你可以删除c字符。
 */
public class ValidPalindrome {
    public static void main(String[] args) {
        String a = "abc";
        boolean b = validPalindrome(a);
        System.out.println(b);
    }

    /**
     * 双指针方法 + 贪心算法（局部最优）
     * @param a
     * @return
     */
    private static boolean validPalindrome(String a) {
        int low = 0 , high = a.length() -1 ;
        StringBuffer res = new StringBuffer(a);
        //本身就是回文串
        if(res.reverse().toString().equals(a)){
            return true;
        }
        while (low <= high){
            if(a.charAt(low ) == a.charAt(high)){
                low  ++ ;
                high -- ;
            }else {
                boolean flag1 = true , flag2 = true ;
                for(int i = low + 1 , j = high; i <= j ; i ++, j--){
                    if(a.charAt(i) != a.charAt(j)){
                        flag1 = false;
                        break;
                    }
                }
                for(int i = low  , j = high - 1 ; i <= j ; i ++, j--){
                    if(a.charAt(i) != a.charAt(j)){
                        flag2 = false;
                        break;
                    }
                }
                return flag1 || flag2;
            }
        }
        return true;
    }
}
