package com.syf.leetcode.mid;

import java.util.*;

/**
 * @auth syf
 * @date 2020/9/26 21:12
 * @des 前K个高频单词
 */
public class TopKFrequent {
    public static void main(String[] args) {
        String[] s = {"i", "love", "leetcode", "i", "love", "coding"};
        List<String> list = topKFrequent2(s, 2);
        System.out.println(list);
    }

    /**
     * 计算每个单词的频率，并使用使用这些频率的自定义排序关系对单词进行排序。然后取前 k
     * @param words
     * @param k
     * @return
     */
    public static List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> map = new HashMap<>();
        for(String s : words){
            map.put(s,map.getOrDefault(s,0)+1);
        }
        List<String> list = new ArrayList<>(map.keySet());
        //如果相等，则按照字符顺序排序，否则按照出现次数排序
        Collections.sort(list,(o1,o2)->map.get(o1).equals(map.get(o2)) ?
                o1.compareTo(o2) : (map.get(o2) - map.get(o1)));
        return list.subList(0,k);
    }

    /**
     * 用即小堆来实现 前k个就是需要打印的，然后翻转
     * @param words
     * @param k
     * @return
     */
    public static List<String> topKFrequent2(String[] words, int k){
        Map<String,Integer> map = new HashMap<>();
        for(String s : words){
            map.put(s,map.getOrDefault(s,0)+1);
        }
        //定义即小堆,从小到大排序
        PriorityQueue<String> priorityQueue = new PriorityQueue<>((o1, o2) ->
                map.get(o1).equals(map.get(o2))
        ? o2.compareTo(o1) : map.get(o1) - map.get(o2));
        //存入即小堆
        for(String s : map.keySet()){
            priorityQueue.offer(s);
            if(priorityQueue.size() > k){
                priorityQueue.poll();
            }
        }
        List<String> res = new ArrayList<>();
        while (!priorityQueue.isEmpty()){
            res.add(priorityQueue.poll());
        }
        Collections.reverse(res);
        return res;
    }


}
