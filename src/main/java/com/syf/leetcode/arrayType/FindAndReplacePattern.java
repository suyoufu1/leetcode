package com.syf.leetcode.arrayType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName
 * @Author syf
 * @Date 2021/1/5
 * @Version
 * 查找和替换模式
 */
public class FindAndReplacePattern {
    // 双映射
    public static void main(String[] args) {
        String[] words ={};
        String pattern = "";
        List<String> res = new ArrayList<> ();
        findAndReplacePattern(pattern,words,res);
    }

    private static void findAndReplacePattern(String pattern, String[] words, List<String> res) {
        if(pattern.length () < 1 || words.length < 1 ){
            return;
        }
        for(String word : words){
            if(match(word,pattern)){
                res.add ( word );
            }
        }
    }

    /**
     * 模式匹配
     * @param word 单词
     * @param pattern 模式
     * @return
     */
    private static boolean match(String word, String pattern) {
        // 双映射
        Map<Character,Character> mapW = new HashMap<> ();
        Map<Character,Character> mapP = new HashMap<> ();
        for (int i = 0 ; i < word.length () ; i ++){
            char w = word.charAt ( i ) ;
            char p = pattern.charAt ( i ) ;
            if (!mapW.containsKey ( w)){
                mapW.put (w,p );
            }
            if (!mapP.containsKey (p)){
                mapP.put ( p,w );
            }
            // 判断是否满足条件
            if(mapW.get ( w ) != p || mapP.get ( p )!=w){
                return false ;
            }
        }
        return true;
    }
    // 利用索引来解决
    private static boolean match2(String word, String pattern) {
        for (int i = 0 ; i < word.length () ; i ++){
            char w = word.charAt ( i ) ;
            char p = pattern.charAt ( i ) ;
            if(word.indexOf ( w ) != pattern.indexOf ( p )){
                return false ;
            }
        }
        return true;
    }
}
