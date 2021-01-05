package com.syf.leetcode.easy;

/**
 * @auth syf
 * @date 2020/9/19 20:38
 * @des 验证回文串
 */
public class Palindrome {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        boolean b = isPalindrome2(s);
        System.out.println(b);
    }
    /**
     * 判断+筛选
     * @param s
     * @return
     */
    private static boolean isPalindrome(String s) {
        //以忽略字母的大小写
        s = s.toLowerCase();
        //只考虑字母和数字字符
        String[] st = s.split("[^a-z0-9]");
        StringBuffer sb = new StringBuffer();
        for (String t : st){
            sb.append(t);
        }
        String s1 = sb.toString();
        String reverse = sb.reverse().toString();
        return reverse.equals(s1);
    }

    /**
     * 双指针
     * @param s
     * @return
     */
    private static boolean isPalindrome2(String s){
        if(s.length() <= 1){
            return true;
        }
        StringBuffer sb = new StringBuffer();
        for(int i = 0 ; i < s.length() ; i ++ ){
            if(Character.isLetterOrDigit(s.charAt(i))){
                sb.append(s.charAt(i));
            }
        }
        String st = sb.toString();
        st = st.toLowerCase();
        int j = 0 , k = st.length() - 1 ;
        while (j < k){
            if(st.charAt(j) != st.charAt(k)){
                return false;
            }
            j ++;
            k -- ;
        }
        return true;
    }
}
