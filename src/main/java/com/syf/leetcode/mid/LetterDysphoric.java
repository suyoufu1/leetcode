package com.syf.leetcode.mid;

import java.util.*;

/**
 * @auth syf
 * @date 2020/12/1 20:00
 */
public class LetterDysphoric {
    /**
     * 给定一个字符串数组，将字母异位词组合在一起。
     * 字母异位词指字母相同，但排列不同的字符串。
     * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
     * 输出:
     * [
     *   ["ate","eat","tea"],
     *   ["nat","tan"],
     *   ["bat"]
     * ]
     */
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = groupAnagrams(strs);
        System.out.println(lists);
    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        // 哈希来解决
        Map<String,List<String>> cacheMap = new HashMap<>();
        for(String str : strs){
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            String key = String.valueOf(ch);
            if(cacheMap.containsKey(key)){
                cacheMap.get(key).add(str);
            }else {
                cacheMap.put(key,new ArrayList(Collections.singleton(str)));
            }
        }
        return new ArrayList<>(cacheMap.values());
    }

    private static String sortStr(String str1) {
        String str = str1;
        char[] ch = str.toCharArray();
        Arrays.sort(ch);
        String orderStr = String.valueOf(ch);
        return orderStr;
    }
}
