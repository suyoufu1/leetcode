package com.syf.leetcode.easy;

import java.util.*;

/**
 * @auth syf
 * @date 2020/9/20 14:27
 * 最常见的单词
 * 给定一个段落 (paragraph) 和一个禁用单词列表 (banned)。返回出现次数最多，同时不在禁用列表中的单词。
 * 题目保证至少有一个词不在禁用列表中，而且答案唯一。
 * 禁用列表中的单词用小写字母表示，不含标点符号。段落中的单词不区分大小写。答案都是小写字母。
 * 示例：
 * <p>
 * 输入:
 * paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
 * banned = ["hit"]
 * 输出: "ball"
 * 解释:
 * "hit" 出现了3次，但它是一个禁用的单词。
 * "ball" 出现了2次 (同时没有其他单词出现2次)，所以它是段落里出现次数最多的，且不在禁用列表中的单词。
 * 注意，所有这些单词在段落里不区分大小写，标点符号需要忽略（即使是紧挨着单词也忽略， 比如 "ball,"），
 * "hit"不是最终的答案，虽然它出现次数更多，但它在禁用单词列表中。
 */
public class MostCommonWord {
    public static void main(String[] args) {
        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] banned = {"hit"};
        String res = mostWordCount(paragraph, banned);
        System.out.println(res);
    }

    private static String mostCommonWord(String paragraph, String[] banned) {
        String[] s = paragraph.split("[!?',;. ]");
        Set<String> set = new HashSet<>();
        for (String b : banned) {
            set.add(b);
        }
        Map<String, Integer> map = new HashMap();
        for (String t : s) {
            if (set.contains(t.toLowerCase())) {
                continue;
            }
            if (t.equals("")) {
                continue;
            }
            if (!map.containsKey(t.toLowerCase())) {
                map.put(t.toLowerCase(), 1);
            } else {
                Integer num = map.get(t.toLowerCase());
                map.put(t.toLowerCase(), num + 1);
            }
            /*Integer cnt = map.getOrDefault(t, 0);
            map.put(t,cnt+1);*/
        }
        int count = 0;
        String res = "";
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > count) {
                count = entry.getValue();
                res = entry.getKey();
            }
        }
        return res;
    }

    /**
     * 用什么数据结构：
     *      1.hashMap<String,Integer>
     *      2.set<String>
     */
    public static String mostWordCount(String param , String[] banned){
        Map<String,Integer> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        for (String str : banned){
            set.add(str);
        }
        String[] strings = param.split("[!',. ]");
        for(String string : strings){
            if(set.contains(string.toLowerCase())){
                continue;
            }
            if(string == ""){
                continue;
            }

            if(!map.containsKey(string.toLowerCase())){
                map.put(string.toLowerCase(),1);
            }else {
                Integer value = map.get(string);
                map.put(string.toLowerCase(),value+1);
            }
        }
        int count = 0 ;
        String res = "";
        for(Map.Entry<String,Integer> entry : map.entrySet()){
            Integer value = entry.getValue();
            if (count < value){
                count = value ;
                res = entry.getKey();
            }
        }
        return res ;
    }
}
