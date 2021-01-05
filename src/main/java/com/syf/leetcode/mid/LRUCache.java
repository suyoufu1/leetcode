package com.syf.leetcode.mid;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @auth syf
 * @date 2020/9/21 13:02
 * @des LRU缓存机制
 */
public class LRUCache {
    public static void main(String[] args) {
        LRUC lruc = new LRUC(10);
        lruc.put(1,2);
        lruc.get(1);
    }
}

/**
 * 获取数据 get(key) - 如果关键字 (key) 存在于缓存中，则获取关键字的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字/值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 */
class LRUC {
    /**
     * 用哈希表+双向链表来实现
     *      哈希表存储节点数据，当在哈希查询的时候，先从哈希表中查找，然后定位到链表中，将链表的值移动到头节点中；
     *      哈希的目的就是来判断是否最近使用还是最久使用，让链表进行移动
     */
    /**
     * 定义双向链表
     */
    class DLinkMap{
        int key ;
        int value;
        DLinkMap pre;
        DLinkMap next ;
        public DLinkMap(){};
        public DLinkMap(int key , int value){
            this.key = key ;
            this.value = value ;
        }
    }
    private Map<Integer,DLinkMap> cache = new HashMap<>();
    int size ; //统计缓存大小
    int capacity;
    DLinkMap head,tail ;
    public LRUC(int capacity) {
        size = 0 ;
        this.capacity = capacity ;
        head = new DLinkMap();
        tail = new DLinkMap();
        head.next = tail ;
        tail.pre = head ;
    }

    public int get(int key) {
        // 先查双链表
        DLinkMap node = cache.get(key);
        if(node == null){
            return -1;
        }
        // 移动到头节点
        movaToHead(node);
        return node.value ;
    }

    /**
     * 移动到头节点
     * @param node
     */
    private void movaToHead(DLinkMap node) {
        removeNode(node);
        addToHead(node);
    }

    private void addToHead(DLinkMap node) {
        node.pre = head ;
        node.next = head.next ;
        head.next = node;
        head.next.pre = node;
    }

    private void removeNode(DLinkMap node) {
        node.pre.next = node.next ;
        node.next.pre = node.pre ;
    }

    public void put(int key, int value) {
        // 查找节点是否存中
        DLinkMap node = cache.get(key);
        if(node == null){
            //新建节点
            DLinkMap newNode = new DLinkMap(key,value);
            //添加进哈希表
            cache.put(key,newNode);
            //移动到头节点
            movaToHead(newNode);
            size ++ ;
            // 缓存满了就要删除最久未使用的节点
            if(size > capacity){
                DLinkMap oldNode = removeToTail();
                cache.remove(oldNode.key);
                -- size;
            }
        }else {
            // 如果 key 存在，先通过哈希表定位，再修改 value，并移到头部
            node.value = value;
            movaToHead(node);
        }
    }

    private DLinkMap removeToTail() {
        DLinkMap pre = tail.pre;
        removeNode(pre);
        return pre;
    }
}

class LRUCa extends LinkedHashMap<Integer,Integer>{
    private int capacity;

    public LRUCa(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}

